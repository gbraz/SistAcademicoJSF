package br.ufc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno {

	public static class AlunoBuilder {

		private Aluno instance;

		public AlunoBuilder() {
			this.instance = new Aluno();
		}

		public AlunoBuilder nome(String nome) {
			this.instance.setNome(nome);
			return this;
		}

		public AlunoBuilder sexo(Sexo sexo) {
			this.instance.setSexo(sexo);
			return this;
		}

		public AlunoBuilder CPF(String cpf) {
			this.instance.setCPF(cpf);
			return this;
		}

		public AlunoBuilder dataDeNascimento(Date dataDeNascimento) {
			this.instance.setNascimento(dataDeNascimento);
			return this;
		}

		public Aluno build() {
			return this.instance;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer matricula;
	private String nome;
	private Sexo sexo;
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	private Aluno() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 7;
		result = prime * result + matricula;
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Aluno))
			return false;
		
		Aluno objAluno = (Aluno) obj;

		return this.matricula.equals(objAluno.getMatricula());
	}

}