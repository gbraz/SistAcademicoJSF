package br.ufc.control;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;

// TODO: esta classe possui duas responsabilidades:
// - realizar operações sobre Aluno
// - persistir informações sobre Aluno
// com a refatoração do sistema para utilizar JPA+Hibernate, espera-se que tais responsabilidades sejam separadas
public class OperacoesEmAlunos {

	private static Map<Integer, Aluno> tabela = new HashMap<Integer, Aluno>();

	public static Collection<Aluno> getAlunos() {
		return tabela.values();
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade de 
	// refatorar o método de forma que fique simples o suficiente para não necessitar de comentário?
	// TODO: retorna false caso o aluno não seja inserido. Para quem chama o método, 
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
	public static boolean inserirAluno(int matricula, String nome,
			Calendar dataNascimento, Sexo sexo, String cpf) {
		Aluno alunoAInserir = new Aluno(matricula, nome, dataNascimento, sexo, cpf);
		
		if (!tabela.containsKey(matricula)) {
			// TODO: talvez fique mais explícito que essa matrícula é a mesma da do Aluno
			// chamando tabela.put(alunoAInserir.getMatricula(), alunoAInserir)
			tabela.put(matricula, alunoAInserir);
			return true;
		}
		return false;
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade de 
	// refatorar o método de forma que fique simples o suficiente para não necessitar de comentário?
	// TODO: retorna false caso o aluno não seja editado. Para quem chama o método, 
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
	public static boolean editarAluno(int matricula, String nome,
			Calendar nascimento, Sexo sexo, String cpf) {
		
		Aluno alunoAEditar = tabela.get(matricula);
		
		if (alunoAEditar != null) {
			
			alunoAEditar.setNome(nome);
			alunoAEditar.setMatricula(matricula);
			alunoAEditar.setSexo(sexo);
			alunoAEditar.setCpf(cpf);
			alunoAEditar.setNascimento(nascimento);
			
			return true;
		}
		
		return false;
	}

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade de 
	// refatorar o método de forma que fique simples o suficiente para não necessitar de comentário?
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

	// TODO: há necessidade desse comentário? Se houver, não há a possibilidade de 
	// refatorar o método de forma que fique simples o suficiente para não necessitar de comentário?
	/**
	 * Método que retorna um aluno dado a matrícula
	 * 
	 * @author Geraldo
	 * @return aluno se ele foi encontrado; null se ele não foi encontrado
	 */
	public static Aluno getAluno(int matricula) {
		return tabela.get(matricula);
	}
}
