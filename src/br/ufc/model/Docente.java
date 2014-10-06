package br.ufc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Docente {

	public static class DocenteBuilder {

		private Docente instance;

		public DocenteBuilder() {
			this.instance = new Docente();
		}

		public DocenteBuilder nome(String nome) {
			this.instance.setNome(nome);
			return this;
		}

		public DocenteBuilder sexo(Sexo sexo) {
			this.instance.setSexo(sexo);
			return this;
		}

		public DocenteBuilder CPF(String cpf) {
			this.instance.setCPF(cpf);
			return this;
		}

		public DocenteBuilder dataDeNascimento(Date dataDeNascimento) {
			this.instance.setNascimento(dataDeNascimento);
			return this;
		}

		public Docente build() {
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

	private Docente() {
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
		Docente other = (Docente) obj;
		if (matricula != other.matricula) {
			isEquals = false;
		}
		return isEquals;
	}

}