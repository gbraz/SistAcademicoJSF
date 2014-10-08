package br.ufc.mbean.aluno;

import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Aluno;
import br.ufc.model.Curso;
import br.ufc.model.Sexo;
import br.ufc.model.dao.GenericDAO;
import br.ufc.model.dao.impl.DAOFactory;

@RequestScoped
@ManagedBean(name = "cadastrarAluno")
public class CadastrarAlunoBean {

	private GenericDAO<Aluno> alunoDAO;
	private GenericDAO<Curso> cursoDAO;

	// dados do aluno
	private String cpf;
	private String nome;
	private Date dataDeNascimento;
	private Sexo sexo;
	private Curso curso;
	private Collection<Curso> cursos;

	public CadastrarAlunoBean() {
	}

	@PostConstruct
	public void init() {
		
		this.alunoDAO = DAOFactory.createDAO(Aluno.class);
		this.cursoDAO = DAOFactory.createDAO(Curso.class);
		this.cursos = cursoDAO.all();
	}

	public String cadastrar() {

		Aluno alunoACadastrar = new Aluno.AlunoBuilder().CPF(this.cpf).nome(this.nome)
				.dataDeNascimento(this.dataDeNascimento).sexo(this.sexo).build();
		alunoDAO.add(alunoACadastrar);

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
	
	public void setCurso(Curso curso) {
		this.curso =  curso;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Collection<Curso> getCursos(){
		return cursos;
	}
	
	public void setCursos(){
		
	}
	
	public String goToLink() {
		return "aluno/cadastrar";
	}

}
