package br.ufc.control;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.EntityExistsException;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.AlunoDAOImpl;

// TODO: esta classe possui duas responsabilidades:
// - realizar operações sobre Aluno
// - persistir informações sobre Aluno
// com a refatoração do sistema para utilizar JPA+Hibernate, espera-se que tais responsabilidades sejam separadas
public class OperacoesEmAlunos {

	private static AlunoDAO alunoDAO = new AlunoDAOImpl();
	
	public static Collection<Aluno> getAlunos() {
		return alunoDAO.listaAluno();
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade
	// de
	// refatorar o método de forma que fique simples o suficiente para não
	// necessitar de comentário?
	// TODO: retorna false caso o aluno não seja inserido. Para quem chama o
	// método,
	// como saber a causa da não inserção?
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
	public static boolean inserirAluno(int matricula, String nome, Calendar dataNascimento, Sexo sexo, String cpf) {

		Aluno alunoAInserir = new Aluno(matricula, nome, dataNascimento, sexo, cpf);
		boolean alunoJaExiste = false;

		try {
			alunoDAO.salvarAluno(alunoAInserir);
		} catch (EntityExistsException ex) {
			alunoJaExiste = true;
		}

		return alunoJaExiste;
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade
	// de
	// refatorar o método de forma que fique simples o suficiente para não
	// necessitar de comentário?
	// TODO: retorna false caso o aluno não seja editado. Para quem chama o
	// método,
	// como saber a causa da não edição?
	/**
	 * Edita os dados do Aluno na tabela
	 * 
	 * @author Geraldo
	 * @param Matriculado
	 *            aluno a ser editado.
	 * @return true - Se edição for concluida; false - Se edição for mal
	 *         sucedida
	 */
	public static boolean editarAluno(int matricula, String nome, Calendar nascimento, Sexo sexo, String cpf) {

		Aluno alunoAEditar = getAluno(matricula);
		boolean edicaoOK = true;

		if (alunoAEditar != null) {

			alunoAEditar.setNome(nome);
			alunoAEditar.setSexo(sexo);
			alunoAEditar.setCpf(cpf);
			alunoAEditar.setNascimento(nascimento);

			try {
				alunoDAO.atualizarAluno(alunoAEditar);
			} catch (IllegalArgumentException ex) {
				edicaoOK = false;
			}
		}

		return edicaoOK;
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade
	// de
	// refatorar o método de forma que fique simples o suficiente para não
	// necessitar de comentário?
	/**
	 * Remove um aluno da lista de alunos
	 * 
	 * @author Geraldo
	 * @param Matricula
	 *            do aluno a ser removido.
	 * @return aluno - Aluno removido
	 */
	public static void removerAluno(int matricula) {
		alunoDAO.removerAlunoByMatricula(matricula);
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade
	// de
	// refatorar o método de forma que fique simples o suficiente para não
	// necessitar de comentário?
	/**
	 * Método que retorna um aluno dado a matrícula
	 * 
	 * @author Geraldo
	 * @return aluno se ele foi encontrado; null se ele não foi encontrado
	 */
	public static Aluno getAluno(int matricula) {
		return alunoDAO.getAluno(matricula);
	}
}
