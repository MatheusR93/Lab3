package edu.fatec.lab3;

public class Colaborador {
	
	private String nome;
	private String graduacao;
	private String email;
	//
	private Projeto projetoColaborado;
	
	
	
	public Colaborador(String nome, String graduacao, String email) {
		super();
		this.nome = nome;
		this.graduacao = graduacao;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGraduacao() {
		return graduacao;
	}
	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Projeto getProjetoColaborado() {
		return projetoColaborado;
	}
	public void setProjetoColaborado(Projeto projetoColaborado) {
		this.projetoColaborado = projetoColaborado;
	}
}
