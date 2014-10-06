package br.ufc.mbean.disciplina;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Disciplina;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@RequestScoped
@ManagedBean(name = "listarDisciplina")
public class ListarDisciplinaBean {

	private GenericDAO<Disciplina> disciplinaDAO;

	private Collection<Disciplina> disciplinas;

	private Disciplina disciplinaSelecionado;

	@PostConstruct
	public void init() {

		this.disciplinaDAO = DAOFactory.createDAO(Disciplina.class);
		this.disciplinas = this.disciplinaDAO.all();
	}

	public Collection<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void remover(Disciplina disciplinaARemover) {

		this.disciplinaDAO.remove(disciplinaARemover);
		this.disciplinas = disciplinaDAO.all();
	}

	// getters and setters
	public Disciplina getDisciplinaSelecionado() {
		return disciplinaSelecionado;
	}

}
