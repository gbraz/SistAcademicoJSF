package br.ufc.model.dao.impl;

import java.util.ArrayList;
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
		// Por que sem ele dá pra passar no teste de criar e não no da lista?
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}

	public Curso remover(int id) {
		em.getTransaction().begin();
		Curso cursoEncontrado = em.find(Curso.class, id);
		em.remove(cursoEncontrado);
		em.getTransaction().commit();

		return cursoEncontrado;
	}

	public Curso editarNome(String novoNome, int id) {
		em.getTransaction().begin();
		Curso cursoAEditar = em.find(Curso.class, id);
		cursoAEditar.setNome(novoNome);
		em.merge(cursoAEditar);
		em.getTransaction().commit();

		return cursoAEditar;
	}

	public Curso porID(Integer id) {

		return em.find(Curso.class, id);
	}

	public Curso porCodigo(String codigo) {
		em.getTransaction().begin();
		Collection<Curso> tabela = all();

		if (tabela.isEmpty())
			return null;

		ArrayList<Curso> tabelaList = new ArrayList<Curso>(tabela);

		for (Curso curso : tabelaList)
			if (codigo.equals(curso.getCodigo()))
				return curso;

		return null;
	}

	public Collection<Curso> all() {
		return em.createQuery("FROM " + Curso.class.getName(), Curso.class).getResultList();
	}

}
