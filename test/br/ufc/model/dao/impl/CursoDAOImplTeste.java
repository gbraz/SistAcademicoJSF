package br.ufc.model.dao.impl;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import br.ufc.infra.EMF;
import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

public class CursoDAOImplTeste {

	private CursoDAO cursoDAO = new CursoDAOImpl(EMF.TEST_PU);

	@Test
	public void cadastraCursoCorretamente() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.add(curso);

		Assert.assertNotNull(curso.getId());
	}

	@Test
	public void seCriarCursoDeveEstarNoAll() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.add(curso);

		Collection<Curso> allCursos = cursoDAO.all();

		Assert.assertTrue(allCursos.contains(curso));
	}

	@Test
	public void seRemoveCursoDeveNaoEstarNoAll() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.add(curso);
		cursoDAO.remove(curso);

		Collection<Curso> allCursos = cursoDAO.all();

		Assert.assertFalse(allCursos.contains(curso));
	}

	@Test
	public void seUpdateCursoDeveAlterarNoBanco() {

		String codigo = codigoDeCursoUnico();
		Curso curso = cursoSimples(codigo);

		cursoDAO.add(curso);

		String novoNome = curso.getNome() + "mudado";

		curso.setNome(novoNome);

		cursoDAO.update(curso);

		// TODO: mudar quando houver método para buscar por código/id
		Collection<Curso> allCursos = cursoDAO.all();

		Curso cursoDoBD = null;
		for (Curso cursoBD : allCursos) {
			// TODO: mudar quando o equals do curso estiver considerando apenas
			// o id
			if (curso.getId().equals(cursoBD.getId())) {
				cursoDoBD = cursoBD;
				break;
			}
		}

		// TODO: atualizar caso novos campos sejam adicionados
		Assert.assertEquals(novoNome, cursoDoBD.getNome());
	}

	private final static String NOME_DO_CURSO_SIMPLES = "Nome do Curso Default";

	private Curso cursoSimples(String codigoDoCurso) {

		return new Curso.CursoBuilder().nome(CursoDAOImplTeste.NOME_DO_CURSO_SIMPLES).codigo(codigoDoCurso).build();
	}

	private static Integer idCodigoCurso = 0;

	private String codigoDeCursoUnico() {
		return "CK" + CursoDAOImplTeste.idCodigoCurso++;
	}
}