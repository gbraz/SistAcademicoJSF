package br.ufc.control;

import java.util.Calendar;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

@ManagedBean
public class OperacoesEmAlunos {
	private static HashMap<Integer, Aluno> tabela = new HashMap<Integer, Aluno>();

	public static HashMap<Integer, Aluno> getAlunos() {
		return tabela;
	}

	/**
	 * Insere um aluno na tabela
	 * 
	 * @author Geraldo
	 * 
	 * @param Matr�cula
	 * @param Nome
	 * @param Data
	 *            de nascimento
	 * @param Sexo
	 * @param CPF
	 * @return true - Se aluno inserido com sucesso; false - Se aluno n�o
	 *         inserido
	 */
	public static boolean inserirAluno(int matricula, String nome,
			Calendar dataNascimento, Sexo sexo, String cpf) {
		Aluno aluno = new Aluno(matricula, nome, dataNascimento, sexo, cpf);
		if (!tabela.containsKey(matricula)) {
			tabela.put(matricula, aluno);
			return true;
		}
		return false;
	}

	/**
	 * Edita os dados do Aluno na tabela
	 * 
	 * @author Geraldo
	 * @param Matriculado
	 *            aluno a ser editado.
	 * @return true - Se edi��o for concluida; false - Se edi��o for mal
	 *         sucedida
	 */
	public static boolean editarAluno(int matricula, String nome,
			Calendar nascimento, Sexo sexo, String cpf) {
		Aluno aluno;
		aluno = tabela.get(matricula);
		if (aluno != null) {
			aluno.setNome(nome);
			aluno.setMatricula(matricula);
			aluno.setSexo(sexo);
			aluno.setCpf(cpf);
			aluno.setNascimento(nascimento);
			return true;
		}
		return false;
	}

	/**
	 * Remove um aluno da lista de alunos
	 * 
	 * @author Geraldo
	 * @param Matricula
	 *            do aluno a ser removido.
	 * @return aluno - Aluno removido
	 */
	public static Aluno removerAluno(int matricula) {
		return tabela.remove(matricula);
	}

	/**
	 * M�todo que retorna um aluno dado a matr�cula
	 * 
	 * @author Geraldo
	 * @return aluno se ele foi encontrado; null se ele n�o foi encontrado
	 */
	public static Aluno getAluno(int matricula) {
		return tabela.get(matricula);
	}

	/**
	 * Cria uma c�pia de um aluno existente na tabela
	 * 
	 * @author Matheus
	 * @param matricula
	 * @return alunoCopia - Se aluno retorna a c�pia; null - Se aluno n�o
	 *         existir
	 */
	public static Aluno copyAluno(int matricula) {
		Aluno aluno, alunoCopia;
		aluno = tabela.get(matricula);
		if (aluno == null) {
			return aluno;
		} else {
			alunoCopia = new Aluno(aluno.getMatricula(), aluno.getNome(),
					aluno.getNascimento(), aluno.getSexo(), aluno.getCpf());
			return alunoCopia;
		}
	}
}
