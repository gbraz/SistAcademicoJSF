package br.ufc.model.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import br.ufc.infra.EMF;
import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;

public class CursoDAOImpl implements CursoDAO {

	protected EntityManager em;

	public CursoDAOImpl() {

		this(EMF.PRODUCTION_PU);
	}

	public CursoDAOImpl(String persistenceUnit) {

		this.em = EMF.em(persistenceUnit);
	}

	public void criar(Curso curso) {

		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}

	public void remover(Curso curso) {

		em.getTransaction().begin();
		em.remove(curso);
		em.getTransaction().commit();
	}

	public Collection<Curso> all() {

		return em.createQuery("FROM " + Curso.class.getName(), Curso.class).getResultList();
	}

	public void update(Curso curso) {

		em.getTransaction().begin();
		em.merge(curso);
		em.getTransaction().commit();
	}

}
