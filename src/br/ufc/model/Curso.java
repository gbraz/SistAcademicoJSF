package br.ufc.model;

public class Curso {
	
	private String nome;
	private String codigo;
	
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

}
