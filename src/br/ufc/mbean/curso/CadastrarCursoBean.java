package br.ufc.mbean.curso;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

//TODO: TERMINAR ESSE MANAGEDBEAN
@RequestScoped
@ManagedBean(name = "cadastrarCurso")
public class CadastrarCursoBean {

	private GenericDAO<Curso> cursoDAO;

	private String nome;
	private String codigo;

	public CadastrarCursoBean() {
	}

	@PostConstruct
	public void init() {

		this.cursoDAO = DAOFactory.createDAO(Curso.class);
	}

	public String cadastrar() {

		Curso cursoACadastrar = new Curso.CursoBuilder().nome(nome).codigo(codigo).build();
		cursoDAO.add(cursoACadastrar);

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
