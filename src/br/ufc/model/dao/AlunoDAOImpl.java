package br.ufc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	public static String PRODUCTION_PU = "SigaaJSF";
	public static String TEST_PU = "TestSigaaJSF";

	protected EntityManager entityManager;

	public AlunoDAOImpl() {
		this(AlunoDAOImpl.PRODUCTION_PU);
	}

	public AlunoDAOImpl(String persistenceUnit) {
		this.entityManager = createEntityManager(persistenceUnit);
	}

	public EntityManager createEntityManager(String persistenceUnit) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);

		return factory.createEntityManager();
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
