package br.ufc.model.dao;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Aluno;
import br.ufc.model.dao.impl.AlunoDAOImpl;

public class AlunoDAOTeste {

	private AlunoDAO alunoDAO = new AlunoDAOImpl(EMF.TEST_PU);

	private Aluno alunoSimples(String cpfDoAluno) {
		String nomeDoAluno = "Nome do Aluno Default";

		return new Aluno.AlunoBuilder().nome(nomeDoAluno).CPF(cpfDoAluno).build();
	}

	private static Integer CPFAluno = 0;

	private String cpfDeAlunoUnico() {
		return "011." + AlunoDAOTeste.CPFAluno++;
	}

	@Test
	public void cadastraAlunoCorretamente() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.criar(aluno);

		Assert.assertNotNull(aluno.getCPF());
	}

	@Test
	public void seCriarAlunoDeveEstarNoAll() {

		String CPF = cpfDeAlunoUnico();
		Aluno aluno = alunoSimples(CPF);

		alunoDAO.criar(aluno);

		Collection<Aluno> allAlunos = alunoDAO.all();

		Assert.assertTrue(allAlunos.contains(aluno));
	}

}