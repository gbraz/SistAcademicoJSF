package br.ufc.model;


import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.CursoDAOImpl;

public class CursoTeste {

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
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).codigo(codigoDoCurso).build();
		
		CursoDAO cursoDao = new CursoDAOImpl(EMF.TEST_PU);
		
		Curso cursoCadastrado = cursoDao.criar(curso);
				
		Assert.assertEquals(nomeDoCurso, cursoCadastrado.getNome());
		Assert.assertEquals(codigoDoCurso, cursoCadastrado.getCodigo());
	}
}
