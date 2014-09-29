package br.ufc.mbean.aluno;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Aluno;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.impl.AlunoDAOImpl;

@SessionScoped
@ManagedBean(name = "editarAluno")
public class EditarAlunoBean {

	private Aluno aluno;
	private AlunoDAO alunoDAO;

	@PostConstruct
	public void init() {

		this.alunoDAO = new AlunoDAOImpl();
	}

	public String selecionarParaEditar(Aluno aluno) {

		this.aluno = aluno;

		return "editar.xhtml";
	}

	public String editar() {

		this.alunoDAO.update(this.aluno);

		return "/index.xhtml";
	}

	// getters and setters
	public Aluno getAluno() {
		return aluno;
	}

}
