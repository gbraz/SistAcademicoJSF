package br.ufc.model.dao;

import java.util.Collection;

import br.ufc.model.Curso;

public interface CursoDAO {

	public void criar(Curso curso);
	public Curso remover(int id);
	public Collection<Curso> all();

}
