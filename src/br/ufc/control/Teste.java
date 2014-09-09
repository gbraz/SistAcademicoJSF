package br.ufc.control;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.ufc.model.Aluno;
import br.ufc.model.Sexo;
import br.ufc.model.dao.AlunoDAO;
import br.ufc.model.dao.AlunoDAOImpl;

public class Teste {
	public static void main(String args[]){
		Calendar data = new GregorianCalendar();
		data.set(2015, 10, 12);
		Aluno a = new Aluno(6, "Zordon", data, Sexo.OUTRO,"00000-00");
		Aluno b = new Aluno(7, "Ryu", data, Sexo.HOMEM,"123456-00");
		AlunoDAO dao = new AlunoDAOImpl();
		
		dao.salvarAluno(a);
		dao.salvarAluno(b);
		for(Aluno p : dao.listaAluno()){
			System.out.println(p);
			System.out.println("\n\n");
		}
		
		
	}
}
