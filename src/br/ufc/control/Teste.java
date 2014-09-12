package br.ufc.control;

import java.util.Date;
import java.util.GregorianCalendar;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.AlunoDAOImpl;

public class Teste {
	public static void main(String args[]) {
		Date data = (new GregorianCalendar(2010, 0, 11)).getTime();

		Aluno a = new Aluno("Zordon", data, Sexo.OUTRO, "00000-00");
		System.out.println(a.toString());

		Aluno b = new Aluno("Ryu", data, Sexo.HOMEM, "123456-00");
		AlunoDAO dao = new AlunoDAOImpl();

		dao.salvarAluno(a);
		dao.salvarAluno(b);
		for (Aluno p : dao.listaAluno()) {
			System.out.println(p);
			System.out.println("\n\n");
		}

	}
}
