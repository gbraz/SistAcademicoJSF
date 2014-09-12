package br.ufc.control;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityExistsException;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.AlunoDAOImpl;

public class OperacoesEmAlunos {

	private static AlunoDAO alunoDAO = new AlunoDAOImpl();
	
	public static Collection<Aluno> getAlunos() {
		return alunoDAO.listaAluno();
	}


	public static boolean inserirAluno(String nome, Date dataNascimento, Sexo sexo, String cpf) {

		Aluno alunoAInserir = new Aluno(0, nome, dataNascimento, sexo, cpf);
		boolean alunoJaExiste = false;

		try {
			alunoDAO.salvarAluno(alunoAInserir);
		} catch (EntityExistsException ex) {
			alunoJaExiste = true;
		}

		return alunoJaExiste;
	}


	public static boolean editarAluno(int matricula, String nome, Date nascimento, Sexo sexo, String cpf) {

		Aluno alunoAEditar = getAluno(matricula);
		boolean edicaoOK = true;

		if (alunoAEditar != null) {

			alunoAEditar.setNome(nome);
			alunoAEditar.setSexo(sexo);
			alunoAEditar.setCpf(cpf);
			alunoAEditar.setNascimento(nascimento);

			try {
				alunoDAO.atualizarAluno(alunoAEditar);
			} catch (IllegalArgumentException ex) {
				edicaoOK = false;
			}
		}

		return edicaoOK;
	}

	
	public static void removerAluno(int matricula) {
		alunoDAO.removerAlunoByMatricula(matricula);
	}

	
	public static Aluno getAluno(int matricula) {
		return alunoDAO.getAluno(matricula);
	}
}
