package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String codigo;
	private String nome;

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
