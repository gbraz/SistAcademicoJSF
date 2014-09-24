package br.ufc.model;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.CursoDAOImpl;

public class CursoTeste {

	private CursoDAO cursoDAO = new CursoDAOImpl(EMF.TEST_PU);

	@Test
	public void cursoTemNome() {

		String nomeDoCurso = "Computação";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).build();

		Assert.assertEquals(nomeDoCurso, curso.getNome());
	}

	@Test
	public void cursoTemCodigo() {
		String codigoDoCurso = "CK123";
		Curso curso = new Curso.CursoBuilder().codigo(codigoDoCurso).build();

		Assert.assertEquals(codigoDoCurso, curso.getCodigo());
	}

	@Test
	public void cadastraCursoCorretamente() {
		String nomeDoCurso = "Ciência da Computação";
		String codigoDoCurso = "CK666";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso)
				.codigo(codigoDoCurso).build();

		cursoDAO.criar(curso);

		Assert.assertNotNull(curso.getId());
	}

	@Test
	public void seCriarCursoDeveEstarNoAll() {
		String nomeDoCurso1 = "Matemática";
		String codigoDoCurso1 = "CK001";
		Curso curso1 = new Curso.CursoBuilder().nome(nomeDoCurso1)
				.codigo(codigoDoCurso1).build();

		cursoDAO.criar(curso1);

		Assert.assertTrue(cursoDAO.all().contains(curso1));
	}
}
