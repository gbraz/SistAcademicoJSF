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

	public void cadastrar() {
		Calendar nascimento = Calendar.getInstance();
		OperacoesEmAlunos.inserirAluno(aluno.getMatricula(), aluno.getNome(), nascimento , Sexo.HOMEM, aluno.getCpf());
		System.out.println("Teste: " + aluno.getNome() +"\n CPF: "+aluno.getCpf()+"\nContador: "
				+ contador++);
		System.out.println(OperacoesEmAlunos.getAluno(aluno.getMatricula()).toString());
		//return "cadastra";
	}

	public HashMap<Integer, Aluno> getAlunos(){
		return OperacoesEmAlunos.getAlunos();
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public String getAlunoNome(){
		String nome="null";
		Aluno alunoHolder = OperacoesEmAlunos.getAluno(aluno.getMatricula());
		
		if(alunoHolder != null){
			nome = alunoHolder.getNome();
		}
		
		return nome;
	}
	
	public String getAlunoMatricula(){
		String matricula="null";
		Aluno alunoHolder = OperacoesEmAlunos.getAluno(aluno.getMatricula());
		
		if(alunoHolder != null){
			matricula = Integer.toString(alunoHolder.getMatricula());
		}
		
		return matricula;
	}

	public String getAlunoCpf(){
		String cpf="null";
		Aluno alunoHolder = OperacoesEmAlunos.getAluno(aluno.getMatricula());
		
		if(alunoHolder != null){
			cpf = alunoHolder.getCpf();
		}
		
		return cpf;
	}
	
	public String getAlunoSexo(){
		String sexo="null";
		Aluno alunoHolder = OperacoesEmAlunos.getAluno(aluno.getMatricula());
		
		if(alunoHolder != null){
			sexo = alunoHolder.getSexo().name();
		}
		
		return sexo;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	 public Sexo[] getQualsexo(){
	        return Sexo.values();
	 } 

}
