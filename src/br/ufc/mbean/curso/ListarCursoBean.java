package br.ufc.mbean.curso;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

@SessionScoped
@ManagedBean(name = "listarCurso")
public class ListarCursoBean {

	private CursoDAO cursoDAO;
	private Collection<Curso> cursos;
	private DataModel<Curso> cursosDataModel;

	public ListarCursoBean() {
	}

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
		this.cursosDataModel = getCursosDataModel();
	}

	public void remover() {

		Curso cursoARemover = this.cursosDataModel.getRowData();
		this.cursoDAO.remover(cursoARemover.getId());
		this.cursos.remove(cursoARemover);
	}

	public DataModel<Curso> getCursosDataModel() {
		return new CollectionDataModel<Curso>(getCursos());
	}

	private Collection<Curso> getCursos() {

		this.cursos = cursoDAO.all();

		return this.cursos;
	}

}
