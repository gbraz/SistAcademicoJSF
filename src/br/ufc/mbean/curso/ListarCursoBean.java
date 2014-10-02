package br.ufc.mbean.curso;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@RequestScoped
@ManagedBean(name = "listarCurso")
public class ListarCursoBean {

	private CursoDAO cursoDAO;

	private Collection<Curso> cursos;

	private Curso cursoSelecionado;

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
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
