package br.ufc.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Aluno implements Serializable {

	// TODO: extrair para configuração global -> ex: arquivo properties config
	private static final String DATE_FORMAT = "dd-MM-yyyy";

	private static final String TEMPLATE_TO_STRING = "Numero da matricula: %s \nNome: %s \nCPF: %s \nSexo: %s \nData de Nascimento: %s";

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

	private static final long serialVersionUID = -3224160921888988340L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matricula;
	private String nome;
	private Sexo sexo;
	private String cpf;
	@Temporal(TemporalType.DATE)
	private Date nascimento;

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
	public String toString() {
		String result;
		SimpleDateFormat sd = new SimpleDateFormat(DATE_FORMAT);

		result = TEMPLATE_TO_STRING;
		result = String.format(result, this.matricula, this.nome, this.cpf, this.sexo, sd.format(this.nascimento));

		return result;
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
		Aluno other = (Aluno) obj;
		if (matricula != other.matricula) {
			isEquals = false;
		}
		return isEquals;
	}

}