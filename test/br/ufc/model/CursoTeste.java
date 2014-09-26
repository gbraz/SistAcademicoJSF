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
		String nomeDoCurso = "Matemática";
		String codigoDoCurso = "CK001";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso)
				.codigo(codigoDoCurso).build();

		cursoDAO.criar(curso);

		Assert.assertTrue(cursoDAO.all().contains(curso));
	}
	
	@Test
	public void removerCursoPeloId(){
		String nomeDoCurso = "Química";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).build();
		
		cursoDAO.criar(curso);
		Curso cursoRemovido = cursoDAO.remover(curso.getId());
		
		Assert.assertEquals(curso, cursoRemovido);
	}
}
