package br.ufc.mbean.disciplina;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Disciplina;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

//TODO: TERMINAR ESSE MANAGEDBEAN
@RequestScoped
@ManagedBean(name = "cadastrarDiscliplina")
public class CadastrarDisciplinaBean {

	private GenericDAO<Disciplina> disciplinaDAO;

	private String nome;
	private String codigo;

	public CadastrarDisciplinaBean() {
	}

	@PostConstruct
	public void init() {

		this.disciplinaDAO = DAOFactory.createDAO(Disciplina.class);
	}

	public String cadastrar() {

		Disciplina disciplinaACadastrar = new Disciplina.DisciplinaBuilder().nome(nome).codigo(codigo).build();
		disciplinaDAO.add(disciplinaACadastrar);

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
}
