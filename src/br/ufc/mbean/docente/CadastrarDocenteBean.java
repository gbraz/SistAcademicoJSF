package br.ufc.mbean.docente;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Docente;
import br.ufc.model.Sexo;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@RequestScoped
@ManagedBean(name = "cadastrarDocente")
public class CadastrarDocenteBean {

	private GenericDAO<Docente> docenteDAO;

	// dados do aluno
	private String cpf;
	private String nome;
	private Date dataDeNascimento;
	private Sexo sexo;

	public CadastrarDocenteBean() {
	}

	@PostConstruct
	public void init() {

		this.docenteDAO = DAOFactory.createDAO(Docente.class);
	}

	public String cadastrar() {

		Docente docenteACadastrar = new Docente.DocenteBuilder().CPF(this.cpf).nome(this.nome)
				.dataDeNascimento(this.dataDeNascimento).sexo(this.sexo).build();
		docenteDAO.add(docenteACadastrar);

		return "listar";
	}

	// TODO: forma melhor de acessar os valores do enum Sexo na tela
	public Sexo[] getSexos() {
		return Sexo.values();
	}

	// ---------------------------getters and setters-------------------------
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
