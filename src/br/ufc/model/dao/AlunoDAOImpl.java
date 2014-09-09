package br.ufc.model.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.model.Aluno;

public class AlunoDAOImpl implements AlunoDAO {

	protected EntityManager entityManager;

	public AlunoDAOImpl() {
		entityManager = getEntityManager();
	}

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SigaaJSF");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	@Override
	public void salvarAluno(Aluno aluno) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(aluno);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public Aluno getAluno(int matricula) {
		return entityManager.find(Aluno.class, matricula);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listaAluno() {
		return entityManager.createQuery("FROM " + Aluno.class.getName()).getResultList();
	}

	@Override
	public void atualizarAluno(Aluno aluno) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(aluno);
			entityManager.getTransaction().commit();
		} catch(IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}

	}

	@Override
	public void removerAluno(Aluno aluno) {
		try {
			entityManager.getTransaction().begin();
			aluno = entityManager.find(Aluno.class, aluno.getMatricula());
			entityManager.remove(aluno);
			entityManager.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void removerAlunoByMatricula(int matricula) {
		try {
			Aluno aluno = getAluno(matricula);
			removerAluno(aluno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
