package br.ufc.model;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.control.AlunoService;

// TODO: rever os testes após os estudos sobre unit test(há uma issue sobre)
public class AlunoTeste {
	@Test
	public void testCriar() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		Integer matricula = AlunoService.inserirAluno(nome, data, sexo, cpf);

		Aluno aluno = AlunoService.getAluno(matricula);
		// testa os atributos
		Assert.assertEquals(cpf, aluno.getCpf());
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
		Integer matricula = AlunoService.inserirAluno(nome, data, sexo, cpf);
		// remove o aluno
		AlunoService.removerAluno(matricula);
		Assert.assertNull(AlunoService.getAluno(matricula));
	}

	@Test
	public void testEditar() {

		GregorianCalendar velhoNascimento = new GregorianCalendar(2015, 10, 20);
		String velhoNome = "Zordon";
		Sexo velhoSexo = Sexo.OUTRO;
		String velhoCPF = "00000-00";

		Integer matricula = AlunoService.inserirAluno(velhoNome, velhoNascimento.getTime(), velhoSexo, velhoCPF);

		GregorianCalendar novoNascimento = new GregorianCalendar(2015, 10, 12);
		String novoNome = "Alpha";
		Sexo novoSexo = Sexo.MULHER;
		String novoCPF = "111111-00";

		AlunoService.editarAluno(matricula, novoNome, novoNascimento.getTime(), novoSexo, novoCPF);

		Aluno aluno = AlunoService.getAluno(matricula);

		Assert.assertEquals(aluno.getNascimento(), novoNascimento.getTime());
		Assert.assertEquals(aluno.getNome(), novoNome);
		Assert.assertEquals(aluno.getSexo(), novoSexo);
		Assert.assertEquals(aluno.getCpf(), novoCPF);
	}
}