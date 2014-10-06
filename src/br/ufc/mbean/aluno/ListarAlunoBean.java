package br.ufc.mbean.aluno;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.model.Aluno;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@SessionScoped
@ManagedBean(name = "listarAluno")
public class ListarAlunoBean {

	private GenericDAO<Aluno> alunoDAO;

	private Collection<Aluno> alunos;

	private Aluno alunoSelecionado;

	public ListarAlunoBean() {
	}

	@PostConstruct
	public void init() {

		this.alunoDAO = DAOFactory.createDAO(Aluno.class);
		this.alunos = alunoDAO.all();
	}

	public Collection<Aluno> getAlunos() {
		return this.alunos;
	}

	public void remover(Aluno alunoARemover) {
		this.alunoDAO.remove(alunoARemover);
		this.alunos = this.alunoDAO.all();
	}

	public String selecionarParaEditar(Aluno alunoASelecionar) {

		this.alunoSelecionado = alunoASelecionar;

		return "editar.xhtml";
	}

	public String editarSelecionado() {

		this.alunoDAO.update(this.alunoSelecionado);
		this.alunos = alunoDAO.all();

		return "listar.xhtml";
	}

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
}
