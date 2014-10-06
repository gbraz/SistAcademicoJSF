package br.ufc.mbean.docente;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Docente;
import br.ufc.model.Sexo;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@SessionScoped
@ManagedBean(name = "listarDocente")
public class ListarDocenteBean {

	private GenericDAO<Docente> docenteDAO;

	private Collection<Docente> docentes;

	private Docente docenteSelecionado;

	public ListarDocenteBean() {
	}

	@PostConstruct
	public void init() {

		this.docenteDAO = DAOFactory.createDAO(Docente.class);
		this.docentes = docenteDAO.all();
	}

	public Collection<Docente> getDocentes() {
		return this.docentes;
	}

	public void remover(Docente docenteARemover) {
		this.docenteDAO.remove(docenteARemover);
		this.docentes = this.docenteDAO.all();
	}

	public String selecionarParaEditar(Docente docenteASelecionar) {

		this.docenteSelecionado = docenteASelecionar;

		return "editar.xhtml";
	}

	public String editarSelecionado() {

		this.docenteDAO.update(this.docenteSelecionado);
		this.docentes = docenteDAO.all();

		return "listar.xhtml";
	}

	public Sexo[] getSexos() {

		return Sexo.values();
	}
	
	public String goToLink() {
		return "docente/listar";
	}

	public Docente getDocenteSelecionado() {
		return docenteSelecionado;
	}
	
}