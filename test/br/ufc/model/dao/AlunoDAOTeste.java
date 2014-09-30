package br.ufc.model.dao;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.impl.AlunoDAOImpl;

public class AlunoDAOTeste {

	private AlunoDAO alunoDAO = new AlunoDAOImpl(EMF.TEST_PU);

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

	private static Integer CPFAluno = 0;

	private String cpfDeAlunoUnico() {
		return "011." + AlunoDAOTeste.CPFAluno++;
	}

	private Aluno alunoSimples(String cpfDoAluno) {

		String nomeDoAluno = "Nome do Aluno Default";
		Sexo sexoDoAluno = Sexo.HOMEM;

		int anoDeNascimento = 1989;
		int mesDeNascimento = 10;
		int diaDeNascimento = 29;
		Date dataDeNascimento = new GregorianCalendar(anoDeNascimento, mesDeNascimento, diaDeNascimento).getTime();

		return new Aluno.AlunoBuilder().nome(nomeDoAluno).CPF(cpfDoAluno).sexo(sexoDoAluno)
				.dataDeNascimento(dataDeNascimento).build();
	}
}