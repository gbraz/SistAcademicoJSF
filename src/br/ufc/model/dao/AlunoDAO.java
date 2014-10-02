package br.ufc.model.dao;

import java.util.Collection;

import br.ufc.model.Aluno;

public interface AlunoDAO {

	public void add(Aluno aluno);

	public void remove(Aluno aluno);

	public void update(Aluno aluno);

	public Collection<Aluno> all();
}
