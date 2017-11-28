package hello;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
import java.util.Scanner;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;
import java.util.List;

public class Clinica {
	
	
		ObjectContainer pacientes = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "paciente.db4o");
		//private List<Paciente> paciente = new LinkedList<Paciente>();
		ObjectContainer medicos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"medico.db4o");
		//private List<Medico> medico = new LinkedList<Medico>();
		ObjectContainer consultas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"consulta1.db4o");
		//private List<Consulta> consulta = new LinkedList<Consulta>();
		ObjectContainer administradores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"administrador");
		//private List<Administrador> administrador = new LinkedList<Administrador>();
		
		
	
		public void addPaciente(Paciente paciente){
			this.pacientes.store(paciente);
		}
		
		public void addMedico(Medico medico){
			this.medicos.store(medico);
		}
			
		public void addConsulta(Consulta consulta){
			this.consultas.store(consulta);
		}
		
		public void addAdm(Administrador adm){
			this.administradores.store(adm);
		}
		
		public Consulta criarAgenda(String crm, String agenda, String horario, String status){
			Medico md = buscaMedico(crm);
			Consulta cs = new Consulta(agenda,horario,md,status); 
			return cs;
		}
		
		
		
		
		public Consulta inserePaciente(String cpf,int id){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> allConsultas = query.execute();
			
		    Paciente p = buscaPaciente(cpf);
			for(Consulta c : allConsultas){
				if(c.getId()==id){
					c.setPaciente(p);
					c.setStatus("Agendada");
					return c;
				}
				
			}
			return null;
		}
		
		// Método Novo.
		public Paciente loginPaciente(String cpf,String senha){
			Query query = pacientes.query();
			query.constrain(Paciente.class);
		    ObjectSet<Paciente> p = query.execute();
			
			for(Paciente paciente : p){
				if(paciente.getCPF().equals(cpf) && paciente.getSenha().equals(senha)){
					return paciente;
				}
			}
			return null;
		}
		
		//Método Novo busca Especialidade
		/*public void ListaPorEspecialidade(){
			Query query = medicos.query();
			query.constrain(Medico.class);
		    ObjectSet<Medico> allMedicos = query.execute();
			
		    LinkedList<String> med = new LinkedList<String>();
			for(Medico m : allMedicos) {
				med.add(m.getEspecialidade());
			}
			
			for(int i = 0; i<med.size();i++){
				System.out.println(med.get(i));
			}
		}*/
		
		
		
		public Medico loginMedico(String crm,String senha){
			Query query = medicos.query();
			query.constrain(Medico.class);
		    ObjectSet<Medico> m = query.execute();
			
		    for(Medico medico : m){
				if(medico.getCrm().equals(crm) && medico.getSenha().equals(senha)){
					return medico;
				}
			}
			return null;
		}
		
		public Administrador loginAdministrador(String usuario, String senha){
			Query query = administradores.query();
			query.constrain(Administrador.class);
		    ObjectSet<Administrador> ad = query.execute();
			
			for(Administrador administrador:ad){
				if(administrador.getUsuario().equals(usuario) && administrador.getSenha().equals(senha)){
					return administrador;	
				}
			}
			return null;
		}
		
		public Paciente buscaPaciente(String cpf){
			Query query = pacientes.query();
			query.constrain(Paciente.class);
		    ObjectSet<Paciente> allPacientes = query.execute();
		    
			for(Paciente pa : allPacientes) {
				if(pa != null && pa.getCPF().equals(cpf)){
					return pa;
				}
			}
			return null;	
		}
		
		public Medico buscaMedico(String crm){
			Query query = medicos.query();
			query.constrain(Medico.class);
		    ObjectSet<Medico> allMedicos = query.execute();
		    
			for(Medico m : allMedicos) {
				if(m != null && m.getCrm().equals(crm)){
					return m;
				}
			}
			return null;	
		}
		
		public List<Consulta> buscaConsultaporMedico(String medico){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> ConsultaPorMedico = query.execute();
			
			List<Consulta> con = new LinkedList<Consulta>();
			for(Consulta c : ConsultaPorMedico) {
				if(c != null){
					if(c.getMedico().getNome().equals(medico)){
						con.add(c);
					}
				}
			}
			return con;	
		}
		
		
		public List<Medico> listaMedicos(){
			return (List<Medico>)medicos;
		}
		
		
		public List<Consulta> buscaConsultaporPaciente(String cpf){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> ConsultasPorPaciente = query.execute();
			
			List<Consulta> con = new LinkedList<Consulta>();
			for(Consulta c : ConsultasPorPaciente) {
				if(c.getPaciente() != null){
					if(c.getPaciente().getCPF().equals(cpf)){
						con.add(c);
					}
					
				}
			}
			return con;	
		}
				
		
		public List<Consulta> listaConsulta(){
			return (List<Consulta>) this.consultas;
		}
		
		
		
		public List<Consulta> ConsultaListaAberta(){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> ConsultasAbertas = query.execute();
			
			List<Consulta> ab = new LinkedList<Consulta>();
			for(Consulta c : ConsultasAbertas) {
				if(c != null){
					if(c.getStatus().equals("Consulta Aberta")){
						ab.add(c);
					}
				}
			}
			return ab;	
		}
		
		public Consulta ConsultaListaPorEspecialidade(String espec){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> ConsultaPorEspecialidade = query.execute();
			
			for(Consulta c : ConsultaPorEspecialidade) {
				if(c!=null){
					if(c.getMedico().getEspecialidade().equals(espec)){
						return c;
					}
				}
			}
			return null;	
		}
		
		//troca Senha Paciente
		public Paciente trocaSenhaPaciente(String cpf,String senhaAntiga,String novasenha){
			Query query = pacientes.query();
			query.constrain(Paciente.class);
		    ObjectSet<Paciente> p = query.execute();
		    
		    for(Paciente pac : p){
		    	if(pac.getCPF().equals(cpf) && pac.getSenha().equals(senhaAntiga)){
		    		pac.setSenha(novasenha);
		    		pacientes.store(pac);
		    		pacientes.commit();
		    	}
		    }
			return null;
		}// A senha atual no banco de dados é www222.
		
		
		//exclui consulta
		/*public Consulta excluiPaciente(int id){
			Query query = consultas.query();
			query.constrain(Consulta.class);
		    ObjectSet<Consulta> allConsultas = query.execute();
			
			for(Consulta c : allConsultas){
				if(c.getId()==id){
					consultas.delete(c);
					return (Consulta) consultas;
				}
				
			}
			return null;
		}*/
		

		
		//Método cancelar consulta deixa pra lá
		/*public boolean cancelarConsulta (int id, String crm){
			Query query = consultas.query();
			query.constrain(Consulta.class);
			ObjectSet<Consulta> c = query.execute();
			for(Consulta cons : c){
				if(cons.getId() == id && cons.getMedico().getCrm().equals(crm)&&!cons.getPaciente().equals(null)){
					cons.setStatus("Consulta Cancelada");
					consultas.store(cons);
					consultas.commit();
				}else if(cons.getId() == id && cons.getMedico().getCrm().equals(crm)){
					consultas.delete(cons.getId() == id);
					consultas.commit();
				}
			}
			return true;
		}*/

}