package br.ufc.mbean;

import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.ufc.control.OperacoesEmAlunos;
import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

@SessionScoped
@ManagedBean(name = "cadastrarAluno")
public class CadastrarAlunoBean {

	private Aluno aluno = new Aluno();

	public CadastrarAlunoBean() {
	}

	public String cadastrar() {
		OperacoesEmAlunos.inserirAluno(aluno.getNome(), aluno.getNascimento(), aluno.getSexo(),
				aluno.getCpf());
		return "confirma";
	}

	public Collection<Aluno> getAlunos() {
		return OperacoesEmAlunos.getAlunos();
	}

	public Aluno getAluno() {
		return aluno;
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

	public void setNascimento(Date dataNascimento){
		aluno.setNascimento(dataNascimento);
	}
	
	//TODO: Encontrar uma maneira de n�o precisar usar esse get
	// talvez com converter
	public Date getNascimento(){
		return aluno.getNascimento();
	}
}
