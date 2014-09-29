package br.ufc.model.dao;

import java.util.Collection;

import br.ufc.model.Aluno;
import br.ufc.model.Curso;

public interface AlunoDAO {

	public void criar(Aluno aluno);

	public void remover(Aluno aluno);

	public void update(Aluno aluno);
	
	public Collection<Aluno> all();
}
