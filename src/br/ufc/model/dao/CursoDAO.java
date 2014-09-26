package br.ufc.model.dao;

import java.util.List;

import br.ufc.model.Curso;

public interface CursoDAO {
	
	public void criar(Curso curso);
	public Curso remover(int id);
	public List<Curso> all();

}
