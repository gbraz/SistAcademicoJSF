package br.ufc.model.dao.impl;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF.PU;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.GenericDAO;
import br.ufc.util.DataUtil;

public class AlunoDAOImplTeste {

	static {

		DAOFactory.setPersistenceUnit(PU.TEST_PU);
	}

	private GenericDAO<Aluno> alunoDAO = DAOFactory.createDAO(Aluno.class);

	@Test
	public void cadastraAlunoCorretamente() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.add(aluno);

		Assert.assertNotNull(aluno.getCPF());
	}

	@Test
	public void seCriarAlunoDeveEstarNoAll() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.add(aluno);

		Collection<Aluno> allAlunos = alunoDAO.all();

		Assert.assertTrue(allAlunos.contains(aluno));
	}

	@Test
	public void seRemoveAlunoNaoDeveEstarNoAll() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.add(aluno);
		alunoDAO.remove(aluno);

		Collection<Aluno> allAlunos = alunoDAO.all();

		Assert.assertFalse(allAlunos.contains(aluno));
	}

	@Test
	public void seUpdateAlunoDeveMudarNoDB() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.add(aluno);

		String novoNome = aluno.getNome() + "novo";
		Sexo novoSexo = OUTRO_SEXO_DO_ALUNO_SIMPLES;
		Date novaData = DataUtil.addDia(DATA_DO_ALUNO_SIMPLES, 1);

		aluno.setNome(novoNome);
		aluno.setSexo(novoSexo);
		aluno.setNascimento(novaData);

		alunoDAO.update(aluno);

		// TODO: atualizar quando puder buscar por id/matrícula
		Collection<Aluno> allALunos = alunoDAO.all();

		Aluno alunoDoDB = null;
		for (Aluno alunoDB : allALunos) {
			if (aluno.getMatricula().equals(alunoDB.getMatricula())) {
				alunoDoDB = alunoDB;
				break;
			}
		}

		Assert.assertEquals(novoNome, alunoDoDB.getNome());
		Assert.assertEquals(novoSexo, alunoDoDB.getSexo());
		Assert.assertEquals(novaData, alunoDoDB.getNascimento());
	}

	private static Integer CPFAluno = 0;
	private final static String NOME_DO_ALUNO_SIMPLES = "Nome do Aluno Default";
	private final static Sexo SEXO_DO_ALUNO_SIMPLES = Sexo.HOMEM;
	private final static Sexo OUTRO_SEXO_DO_ALUNO_SIMPLES = Sexo.OUTRO;
	private final static int ANO_DO_ALUNO_SIMPLES = 1989;
	private final static int MES_DO_ALUNO_SIMPLES = 10;
	private final static int DIA_DO_ALUNO_SIMPLES = 29;
	private final static Date DATA_DO_ALUNO_SIMPLES = DataUtil.date(DIA_DO_ALUNO_SIMPLES, MES_DO_ALUNO_SIMPLES,
			ANO_DO_ALUNO_SIMPLES);

	private String cpfDeAlunoUnico() {
		return "011." + AlunoDAOImplTeste.CPFAluno++;
	}

	private Aluno alunoSimples(String cpfDoAluno) {

		return new Aluno.AlunoBuilder().nome(NOME_DO_ALUNO_SIMPLES).CPF(cpfDoAluno).sexo(SEXO_DO_ALUNO_SIMPLES)
				.dataDeNascimento(DATA_DO_ALUNO_SIMPLES).build();
	}
}