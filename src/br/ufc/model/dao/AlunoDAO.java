package br.ufc.model.dao;

import java.util.List;

import br.ufc.model.Aluno;

public interface AlunoDAO {

	public Integer criar(Aluno aluno);

	public Aluno porMatricula(int matricula);

	public List<Aluno> all();

}
