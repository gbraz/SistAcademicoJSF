package br.ufc.mbean.curso;

import javax.faces.bean.ManagedBean;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

//TODO: TERMINAR ESSE MANAGEDBEAN
@ManagedBean(name="removerCurso")
public class RemoverCursoBean {
	private CursoDAO cursoDAO = new CursoDAOImpl();
	
	private String nome;
	private String codigo;
	
	
	public RemoverCursoBean(){
	}
	
	public String removerPorId(int id){		
		cursoDAO.remover(id);
		
		return "listar";
	}
	
	public String removerPorCodigo(String codigo){
		Curso cursoARemover = cursoDAO.getCursoCodigo(codigo);
		cursoDAO.remover(cursoARemover.getId());
		
		return "listar";
	}
	
	
	//getters and setters
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public String goToLink(){
		return "curso/remover";
	}
}
