package br.ufc.control;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityExistsException;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;

public class AlunoService {
	
	private AlunoDAO alunoDAO;
	
	public AlunoService(AlunoDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public Collection<Aluno> getAlunos() {
		return alunoDAO.listaAluno();
	}

	public Integer inserirAluno(String nome, Date dataNascimento, Sexo sexo, String cpf) {

		Aluno alunoAInserir = new Aluno(nome, dataNascimento, sexo, cpf);
		Integer matricula;

		try {
			matricula = alunoDAO.salvarAluno(alunoAInserir);
		} catch (EntityExistsException ex) {
			matricula = null;
		}

		return matricula;
	}

	public boolean editarAluno(int matricula, String nome, Date nascimento, Sexo sexo, String cpf) {

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

	public void removerAluno(int matricula) {
		alunoDAO.removerAlunoByMatricula(matricula);
	}

	public Aluno getAluno(int matricula) {
		return alunoDAO.getAluno(matricula);
	}
}
