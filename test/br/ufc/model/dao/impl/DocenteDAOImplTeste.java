package br.ufc.model.dao.impl;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF.PU;
import br.ufc.model.Docente;
import br.ufc.model.Sexo;
import br.ufc.model.dao.GenericDAO;
import br.ufc.util.DataUtil;

public class DocenteDAOImplTeste {

	static {

		DAOFactory.setPersistenceUnit(PU.TEST_PU);
	}

	private GenericDAO<Docente> docenteDAO = DAOFactory.createDAO(Docente.class);

	@Test
	public void cadastraDocenteCorretamente() {

		String CPF = cpfDeDocenteUnico();
		Docente docente = docenteSimples(CPF);

		docenteDAO.add(docente);

		Assert.assertNotNull(docente.getCPF());
	}

	@Test
	public void seCriarDocenteDeveEstarNoAll() {

		String CPF = cpfDeDocenteUnico();
		Docente docente = docenteSimples(CPF);

		docenteDAO.add(docente);

		Collection<Docente> allDocentes = docenteDAO.all();

		Assert.assertTrue(allDocentes.contains(docente));
	}

	@Test
	public void seRemoveDocenteNaoDeveEstarNoAll() {

		String CPF = cpfDeDocenteUnico();
		Docente docente = docenteSimples(CPF);

		docenteDAO.add(docente);
		docenteDAO.remove(docente);

		Collection<Docente> allDocentes = docenteDAO.all();

		Assert.assertFalse(allDocentes.contains(docente));
	}

	@Test
	public void seUpdateDocenteDeveMudarNoDB() {

		String CPF = cpfDeDocenteUnico();
		Docente docente = docenteSimples(CPF);

		docenteDAO.add(docente);

		String novoNome = docente.getNome() + "novo";
		Sexo novoSexo = OUTRO_SEXO_DO_DOCENTE_SIMPLES;
		Date novaData = DataUtil.addDia(DATA_DO_DOCENTE_SIMPLES, 1);

		docente.setNome(novoNome);
		docente.setSexo(novoSexo);
		docente.setNascimento(novaData);

		docenteDAO.update(docente);

		// TODO: atualizar quando puder buscar por id/matrícula
		Collection<Docente> allDocentes = docenteDAO.all();

		Docente docenteDoDB = null;
		for (Docente docenteDB : allDocentes) {
			if (docente.getMatricula().equals(docenteDB.getMatricula())) {
				docenteDoDB = docenteDB;
				break;
			}
		}

		Assert.assertEquals(novoNome, docenteDoDB.getNome());
		Assert.assertEquals(novoSexo, docenteDoDB.getSexo());
		Assert.assertEquals(novaData, docenteDoDB.getNascimento());
	}

	private static Integer CPFDocente = 0;
	private final static String NOME_DO_DOCENTE_SIMPLES = "Nome do Docente Default";
	private final static Sexo SEXO_DO_DOCENTE_SIMPLES = Sexo.HOMEM;
	private final static Sexo OUTRO_SEXO_DO_DOCENTE_SIMPLES = Sexo.OUTRO;
	private final static int ANO_DO_DOCENTE_SIMPLES = 1989;
	private final static int MES_DO_DOCENTE_SIMPLES = 10;
	private final static int DIA_DO_DOCENTE_SIMPLES = 29;
	private final static Date DATA_DO_DOCENTE_SIMPLES = DataUtil.date(DIA_DO_DOCENTE_SIMPLES, MES_DO_DOCENTE_SIMPLES,
			ANO_DO_DOCENTE_SIMPLES);

	private String cpfDeDocenteUnico() {
		return "011." + DocenteDAOImplTeste.CPFDocente++;
	}

	private Docente docenteSimples(String cpfDoDocente) {

		return new Docente.DocenteBuilder().nome(NOME_DO_DOCENTE_SIMPLES).CPF(cpfDoDocente).sexo(SEXO_DO_DOCENTE_SIMPLES)
				.dataDeNascimento(DATA_DO_DOCENTE_SIMPLES).build();
	}
}