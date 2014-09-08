package br.ufc.model.dao;

import java.util.List;

import br.ufc.model.Aluno;

public interface AlunoDao {
	public void salvarAluno(Aluno aluno);
	public Aluno getAluno(int matricula);
	public List<Aluno> listaAluno();
	public void removerAluno(Aluno aluno);
	public void removerAlunoByMatricula(int matricula);
	public void atualizarAluno(Aluno aluno);
}
