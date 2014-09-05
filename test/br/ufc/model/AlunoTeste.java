package br.ufc.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.control.OperacoesEmAlunos;

// TODO: rever os testes após os estudos sobre unit test(há uma issue sobre)
public class AlunoTeste {
	@Test
	public void testCriar() {
		// Dados do aluno
		int matricula = 2;
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Calendar data = new GregorianCalendar();
		data.set(2015, 10, 12);
		OperacoesEmAlunos.inserirAluno(matricula, nome, data, sexo, cpf);
		Aluno aluno = OperacoesEmAlunos.getAluno(2);
		// testa os atributos
		Assert.assertEquals(cpf, aluno.getCpf());
		Assert.assertEquals(matricula, aluno.getMatricula());
		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(sexo, aluno.getSexo());
		Assert.assertEquals(data, aluno.getNascimento());
	}

	@Test
	public void testRemover() {
		// Dados do aluno
		int matricula = 2;
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Calendar data = new GregorianCalendar();
		data.set(2015, 10, 12);
		OperacoesEmAlunos.inserirAluno(matricula, nome, data, sexo, cpf);
		// remove o aluno
		OperacoesEmAlunos.removerAluno(matricula);
		Assert.assertTrue(OperacoesEmAlunos.getAlunos().isEmpty());
	}

	@Test
	public void testEditar() {
		Calendar data = new GregorianCalendar();
		data.set(2015, 10, 12);
		
		OperacoesEmAlunos.inserirAluno(6, "Zordon", data, Sexo.OUTRO,"00000-00");
		
		Aluno aluno = new Aluno(6, "Alpha", data, Sexo.MULHER, "111111-00");
		
		Assert.assertTrue(OperacoesEmAlunos.editarAluno(6, "Alpha", data,Sexo.MULHER, "111111-00"));
		Assert.assertTrue(OperacoesEmAlunos.getAluno(6).equals(aluno));
	}
}