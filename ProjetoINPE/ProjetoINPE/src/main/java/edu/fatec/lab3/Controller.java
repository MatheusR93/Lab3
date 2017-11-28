package edu.fatec.lab3;

// IMPORTS FEITOS PELO PROFESSOR NO EXEMPLO
import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

import spark.Route;

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
	
	public void buscarProjetoCodigo(){
		get("/projeto/codigo/:texto", (req, res) -> {
			int id = Integer.valueOf(req.params("texto"));
			Projeto proj = modelo.buscarProjetoId(id);	
			return new Gson().toJson(proj);
			
		});
	}
	
	public void getAllProjects() {
		get("/projeto", (req, res) -> {
			return new Gson().toJson(modelo.listaProjetos());
		});
		
	}
	
	public void addProjeto(){
		get("/addProjetos/:id/:segmento/:titulo/:eixos/:fonteRecurso/:inicio/:termino/:cidade",(req,res) ->{
			Projeto projeto = new Projeto(Integer.valueOf(req.params(":id")),req.params(":segmento"),req.params(":titulo"),req.params(":eixos"),req.params(":fonteRecurso"),Integer.valueOf(req.params(":inicio")),Integer.valueOf(req.params(":termino")),req.params(":cidade"));
			modelo.addProjetos(projeto);
			return new Gson().toJson(projeto);
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