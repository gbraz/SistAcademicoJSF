package br.ufc.mbean.disciplina;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Disciplina;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@SessionScoped
@ManagedBean(name = "editarDisciplina")
public class EditarDisciplinaBean {

	private Disciplina disciplina;
	private GenericDAO<Disciplina> disciplinaDAO;

	@PostConstruct
	public void init() {

		this.disciplinaDAO = DAOFactory.createDAO(Disciplina.class);
	}

	public String selecionarParaEditar(Disciplina disciplina) {

		this.disciplina = disciplina;

		return "editar.xhtml";
	}

	public String editar() {

		this.disciplinaDAO.update(this.disciplina);

		return "/index.xhtml";
	}

	// getters and setters
	public Disciplina getDisciplina() {
		return disciplina;
	}

}
