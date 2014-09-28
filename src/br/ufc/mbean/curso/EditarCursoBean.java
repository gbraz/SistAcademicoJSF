package br.ufc.mbean.curso;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufc.model.Curso;
import br.ufc.model.dao.CursoDAO;
import br.ufc.model.dao.impl.CursoDAOImpl;

//TODO: TERMINAR ESSE MANAGEDBEAN
@RequestScoped
@ManagedBean(name="editarCurso")
public class EditarCursoBean {
	private CursoDAO cursoDAO = new CursoDAOImpl();
	
	private String nome;
	private String codigo;
	private int id;
	private boolean encontrado;
	
	public EditarCursoBean(){
	}
	
	public String removerPorId(){
		System.out.println(Integer.toString(id));
		cursoDAO.remover(id);
		
		return "curso/listar";
	}
	
	public String removerPorCodigo(){
		Curso cursoARemover = cursoDAO.getCursoCodigo(codigo);
		cursoDAO.remover(cursoARemover.getId());
		
		return "listar";
	}
	
	
	public void buscarCursoCodigo(){
		Curso curso = cursoDAO.getCursoCodigo(codigo);
	
		this.id = curso.getId();
		this.codigo = curso.getCodigo();
		this.nome = curso.getNome();
		this.encontrado = true;
	}
	
	public String goToLink(){
		return "curso/editar";
	}
	
	//getters and setters
	public String getCodigo(){
		return codigo;
	}
	
	public void setCodigo(String codigo){
		this.codigo = codigo;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public boolean getEncontrado(){
		return encontrado;
	}
	
	public void setEncontrado(boolean encontrado){
		this.encontrado = encontrado;
	}
}
