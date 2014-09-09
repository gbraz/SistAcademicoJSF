package br.ufc.mbean;

import java.util.Calendar;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.control.OperacoesEmAlunos;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

@ManagedBean(name = "cadastrarAluno")
@SessionScoped
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();

	public CadastrarAlunoBean() {
	}

	public String cadastrar() {
		// TODO: data de nascimento deve vir do usuário, via formulário
		Calendar nascimento = Calendar.getInstance();
		OperacoesEmAlunos.inserirAluno(aluno.getMatricula(), aluno.getNome(), nascimento, aluno.getSexo(),
				aluno.getCpf());
		return "confirma";
	}

	public Collection<Aluno> getAlunos() {
		return OperacoesEmAlunos.getAlunos();
	}

	public Aluno getAluno() {
		return aluno;
	}

	// TODO: é necessário o setAluno?
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	// TODO: é necessário paginaCadastro?
	public String paginaCadastro() {
		return "cadastro";
	}

	// TODO: buscar solução mais elegante... não parece ser necessário ter que
	// adicionar um método
	// ao bean para apenas retornar os values de um enum
	// deve haver alguma forma de acessar esses values sem a necessidade de ter
	// que adicionar
	// esse método
	public Sexo[] getSexos() {
		return Sexo.values();
	}

}
