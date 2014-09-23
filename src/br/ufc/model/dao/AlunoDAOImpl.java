package br.ufc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufc.infra.EMF;
import br.ufc.model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	protected EntityManager entityManager;

	public AlunoDAOImpl() {
		this(EMF.PRODUCTION_PU);
	}

	public AlunoDAOImpl(String persistenceUnit) {
		this.entityManager = EMF.em(persistenceUnit);
	}

	@Override
	public Integer criar(Aluno aluno) {

		Integer matricula;

		try {

			entityManager.getTransaction().begin();
			entityManager.persist(aluno);
			entityManager.getTransaction().commit();

			matricula = aluno.getMatricula();

		} catch (Exception ex) {

			// TODO: como a camada solicitante sabe o que ocorreu?
			ex.printStackTrace();
			entityManager.getTransaction().rollback();

			matricula = null;
		}

		return matricula;
	}

	@Override
	public Aluno porMatricula(int matricula) {

		return entityManager.find(Aluno.class, matricula);
	}

	@Override
	public List<Aluno> all() {

		return entityManager.createQuery("FROM " + Aluno.class.getName(), Aluno.class).getResultList();
	}

}
