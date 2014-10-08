package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	public static class CursoBuilder {

		private Curso instance;

		public CursoBuilder() {
			this.instance = new Curso();
		}

		public CursoBuilder nome(String nome) {
			instance.setNome(nome);
			return this;
		}

		public CursoBuilder codigo(String codigo) {
			instance.setCodigo(codigo);
			return this;
		}

		public Curso build() {
			return this.instance;
		}

	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String codigo;
	private String nome;
	

	
	// getters and setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return nome;
	}

	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 7;
		result = prime * result + codigo.hashCode();
		
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

		Curso objCurso = (Curso) obj;

		return this.codigo.equals(objCurso.getCodigo());
	}

}
