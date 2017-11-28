package edu.fatec.lab3;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Modelo {

		
	ObjectContainer projetos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "projetos.db4o");
	ObjectContainer administradores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"administrador.db4o");

	public void addProjetos(Projeto projeto){
		this.projetos.store(projeto);
	}
	
	public void addAdm(Administrador adm){
		this.administradores.store(adm);
	}
	
	public Administrador loginAdministrador(String nome, String senha){
		Query query = administradores.query();
		query.constrain(Administrador.class);
	    ObjectSet<Administrador> ad = query.execute();
		
		for(Administrador administrador:ad){
			if(administrador.getNome().equals(nome) && administrador.getSenha().equals(senha)){
				return administrador;	
			}
		}
		return null;
	}
	
	public Projeto buscarProjetoId(int id){
		Query query = projetos.query();
		query.constrain(Projeto.class);
		ObjectSet<Projeto> ProjetoPorId = query.execute();
		
		for(Projeto p : ProjetoPorId){
			if(p!=null){
				if(p.getId() == id){
					return p;
				}
			}
			return null;
		}
		return null;
	}
	
	public void excluiProjeto(int id){
		Query query = projetos.query();
		query.constrain(Projeto.class);
		ObjectSet<Projeto> ProjetoPorId = query.execute();
		
		for(Projeto p : ProjetoPorId){
			if(p.getId()==id){
				projetos.delete(p);
			}
		}
		
		
	}
	
	public Projeto buscarProjetoNome(String nome){
		Query query = projetos.query();
		query.constrain(Projeto.class);
		ObjectSet<Projeto> ProjetoPorNome = query.execute();
		
		for(Projeto pj : ProjetoPorNome) {
			if(pj!=null){
				if(pj.getTitulo().equalsIgnoreCase(nome)){
					return pj;
				}
			}
		}
		return null;
	}
	
	//public List<Projeto> listaProjetos(){
		//return (List<Projeto>) projetos;
	//}
	public List<Projeto> listaProjetos(){
		Query query = projetos.query();
		query.constrain(Projeto.class);
		ObjectSet<Projeto> allProjetos = query.execute();
		List<Projeto> listaProj = new ArrayList<Projeto>();
		
		for(Projeto projeto: allProjetos){
			listaProj.add(projeto);
		}
		
		return listaProj;
	}
	
}