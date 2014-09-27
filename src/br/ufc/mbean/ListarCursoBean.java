package br.ufc.mbean;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@ManagedBean(name = "listarCurso")
public class ListarCursoBean {

	private CursoDAO cursoDAO = new CursoDAOImpl();

	private Collection<Curso> cursos = cursoDAO.all();

	public Collection<Curso> getCursos() {
		return this.cursos;
	}
}
