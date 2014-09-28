package br.ufc.mbean.curso;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@ManagedBean(name = "listarCurso")
public class ListarCursoBean {

	private CursoDAO cursoDAO;

	private Collection<Curso> cursos;

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
		this.cursos = this.cursoDAO.all();
	}

	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public String goToLink() {
		return "curso/listar";
	}
}
