package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina {
	public static class DisciplinaBuilder {

		private Disciplina instance;

		public DisciplinaBuilder() {
			this.instance = new Disciplina();
		}

		public DisciplinaBuilder nome(String nome) {
			instance.setNome(nome);
			return this;
		}

		public DisciplinaBuilder codigo(String codigo) {
			instance.setCodigo(codigo);
			return this;
		}

		public Disciplina build() {
			return this.instance;
		}

	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private String codigo;
	private String nome;
	@ManyToOne
	private Docente professor;
	
	private Disciplina(){
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
	
	public Docente getProfessor(){
		return professor;
	}
	
	public void setDocente(Docente professor){
		this.professor=professor;
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
		if (!(obj instanceof Disciplina))
			return false;

		Disciplina objDisciplina = (Disciplina) obj;

		return this.codigo.equals(objDisciplina.getCodigo());
	}

}
