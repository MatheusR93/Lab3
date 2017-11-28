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
    <option value="pj2">Quantificação da concentração de isopreno na Amazônia, Cerrado e Pantanal e sensibilidade de suas emissões às condições ambientais</option>
    <option value="pj3">Modelagem de cenários de recuperação de vegetação nativa da Mata Atlântica</option>
    <option value="pj4">Delivering Food Security on Limited Land – DEVIL</option>
    <option value="pj5">Caracterização da queima da turfa para mitigação do impacto ambiental dos incêndios em turfeiras na região do Vale do Paraíba</option>
    <option value="pj6">Caracterização da queima da turfa para mitigação do impacto ambiental dos incêndios em turfeiras na região do Vale do Paraíba</option>
    <option value="pj7">DINÂMICA DE VEGETAÇÃO SECUNDÁRIA EM SISTEMAS DE USO DA TERRA PELA PECUÁRIA DE CORTE NO PARÁ</option>
    <option value="pj8">A VIABILIDADE DO DESENVOLVIMENTO SUSTENTÁVEL E INCLUSÃO SOCIOECONÔMICA EM ÁREAS DE PROTEÇÃO E RECUPERAÇÃO DE MANANCIAIS (APRMS)</option>
    <option value="pj9">Trânsito de bovinos no Pantanal de Mato Grosso do Sul</option>
    <option value="pj10">Caracterização socioambiental do Pantanal Sul Mato-Grossense com o auxílio do geoprocessamento: análise integrada do espaço da pecuária bovina de corte pantaneira</option>
  */
/*	public static void inicializarProjetos() {
		modelo.addProjeto(new Projeto("Governança dos Recursos Hídricos e Participação Pública: Explorando Possibilidades de Gestão Integrada e Adaptativa na Região Metropolitana do Vale do Paraíba em Cenário de Mudança Ambiental.", "Construir uma estação", "Vale do Paraíba",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Estação", "Construir uma estação", "São Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 1", "Construir uma estação","São Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 2", "Construir uma estação", "São Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
		modelo.addProjeto(new Projeto("Projeto 3", "Construir uma estação","São Paulo",
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
	*/
		
		
	/*	
		
		
		Projeto p1 = new Projeto("Governança dos Recursos Hídricos e Participação Pública: Explorando Possibilidades de Gestão Integrada e Adaptativa na Região Metropolitana do Vale do Paraíba em Cenário de Mudança Ambiental.", "Construir uma estação", new Abrangencia("Vale do Paraíba"),
			new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
			new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE");
	
		p1.addColaborador("Matheus");
		p1.addColaborador("Isaac");
		p1.addColaborador("Victor");
		
		
		modelo.addProjeto(p1);
		
		
		
		
		
	
	
		modelo.addProjeto(new Projeto("Governança dos Recursos Hídricos e Participação Pública: Explorando Possibilidades de Gestão Integrada e Adaptativa na Região Metropolitana do Vale do Paraíba em Cenário de Mudança Ambiental.", "Construir uma estação", new Abrangencia("São Paulo"),
				new Coordenador("Isaac Nascimento", "ETEP", "teste@teste.com"),
				new Colaborador("Matheus Rodrigues", "UNIVAP", "teste2@teste.com"), "INPE"));
		
	}*/
}
