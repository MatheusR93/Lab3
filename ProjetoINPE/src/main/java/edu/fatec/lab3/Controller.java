package edu.fatec.lab3;

// IMPORTS FEITOS PELO PROFESSOR NO EXEMPLO
import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {

	private Modelo modelo;

	public Controller(Modelo modelo){
		this.modelo = modelo;
	}

	public Administrador loginAdministrador(){
		get("/loginadministrador/:nome/:senha", (req, res) -> {
			Administrador admlogin = modelo.loginAdministrador(req.params(":usuario"),req.params(":senha"));		
			return new Gson().toJson(admlogin);			
		});
		return null;
	}
	
	public void buscarProjetoNome(){
		get("/projeto/titulo/:texto", (req, res) -> {
			String texto = req.params("texto");
			Projeto proj = modelo.buscarProjetoNome(texto);	
			return new Gson().toJson(proj);
			
		});
	}
	
	public void getAllProjects() {
		get("/projeto", (req, res) -> {
			List<Projeto> projetos = (List<Projeto>) modelo.listaProjetos();	
			return new Gson().toJson(projetos);
		});
		
	}
	public void addaProjeto(){
		get("/addProjetos.html/:tipo/:nomeProj/:eixos/:fonteRecurso/:inicio/:termino/:cidade",(req,res) ->{
			Projeto projeto = new Projeto(req.params(":tipo"),req.params(":nomeProj"),req.params(":eixos"),req.params(":fonteRecurso"),Integer.valueOf(req.params(":inicio")),Integer.valueOf(req.params(":termino")),req.params(":cidade"));
			modelo.addProjetos(projeto);
			return new Gson().toJson(true);
		});
	}
	
	public void addProjeto(){
		get("/addProjetos.html/:segmento/:titulo/:eixos/:fonteRecurso/:inicio/:termino/:cidade",(req,res) ->{
			Projeto projeto = new Projeto(req.params(":segmento"),req.params(":titulo"),req.params(":eixos"),req.params(":fonteRecurso"),Integer.valueOf(req.params(":inicio")),Integer.valueOf(req.params(":termino")),req.params(":cidade"));
			modelo.addProjetos(projeto);
			return new Gson().toJson(true);
		});
	}
	
	public void inserePesquisador(){
		get("/inserePesquisador/:idprojeto/:nome/:graduacao/:email", (req,res) ->{
			Projeto p = modelo.buscarProjetoId(Integer.valueOf(req.params(":id")));
			Pesquisador pesquisador = new Pesquisador(req.params(":nome"),req.params(":graduacao"),req.params(":email"));
			p.addPesquisador(pesquisador);
			return new Gson().toJson(true);
	});
	}
	
	public void insereCoordenador(){
		get("/insereCoordenador/:idprojeto/:nome/:graduacao/:email", (req,res) ->{
			Projeto p = modelo.buscarProjetoId(Integer.valueOf(req.params(":id")));
			Coordenador coordenador = new Coordenador(req.params(":nome"),req.params(":graduacao"),req.params(":email"));
			p.addCoordenador(coordenador);
			return new Gson().toJson(true);
	});
	}
	
	public void excluirProjeto(){
		get("/excluirProjeto/:idprojeto",(req,res) ->{
			modelo.excluiProjeto(Integer.valueOf(req.params(":idprojeto")));
			return true;
		});
	}
	
}



/*package edu.fatec.lab3;

// IMPORTS FEITOS PELO PROFESSOR NO EXEMPLO
import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

public class Controller {

	private Modelo modelo;


	public Controller(Modelo modelo){
		this.modelo = modelo;
	}
	
	public void buscarProjetoNome(){
		get("/projeto/nome/:texto", (req, res) -> {
		
			String texto = req.params("texto");
			Projeto proj = modelo.buscarProjetoNome(texto);	
			return new Gson().toJson(proj);
			
		});
	}
	
	public void buscarProjetoDescricao(){
		get("/projeto/descricao/:texto", (req, res) -> {
			List<Projeto> projetosEncontrados = (List<Projeto>) modelo.buscarProjetoDescricao(req.params("texto"));	
			return new Gson().toJson(projetosEncontrados);
			
		});
	}

	public void getAllProjects() {
		get("/projeto", (req, res) -> {
			List<Projeto> projetos = (List<Projeto>) modelo.getProjetos();	
			return new Gson().toJson(projetos);
		});
		
	}
	
}*/