package br.ufc.mbean;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Aluno;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.impl.AlunoDAOImpl;

@ManagedBean(name = "listarAluno")
public class ListarAlunoBean {

	private AlunoDAO alunoDAO = new AlunoDAOImpl();

	private Collection<Aluno> alunos = alunoDAO.all();

	public Collection<Aluno> getAlunos() {
		return this.alunos;
	}
}
