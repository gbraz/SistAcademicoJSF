package br.ufc.model;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.control.AlunoService;
import br.ufc.model.dao.AlunoDAOImpl;

public class AlunoTeste {

	private AlunoService alunoService = new AlunoService(new AlunoDAOImpl(AlunoDAOImpl.TEST_PU));

	@Test
	public void testCriar() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		Aluno aluno = new Aluno.AlunoBuilder().nome(nome).sexo(sexo).CPF(cpf).dataDeNascimento(data).build();

		Integer matricula = alunoService.inserirAluno(aluno);

		aluno = alunoService.getAluno(matricula);
		// testa os atributos
		Assert.assertEquals(cpf, aluno.getCPF());
		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(sexo, aluno.getSexo());
		Assert.assertEquals(data, aluno.getNascimento());
	}

	@Test
	public void testRemover() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		Aluno aluno = new Aluno.AlunoBuilder().nome(nome).sexo(sexo).CPF(cpf).dataDeNascimento(data).build();

		Integer matricula = alunoService.inserirAluno(aluno);
		// remove o aluno
		alunoService.removerAluno(matricula);
		Assert.assertNull(alunoService.getAluno(matricula));
	}

	@Test
	public void testEditar() {

		GregorianCalendar velhoNascimento = new GregorianCalendar(2015, 10, 20);
		String velhoNome = "Zordon";
		Sexo velhoSexo = Sexo.OUTRO;
		String velhoCPF = "00000-00";
		Aluno aluno = new Aluno.AlunoBuilder().nome(velhoNome).sexo(velhoSexo).CPF(velhoCPF)
				.dataDeNascimento(velhoNascimento.getTime()).build();

		Integer matricula = alunoService.inserirAluno(aluno);

		GregorianCalendar novoNascimento = new GregorianCalendar(2015, 10, 12);
		String novoNome = "Alpha";
		Sexo novoSexo = Sexo.MULHER;
		String novoCPF = "111111-00";

		alunoService.editarAluno(matricula, novoNome, novoNascimento.getTime(), novoSexo, novoCPF);

		aluno = alunoService.getAluno(matricula);

		Assert.assertEquals(aluno.getNascimento(), novoNascimento.getTime());
		Assert.assertEquals(aluno.getNome(), novoNome);
		Assert.assertEquals(aluno.getSexo(), novoSexo);
		Assert.assertEquals(aluno.getCPF(), novoCPF);
	}

	@Test
	public void testEditar_AlunoInexistente() {
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();

		alunoService.editarAluno(-8, nome, data, sexo, cpf);
	}

}