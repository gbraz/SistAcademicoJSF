package br.ufc.control;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

public class OperacoesEmAlunos {

	private static Map<Integer, Aluno> tabela = new HashMap<Integer, Aluno>();

	public static Collection<Aluno> getAlunos() {
		return tabela.values();
	}

	/**
	 * Insere um aluno na tabela
	 * 
	 * @author Geraldo
	 * 
	 * @param Matrícula
	 * @param Nome
	 * @param Data
	 *            de nascimento
	 * @param Sexo
	 * @param CPF
	 * @return true - Se aluno inserido com sucesso; false - Se aluno não
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
	 * @return true - Se edição for concluida; false - Se edição for mal
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
	 * Método que retorna um aluno dado a matrícula
	 * 
	 * @author Geraldo
	 * @return aluno se ele foi encontrado; null se ele não foi encontrado
	 */
	public static Aluno getAluno(int matricula) {
		return tabela.get(matricula);
	}

	/**
	 * Cria uma cópia de um aluno existente na tabela
	 * 
	 * @author Matheus
	 * @param matricula
	 * @return alunoCopia - Se aluno retorna a cópia; null - Se aluno não
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
