package br.ufc.mbean.aluno;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Aluno;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.impl.AlunoDAOImpl;

@RequestScoped
@ManagedBean(name = "listarAluno")
public class ListarAlunoBean {

	private AlunoDAO alunoDAO;

	private Collection<Aluno> alunos;

	public ListarAlunoBean() {
	}

	@PostConstruct
	public void init() {

		this.alunoDAO = new AlunoDAOImpl();
		this.alunos = alunoDAO.all();
	}

	public Collection<Aluno> getAlunos() {
		return this.alunos;
	}
	
	public String goToLink(){
		return "aluno/listar";
	}
}
