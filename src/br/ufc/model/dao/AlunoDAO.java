package br.ufc.model.dao;

import java.util.Collection;

import br.ufc.model.Aluno;

public interface AlunoDAO {

	public Integer criar(Aluno aluno);

	public Aluno porMatricula(Integer matricula);

	public Collection<Aluno> all();

}
