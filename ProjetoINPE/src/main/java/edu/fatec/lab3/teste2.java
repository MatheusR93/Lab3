package hello;
import static spark.Spark.get;

import java.util.List;

import com.google.gson.Gson;

import spark.Route;

public class ControllerClin {
	
	private Clinica clinica;
	
	
	public ControllerClin(Clinica clinica){
		this.clinica = clinica;
	} 
	
	
	//metodo login usuario
	public Paciente loginPaciente(){
		get("/loginpaciente/:usuario/:senha", (req, res) -> {
			Paciente paclogin = clinica.loginPaciente(req.params(":usuario"),req.params(":senha"));		
			return new Gson().toJson(paclogin);			
		});
		return null;
	}
	
	//metodo login medico
	public Medico loginMedico(){
		get("/loginmedico/:usuario/:senha", (req, res) -> {
			Medico medicoLogin = clinica.loginMedico(req.params(":usuario"),req.params(":senha"));		
			return new Gson().toJson(medicoLogin);
		});
		return null;
	}

	//metodo login Administrador
	public Administrador loginAdministrador(){
		get("/loginadministrador/:usuario/:senha", (req, res) -> {
			Administrador admlogin = clinica.loginAdministrador(req.params(":usuario"),req.params(":senha"));		
			return new Gson().toJson(admlogin);			
		});
		return null;
	}
	
	public Paciente buscaPaciente(){
		get("/Paciente/:cpf",(req,res) ->{
			Paciente p = clinica.buscaPaciente(req.params(":cpf"));
			return new Gson().toJson(p);
		});
		return null;
	}
	
	public Medico buscaMedico(){
		get("/Medico/:crm",(req,res) ->{
			Medico m = clinica.buscaMedico(req.params(":crm"));
			return new Gson().toJson(m);
		});
		return null;
	}
	
	public Consulta buscaConsultaporMedico(){
		get("/ConsultaMedico/:medico",(req,res) ->{
			List<Consulta> c = clinica.buscaConsultaporMedico(req.params(":medico"));
			return new Gson().toJson(c);
		});
		return null;
	}
	
	public List<Medico> listaMedico(){
		get("/Medico/", (req,res) ->{
			List<Medico> lista = clinica.listaMedicos();
			return new Gson().toJson(lista);
		});
		return null;
	}
	
	public List<Consulta> buscaConsultaporPaciente(){
		get("/ConsultaPaciente/:cpf",(req,res) ->{
			List<Consulta> c = clinica.buscaConsultaporPaciente(req.params(":cpf"));
			return new Gson().toJson(c);
		});
		return null;
	}
	
	public List<Consulta> listaConsulta(){
		get("/Consulta/", (req,res) ->{
			List<Consulta> listaC = clinica.listaConsulta();
			return new Gson().toJson(listaC);
		});
		return null;
	}
	
	public List<Consulta> ConsultaListaAberta(){
		get("/ConsultaAberta/", (req,res) ->{
			List<Consulta> listaC = clinica.listaConsulta();
			return new Gson().toJson(listaC);
		});
		return null;
	}
	
	public Consulta criarAgenda(){
		get("/criarAgenda/:crm/:agenda/:horario/:status", (req,res) ->{
			Consulta c = clinica.criarAgenda(req.params(":crm"),req.params(":agenda"),req.params(":horario"), req.params(":status"));
			return new Gson().toJson(c);
	});
		return null;
		
	}
	
	public Consulta inserePaciente(){
		get("/inserePaciente/:cpf/:id", (req,res) ->{
			Consulta c = clinica.inserePaciente(req.params(":cpf"),Integer.valueOf(req.params(":id")));
			return new Gson().toJson(c);
	});
		return null;	
	}
	
	public Consulta ConsultaListaPorEspecialidade(){
		get("/ConsultaListaPorEspecialidade/:especialidade", (req,res) ->{
			Consulta listaC = clinica.ConsultaListaPorEspecialidade(req.params("espec"));
			return new Gson().toJson(listaC);
		});
		return null;
	}
	
	//Método troca senha
	public Paciente trocaSenhaPaciente(){
		get("/trocaSenha/:cpf/:senhaAntiga/:senhaNova", (req,res) ->{
			Paciente p = clinica.trocaSenhaPaciente(req.params("cpf"),(req.params("senhaAntiga")),(req.params("senhaNova")));
			return new Gson().toJson(p);
		});
		return null;
	} 
	
	//Método cancelar consulta
	/*public boolean cancelarConsulta(){
		get("/cancelarConsulta/:id/:med", (req,res) ->{
			boolean c = clinica.cancelarConsulta(Integer.valueOf(req.params("id")), (req.params("med")));
			return new Gson().toJson(c);
		});
		return true;
	} */
	
	
}
