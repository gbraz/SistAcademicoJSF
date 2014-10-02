package br.ufc.model.dao.impl;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;

public class CursoDAOImpl extends GenericDAOImpl<Curso> implements CursoDAO {

	public CursoDAOImpl() {

		super(Curso.class);
	}

	public CursoDAOImpl(String persistenceUnit) {

		super(persistenceUnit, Curso.class);
	}

}
