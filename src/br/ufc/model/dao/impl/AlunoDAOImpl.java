package br.ufc.model.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import br.ufc.infra.EMF;
import br.ufc.model.Aluno;
import br.ufc.model.dao.AlunoDAO;

public class AlunoDAOImpl implements AlunoDAO {

	protected EntityManager em;

	public AlunoDAOImpl() {

		this(EMF.PRODUCTION_PU);
	}

	public AlunoDAOImpl(String persistenceUnit) {

		this.em = EMF.em(persistenceUnit);
	}

	public void add(Aluno aluno) {

		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}

	public void remove(Aluno aluno) {

		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
	}

	public void update(Aluno aluno) {

		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}

	public Collection<Aluno> all() {

		return em.createQuery("FROM " + Aluno.class.getName(), Aluno.class).getResultList();
	}

}
