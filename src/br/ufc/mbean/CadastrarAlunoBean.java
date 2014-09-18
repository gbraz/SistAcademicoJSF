package br.ufc.mbean;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.control.AlunoService;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAOImpl;

@RequestScoped
@ManagedBean(name = "cadastrarAluno")
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();
	private AlunoService alunoService = new AlunoService(new AlunoDAOImpl());

	public CadastrarAlunoBean() {
	}

	public String cadastrar() {
		alunoService.inserirAluno(this.aluno);
		return "confirma";
	}

	public Collection<Aluno> getAlunos() {
		return alunoService.getAlunos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

}
