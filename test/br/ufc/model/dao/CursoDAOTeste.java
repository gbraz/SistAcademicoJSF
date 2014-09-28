package br.ufc.model.dao;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
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
	
	@Test
	public void encontraCursoPeloId(){
		String nomeDoCurso = "Química";
		String codigoDoCurso = "CC12221";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).codigo(codigoDoCurso).build();
		
		cursoDAO.criar(curso);
		Curso cursoEncontrado = cursoDAO.porID(curso.getId());

		Assert.assertEquals(codigoDoCurso, cursoEncontrado.getCodigo());
		Assert.assertEquals(nomeDoCurso, cursoEncontrado.getNome());
		Assert.assertEquals(curso.getId(), cursoEncontrado.getId());
	}
	
	@Test
	public void encontraIdPeloCodigo(){
		String nomeDoCurso = "Química";
		String codigoDoCurso = "CC1";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).codigo(codigoDoCurso).build();
		
		cursoDAO.criar(curso);
		Curso cursoEncontrado = cursoDAO.porCodigo(codigoDoCurso);
		
		Assert.assertEquals(codigoDoCurso, cursoEncontrado.getCodigo());
		Assert.assertEquals(nomeDoCurso, cursoEncontrado.getNome());
	}
	
	@Test
	public void editarNomeDoCurso(){
		String nomeDoCurso = "F!losofia";
		String codigoDoCurso = "CC00222";
		
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).codigo(codigoDoCurso).build();
		cursoDAO.criar(curso);
		
		String novoNomeDoCurso = "Filosofia";
		cursoDAO.editarNome(novoNomeDoCurso, curso.getId());
		
		Curso cursoEditado = cursoDAO.porID(curso.getId());
		
		Assert.assertEquals(novoNomeDoCurso, cursoEditado.getNome());
		
				
	}

	@Test
	public void removerCursoPeloId(){
		String nomeDoCurso = "Química";
		Curso curso = new Curso.CursoBuilder().nome(nomeDoCurso).build();
		
		cursoDAO.criar(curso);
		Curso cursoRemovido = cursoDAO.remover(curso.getId());
		
		Assert.assertEquals(curso, cursoRemovido);
	}
	
	// TODO: com o hsqldb está ficando travado nesse teste... com o mysql está
	// funcionando... Why?!
	// @Test
	// public void codigoDoCursoDeveSerUnico() {
	//
	// String codigo = codigoDeCursoUnico();
	// Curso curso1 = cursoSimples(codigo);
	// Curso curso2 = cursoSimples(codigo);
	//
	// cursoDAO.criar(curso1);
	// try {
	// cursoDAO.criar(curso2);
	// } catch (PersistenceException ex) {
	//
	// }
	// }

}