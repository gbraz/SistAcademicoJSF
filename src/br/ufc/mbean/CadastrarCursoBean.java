package br.ufc.mbean;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Curso;
import br.ufc.model.Curso.CursoBuilder;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.CursoDAOImpl;

//TODO: TERMINAR ESSE MANAGEDBEAN
@ManagedBean(name="cadastrarCurso")
public class CadastrarCursoBean {
	private CursoDAO cursoDAO = new CursoDAOImpl();
	
	private String nomeCurso;
	private String codigoCurso;
	
	
	public CadastrarCursoBean(){
	}
	
	public String cadastrar(){
		Curso cursoACadastrar = new Curso.CursoBuilder().
											nome(nomeCurso).
											codigo(codigoCurso)
											.build();
		cursoDAO.criar(cursoACadastrar);
		
		return "confirmaCurso";
	}
	
	//getters and setters
	public String getNomeCurso(){
		return nomeCurso;
	}
	
	public String getCodigoCurso(){
		return codigoCurso;
	}
	
	public void setNomeCurso(String nomeCurso){
		this.nomeCurso = nomeCurso;
	}
	
	public void setCodigoCurso(String codigoCurso){
		this.codigoCurso = codigoCurso;
	}
}
