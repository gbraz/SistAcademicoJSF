package br.ufc.mbean.curso;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@SessionScoped
@ManagedBean(name = "editarCurso")
public class EditarCursoBean {

	private Curso curso;
	private CursoDAO cursoDAO;

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
	}

	public String selecionarParaEditar(Curso curso) {

		this.curso = curso;

		return "editar.xhtml";
	}

	public String editar() {

		this.cursoDAO.update(this.curso);

		return "/index.xhtml";
	}

	// getters and setters
	public Curso getCurso() {
		return curso;
	}

}
