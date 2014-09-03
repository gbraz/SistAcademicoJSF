package br.ufc.mbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.control.OperacoesEmAlunos;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

@ManagedBean(name = "cadastrarAluno")
@SessionScoped
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();
	private Integer contador = 0;
		
	public CadastrarAlunoBean() {
		aluno.setNome("Matheus");
	}

	public String cadastrar() {
		Calendar nascimento = Calendar.getInstance();
		OperacoesEmAlunos.inserirAluno(aluno.getMatricula(), aluno.getNome(), nascimento , Sexo.HOMEM, aluno.getCpf());
		System.out.println("Teste: " + aluno.getNome() +"\n CPF: "+aluno.getCpf()+"\nContador: "
				+ contador++);
		System.out.println(OperacoesEmAlunos.getAluno(aluno.getMatricula()).toString());
		return "confirma";
	}

	public HashMap<Integer, Aluno> getAlunos(){
		return OperacoesEmAlunos.getAlunos();
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	 public Sexo[] getQualsexo(){
	        return Sexo.values();
	 } 

}
