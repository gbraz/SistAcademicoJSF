package br.ufc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * @author Matheus Mayron
 * 
 */

public class Aluno {
	private int matricula;
	private String nome;
	private Sexo sexo;
	private String cpf;
	private Calendar nascimento;

	public Aluno(int matricula, String nome, Calendar nascimento, Sexo sexo,String cpf) {
		this.matricula = matricula;
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.nascimento = nascimento;
	}
	
	public Aluno() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int numDeMatricula) {
		this.matricula = numDeMatricula;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public String toString() {
		String template = "%s: %s\n";
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		sb.append(String.format(template, "Numero de matr�cula", this.matricula));
		sb.append(String.format(template, "Nome ", this.nome));
		sb.append(String.format(template, "CPF", this.cpf));
		sb.append(String.format(template, "Sexo", this.sexo));
		sb.append(String.format(template, "Data de nascimento",	sd.format(this.nascimento.getTime())));
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula) {
			return false;
		}
		return true;
	}
}