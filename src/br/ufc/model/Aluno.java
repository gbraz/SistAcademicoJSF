package br.ufc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable{
	@Id
	private int matricula;
	private String nome;
	private Sexo sexo;
	private String cpf;
	@Column
	@Temporal(TemporalType.DATE)
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

	public void setMatricula(int matricula) {
		this.matricula = matricula;
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

	// TODO: hÃ¡ forma melhor de escrever o toString? Pesquisar sobre toString
	@Override
	public String toString() {
		String template = "%s: %s\n";
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		sb.append(String.format(template, "Numero de matrícula", this.matricula));
		sb.append(String.format(template, "Nome ", this.nome));
		sb.append(String.format(template, "CPF", this.cpf));
		sb.append(String.format(template, "Sexo", this.sexo));
		sb.append(String.format(template, "Data de nascimento",	sd.format(this.nascimento.getTime())));
		return sb.toString();
	}

	
	//TODO Olhar sobre hashCode.
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEquals = true;
		
		if (this != obj) {
			isEquals = false;
		}
		if (obj == null) {
			isEquals = false;
		}
		if (getClass() != obj.getClass()) {
			isEquals = false;
		}
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula) {
			isEquals = false;
		}
		return isEquals;
	}
}