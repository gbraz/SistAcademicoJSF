package br.ufc.model.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufc.model.dao.impl.AlunoDAOImplTeste;
import br.ufc.model.dao.impl.DocenteDAOImplTeste;
import br.ufc.model.dao.impl.CursoDAOImplTeste;
import br.ufc.model.dao.impl.DisciplinaDAOImplTeste;

@RunWith(Suite.class)
@SuiteClasses({ AlunoDAOImplTeste.class, DocenteDAOImplTeste.class, CursoDAOImplTeste.class, DisciplinaDAOImplTeste.class })
public class DAOSuite {

}
