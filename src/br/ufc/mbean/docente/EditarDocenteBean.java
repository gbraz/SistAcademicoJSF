package br.ufc.mbean.docente;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Docente;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@SessionScoped
@ManagedBean(name = "editarDocente")
public class EditarDocenteBean {

	private Docente docente;
	private GenericDAO<Docente> docenteDAO;

	@PostConstruct
	public void init() {

		this.docenteDAO = DAOFactory.createDAO(Docente.class);
	}

	public String selecionarParaEditar(Docente docente) {

		this.docente = docente;

		return "editar.xhtml";
	}

	public String editar() {

		this.docenteDAO.update(this.docente);

		return "/index.xhtml";
	}

	// getters and setters
	public Docente getDocente() {
		return docente;
	}

}
