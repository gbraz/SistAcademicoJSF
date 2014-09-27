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

	public ListarCursoBean() {
	}

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
		this.cursos = cursoDAO.all();
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

}
