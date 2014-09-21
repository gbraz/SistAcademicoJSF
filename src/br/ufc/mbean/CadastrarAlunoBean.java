package br.ufc.mbean;

import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.control.AlunoService;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAOImpl;

@RequestScoped
@ManagedBean(name = "cadastrarAluno")
public class CadastrarAlunoBean {

	private AlunoService alunoService = new AlunoService(new AlunoDAOImpl());

	private String cpf;
	private String nome;
	private Date dataDeNascimento;
	private Sexo sexo;

	public CadastrarAlunoBean() {
	}

	public String cadastrar() {

		Aluno alunoACadastrar = new Aluno.AlunoBuilder().CPF(this.cpf).nome(this.nome)
				.dataDeNascimento(this.dataDeNascimento).sexo(this.sexo).build();
		alunoService.inserirAluno(alunoACadastrar);

		return "confirma";
	}

	public Collection<Aluno> getAlunos() {
		return alunoService.getAlunos();
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

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
