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
		controller.buscarProjetoNome();
		controller.getAllProjects();

	}

	/*</option>
    <option value="pj2">Quantifica��o da concentra��o de isopreno na Amaz�nia, Cerrado e Pantanal e sensibilidade de suas emiss�es �s condi��es ambientais</option>
    <option value="pj3">Modelagem de cen�rios de recupera��o de vegeta��o nativa da Mata Atl�ntica</option>
    <option value="pj4">Delivering Food Security on Limited Land � DEVIL</option>
    <option value="pj5">Caracteriza��o da queima da turfa para mitiga��o do impacto ambiental dos inc�ndios em turfeiras na regi�o do Vale do Para�ba</option>
    <option value="pj6">Caracteriza��o da queima da turfa para mitiga��o do impacto ambiental dos inc�ndios em turfeiras na regi�o do Vale do Para�ba</option>
    <option value="pj7">DIN�MICA DE VEGETA��O SECUND�RIA EM SISTEMAS DE USO DA TERRA PELA PECU�RIA DE CORTE NO PAR�</option>
    <option value="pj8">A VIABILIDADE DO DESENVOLVIMENTO SUSTENT�VEL E INCLUS�O SOCIOECON�MICA EM �REAS DE PROTE��O E RECUPERA��O DE MANANCIAIS (APRMS)</option>
    <option value="pj9">Tr�nsito de bovinos no Pantanal de Mato Grosso do Sul</option>
    <option value="pj10">Caracteriza��o socioambiental do Pantanal Sul Mato-Grossense com o aux�lio do geoprocessamento: an�lise integrada do espa�o da pecu�ria bovina de corte pantaneira</option>
  */
/*	public static void inicializarProjetos() {
		modelo.addProjeto(new Projeto("Governan�a dos Recursos H�dricos e Participa��o P�blica: Explorando Possibilidades de Gest�o Integrada e Adaptativa na Regi�o Metropolitana do Vale do Para�ba em Cen�rio de Mudan�a Ambiental.", "Construir uma esta��o", "Vale do Para�ba",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Esta��o", "Construir uma esta��o", "S�o Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 1", "Construir uma esta��o","S�o Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 2", "Construir uma esta��o", "S�o Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 3", "Construir uma esta��o","S�o Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
	*/
		
		
	/*	
		
		
		Projeto p1 = new Projeto("Governan�a dos Recursos H�dricos e Participa��o P�blica: Explorando Possibilidades de Gest�o Integrada e Adaptativa na Regi�o Metropolitana do Vale do Para�ba em Cen�rio de Mudan�a Ambiental.", "Construir uma esta��o", new Abrangencia("Vale do Para�ba"),
			new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
			new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE");
	
		p1.addColaborador("Matheus");
		p1.addColaborador("Isaac");
		p1.addColaborador("Victor");
		
		
		modelo.addProjeto(p1);
		
		
		
		
		
	
	
		modelo.addProjeto(new Projeto("Governan�a dos Recursos H�dricos e Participa��o P�blica: Explorando Possibilidades de Gest�o Integrada e Adaptativa na Regi�o Metropolitana do Vale do Para�ba em Cen�rio de Mudan�a Ambiental.", "Construir uma esta��o", new Abrangencia("S�o Paulo"),
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
	}*/
}
