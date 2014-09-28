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
	private String novoNome;
	private String codigo;
	private int id;
	private boolean encontrado;
	
	public EditarCursoBean(){
	}
	
	public String editarNomePorId(){
		System.out.println(novoNome +" "+ id);
		cursoDAO.editarNome(novoNome, id);
		
		return "listar";
	}
	
	public String editarNomePorCodigo(){
		cursoDAO.editarNome(novoNome, id);
		
		return "listar";
	}
	
	
	public void buscarCurso(){
		Curso curso = cursoDAO.getCurso(id);
	
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
	
	public String getNovoNome(){
		return novoNome;
	}
	
	public void setNovoNome(String novoNome){
		this.novoNome = novoNome;
	}
	
	public boolean getEncontrado(){
		return encontrado;
	}
	
	public void setEncontrado(boolean encontrado){
		this.encontrado = encontrado;
	}
}
