package br.ufc.model.dao;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Curso;
import br.ufc.model.dao.impl.CursoDAOImpl;

public class CursoDAOTeste {

	private CursoDAO cursoDAO = new CursoDAOImpl(EMF.TEST_PU);

	private Curso cursoSimples(String codigoDoCurso) {
		String nomeDoCurso = "Nome do Curso Default";

		return new Curso.CursoBuilder().nome(nomeDoCurso).codigo(codigoDoCurso).build();
	}

	private static Integer idCodigoCurso = 0;

	private String codigoDeCursoUnico() {
		return "CK" + CursoDAOTeste.idCodigoCurso++;
	}

	@Test
	public void cadastraCursoCorretamente() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.criar(curso);

		Assert.assertNotNull(curso.getId());
	}

	@Test
	public void seCriarCursoDeveEstarNoAll() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.criar(curso);

		Collection<Curso> allCursos = cursoDAO.all();

		Assert.assertTrue(allCursos.contains(curso));
	}

}