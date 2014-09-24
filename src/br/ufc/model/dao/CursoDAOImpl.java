package br.ufc.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufc.model.Curso;
import br.ufc.infra.*;

public class CursoDAOImpl implements CursoDAO {
	
	protected EntityManager em;
	
	//Inseri o EntityManager e EMF de uma vez, olhando como foi feito em AlunoDAOImpl
	//não soube como fazer baby step aqui
	
	public CursoDAOImpl(String persistenceUnit) {
		this.em = EMF.em(persistenceUnit);
	}

	public void criar(Curso curso) {
		//Por que sem ele dá pra passar no teste de criar e não no da lista?
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}
	
	public List<Curso> all(){
		return em.createQuery("FROM " + Curso.class.getName(), Curso.class).getResultList();
	}

}
