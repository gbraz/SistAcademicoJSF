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

	@Override
	public Integer criar(Aluno aluno) {

		Integer matricula;

		try {

			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();

			matricula = aluno.getMatricula();

		} catch (Exception ex) {

			// TODO: como a camada solicitante sabe o que ocorreu?
			ex.printStackTrace();
			em.getTransaction().rollback();

			matricula = null;
		}

		return matricula;
	}

	@Override
	public Aluno porMatricula(int matricula) {

		return em.find(Aluno.class, matricula);
	}

	@Override
	public Collection<Aluno> all() {

		return em.createQuery("FROM " + Aluno.class.getName(), Aluno.class).getResultList();
	}

}
