package br.ufc.model.dao;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.impl.AlunoDAOImpl;

// TODO: mock
public class AlunoDAOTeste {

	private AlunoDAO alunoDAO = new AlunoDAOImpl(EMF.TEST_PU);

	@Test
	public void testCriar() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		int ano = 2015;
		int mes = 10;
		int dia = 12;
		Date data = (new GregorianCalendar(ano, mes, dia)).getTime();

		Aluno aluno = new Aluno.AlunoBuilder()
		.nome(nome)
		.sexo(sexo)
		.CPF(cpf)
		.dataDeNascimento(data)
		.build();

		Integer matricula = alunoDAO.criar(aluno);

		aluno = alunoDAO.porMatricula(matricula);
		// testa os atributos
		Assert.assertEquals(cpf, aluno.getCPF());
		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(sexo, aluno.getSexo());
		Assert.assertEquals(data, aluno.getNascimento());
	}
}