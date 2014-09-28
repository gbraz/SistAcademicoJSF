package br.ufc.mbean.curso;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

//TODO: TERMINAR ESSE MANAGEDBEAN
@ManagedBean(name = "cadastrarCurso")
public class CadastrarCursoBean {
	private CursoDAO cursoDAO;

	private String nome;
	private String codigo;

	public CadastrarCursoBean() {
	}

	@PostConstruct
	public void init() {

		this.cursoDAO = new CursoDAOImpl();
	}

	public String cadastrar() {
		Curso cursoACadastrar = new Curso.CursoBuilder().nome(nome).codigo(codigo).build();
		cursoDAO.criar(cursoACadastrar);

		return "listar";
	}

	// getters and setters
	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String goToLink() {
		return "curso/cadastrar";
	}
}
