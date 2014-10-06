package br.ufc.model.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import br.ufc.infra.EMF;
import br.ufc.infra.EMF.PU;
import br.ufc.model.dao.GenericDAO;

public class GenericDAOImpl<E> implements GenericDAO<E> {

	protected EntityManager em;
	protected Class<E> entityClass;

	public GenericDAOImpl(Class<E> entityClass) {

		this(entityClass, PU.PRODUCTION_PU);
	}

	public GenericDAOImpl(Class<E> entityClass, PU persistenceUnit) {

		this.em = EMF.em(persistenceUnit.toString());
		this.entityClass = entityClass;
	}

	public void add(E entity) {

		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}

	public void remove(E entity) {

		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	public void update(E entity) {

		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	public Collection<E> all() {

		return em.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
	}

}
