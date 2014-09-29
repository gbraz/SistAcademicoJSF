package br.ufc.mbean.curso;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@SessionScoped
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

		this.cursoDAO.remover(cursoARemover);
		this.cursos = cursoDAO.all();
	}

	public String selecionarParaEditar(Curso cursoASelecionar) {

		this.cursoSelecionado = cursoASelecionar;

		return "editar.xhtml";
	}

	public String editarSelecionado() {

		this.cursoDAO.update(this.cursoSelecionado);
		this.cursos = cursoDAO.all();

		return "listar.xhtml";
	}

	// getters and setters
	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

}
