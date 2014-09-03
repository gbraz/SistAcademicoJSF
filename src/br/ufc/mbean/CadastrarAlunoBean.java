package br.ufc.mbean;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Aluno;

@ManagedBean(name="cadastrarAluno")
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();
	
	public void cadastrar() {
		System.out.println("Teste");
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}
