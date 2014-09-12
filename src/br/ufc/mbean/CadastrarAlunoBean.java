package br.ufc.mbean;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.control.AlunoService;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

@RequestScoped
@ManagedBean(name = "cadastrarAluno")
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();

	public CadastrarAlunoBean() {
	}

	public String cadastrar() {
		AlunoService.inserirAluno(aluno.getNome(), aluno.getNascimento(), aluno.getSexo(), aluno.getCpf());
		return "confirma";
	}

	public Collection<Aluno> getAlunos() {
		return AlunoService.getAlunos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

}
