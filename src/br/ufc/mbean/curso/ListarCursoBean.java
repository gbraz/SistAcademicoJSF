package br.ufc.mbean.curso;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@RequestScoped
@ManagedBean(name = "listarCurso")
public class ListarCursoBean {

	private GenericDAO<Curso> cursoDAO;

	private Collection<Curso> cursos;

	private Curso cursoSelecionado;

	@PostConstruct
	public void init() {

		this.cursoDAO = DAOFactory.createDAO(Curso.class);
		this.cursos = this.cursoDAO.all();
	}

	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void remover(Curso cursoARemover) {

		this.cursoDAO.remove(cursoARemover);
		this.cursos = cursoDAO.all();
	}

	// getters and setters
	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

}
