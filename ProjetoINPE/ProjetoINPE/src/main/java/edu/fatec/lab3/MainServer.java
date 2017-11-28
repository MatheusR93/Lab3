package edu.fatec.lab3;


import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;
import java.util.List;



public class MainServer {
	final static Modelo modelo = new Modelo();

	public static void main(String[] args) {

		// Get port config of heroku on environment variable
		ProcessBuilder process = new ProcessBuilder();
		Integer port;
		if (process.environment().get("PORT") != null) {
			port = Integer.parseInt(process.environment().get("PORT"));
		} else {
			port = 1245;
		}
		port(port);

		// Servir conteudo html, css e javascript
		staticFileLocation("/static");
		//inicializarProjetos();


		Controller controller = new Controller(modelo);
		controller.getAllProjects();
		controller.addProjeto();
		controller.buscarProjetoCodigo();
		controller.excluirProjeto();
		controller.insereCoordenador();
		controller.inserePesquisador();
		
	}
	
	
//	 public static void inicializarProjetos(){
//		 modelo.addProjetos(new Projeto(3,"Doutorado", "teste", "teste2", "Fatec", 2012, 2020, "São José dos Campos"));
//		 modelo.addProjetos(new Projeto(2,"Mestrado", "teste", "teste2", "Senai", 2012, 2019, "São Paulo"));
//	 }
	
}
