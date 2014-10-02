package br.ufc.model.dao.impl;

import br.ufc.model.Aluno;
import br.ufc.model.dao.AlunoDAO;

public class AlunoDAOImpl extends GenericDAOImpl<Aluno> implements AlunoDAO {

	public AlunoDAOImpl() {

		super(Aluno.class);
	}

	public AlunoDAOImpl(String persistenceUnit) {

		super(persistenceUnit, Aluno.class);
	}

}
