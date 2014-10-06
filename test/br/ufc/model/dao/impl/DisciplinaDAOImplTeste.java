package br.ufc.model.dao.impl;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF.PU;
import br.ufc.model.Disciplina;
import br.ufc.model.dao.GenericDAO;

public class DisciplinaDAOImplTeste {

	static {

		DAOFactory.setPersistenceUnit(PU.TEST_PU);
	}

	private GenericDAO<Disciplina> disciplinaDAO = DAOFactory.createDAO(Disciplina.class);

	@Test
	public void cadastraDisciplinaCorretamente() {

		String codigo = codigoDeDisciplinaUnico();
		Disciplina disciplina = disciplinaSimples(codigo);

		disciplinaDAO.add(disciplina);

		Assert.assertNotNull(disciplina.getId());
	}

	@Test
	public void seCriarDisciplinaDeveEstarNoAll() {

		String codigo = codigoDeDisciplinaUnico();
		Disciplina disciplina = disciplinaSimples(codigo);

		disciplinaDAO.add(disciplina);

		Collection<Disciplina> allDisciplinas = disciplinaDAO.all();

		Assert.assertTrue(allDisciplinas.contains(disciplina));
	}

	@Test
	public void seRemoveDisciplinaDeveNaoEstarNoAll() {

		String codigo = codigoDeDisciplinaUnico();
		Disciplina disciplina = disciplinaSimples(codigo);

		disciplinaDAO.add(disciplina);
		disciplinaDAO.remove(disciplina);

		Collection<Disciplina> allDisciplinas = disciplinaDAO.all();

		Assert.assertFalse(allDisciplinas.contains(disciplina));
	}

	@Test
	public void seUpdateDisciplinaDeveAlterarNoBanco() {

		String codigo = codigoDeDisciplinaUnico();
		Disciplina disciplina = disciplinaSimples(codigo);

		disciplinaDAO.add(disciplina);

		String novoNome = disciplina.getNome() + "mudado";

		disciplina.setNome(novoNome);

		disciplinaDAO.update(disciplina);

		// TODO: mudar quando houver método para buscar por código/id
		Collection<Disciplina> allDisciplinas = disciplinaDAO.all();

		Disciplina disciplinaDoBD = null;
		for (Disciplina disciplinaBD : allDisciplinas) {
			// TODO: mudar quando o equals da disciplina estiver considerando apenas
			// o id
			if (disciplina.getId().equals(disciplinaBD.getId())) {
				disciplinaDoBD = disciplinaBD;
				break;
			}
		}

		// TODO: atualizar caso novos campos sejam adicionados
		Assert.assertEquals(novoNome, disciplinaDoBD.getNome());
	}

	private final static String NOME_DO_DISCIPLINA_SIMPLES = "Nome de Disciplina Default";

	private Disciplina disciplinaSimples(String codigoDaDisciplina) {

		return new Disciplina.DisciplinaBuilder().nome(DisciplinaDAOImplTeste.NOME_DO_DISCIPLINA_SIMPLES).codigo(codigoDaDisciplina).build();
	}

	private static Integer idCodigoDisciplina = 0;

	private String codigoDeDisciplinaUnico() {
		return "CK" + DisciplinaDAOImplTeste.idCodigoDisciplina++;
	}
}