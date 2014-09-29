package br.ufc.model.dao;

import java.util.Collection;

import br.ufc.model.Curso;

public interface CursoDAO {

	public void criar(Curso curso);

	public Collection<Curso> all();

	public void remover(Curso curso);

	public void update(Curso curso);

}
