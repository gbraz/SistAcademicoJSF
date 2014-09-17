package br.ufc.model;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityExistsException;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.control.AlunoService;
import br.ufc.model.dao.AlunoDAOImpl;

// TODO: rever os testes após os estudos sobre unit test(há uma issue sobre)
public class AlunoTeste {
	
	private AlunoService alunoService = new AlunoService(new AlunoDAOImpl(AlunoDAOImpl.PRODUCTION_PU));
	
	@Test
	public void testCriar() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";		
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		Integer matricula = alunoService.inserirAluno(nome, data, sexo, cpf);

		Aluno aluno = alunoService.getAluno(matricula);
		// testa os atributos
		Assert.assertEquals(cpf, aluno.getCpf());
		Assert.assertEquals(nome, aluno.getNome());
		Assert.assertEquals(sexo, aluno.getSexo());
		Assert.assertEquals(data, aluno.getNascimento());
	}

	@Test(expected=EntityExistsException.class)
	public void testCriar_Campos_Nulos(){
		Integer matricula = alunoService.inserirAluno(null, null, null, null);
	}
			
	@Test
	public void testRemover() {
		// Dados do aluno
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		Integer matricula = alunoService.inserirAluno(nome, data, sexo, cpf);
		// remove o aluno
		alunoService.removerAluno(matricula);
		Assert.assertNull(alunoService.getAluno(matricula));
	}
	
	@Test(expected=EntityExistsException.class)
	public void testRemover_Aluno_Inexistente(){
		alunoService.removerAluno(-8);
	}

	@Test
	public void testEditar() {

		GregorianCalendar velhoNascimento = new GregorianCalendar(2015, 10, 20);
		String velhoNome = "Zordon";
		Sexo velhoSexo = Sexo.OUTRO;
		String velhoCPF = "00000-00";

		Integer matricula = alunoService.inserirAluno(velhoNome, velhoNascimento.getTime(), velhoSexo, velhoCPF);

		GregorianCalendar novoNascimento = new GregorianCalendar(2015, 10, 12);
		String novoNome = "Alpha";
		Sexo novoSexo = Sexo.MULHER;
		String novoCPF = "111111-00";

		alunoService.editarAluno(matricula, novoNome, novoNascimento.getTime(), novoSexo, novoCPF);

		Aluno aluno = alunoService.getAluno(matricula);

		Assert.assertEquals(aluno.getNascimento(), novoNascimento.getTime());
		Assert.assertEquals(aluno.getNome(), novoNome);
		Assert.assertEquals(aluno.getSexo(), novoSexo);
		Assert.assertEquals(aluno.getCpf(), novoCPF);
	}
	
	@Test
	public void testEditar_AlunoInexistente(){
		String nome = "Geraldo";
		Sexo sexo = Sexo.OUTRO;
		String cpf = "666";
		Date data = (new GregorianCalendar(2015, 10, 12)).getTime();
		
		alunoService.editarAluno(-8, nome, data, sexo, cpf);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditar_ParametroInv(){
		GregorianCalendar velhoNascimento = new GregorianCalendar(2015, 10, 20);
		String velhoNome = "Zordon";
		Sexo velhoSexo = Sexo.OUTRO;
		String velhoCPF = "00000-00";
		Integer matricula = alunoService.inserirAluno(velhoNome, velhoNascimento.getTime(), velhoSexo, velhoCPF);
		
		GregorianCalendar novoNascimento = new GregorianCalendar(2015, 10, 12);
		String novoNome = null;
		Sexo novoSexo=Sexo.HOMEM;
		String novoCPF = null;

		alunoService.editarAluno(matricula, novoNome, novoNascimento.getTime(), novoSexo, novoCPF);

		
	}
	
}