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


public class Projeto {
	private static int sequence = 0;
    private int id;
    private String segmento;
    private String titulo;
    private String eixos;
    private String fonteRecurso;
    private int inicio;
    private int termino;
    private String cidade;
    
    ObjectContainer coordenadores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "coordenador.db4o");
    //private List<Coordenador> coordenadores = new ArrayList<Coordenador>();
    ObjectContainer pesquisadores = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "pesquisador.db4o");
    //private List<Pesquisador> pesquisadores = new ArrayList<Pesquisador>();


    public Projeto(int id, String segmento, String titulo, String eixos, String fonteRecurso, int inicio, int termino,
			String cidade) {
		this.id = id;
		this.segmento = segmento;
		this.titulo = titulo;
		this.eixos = eixos;
		this.fonteRecurso = fonteRecurso;
		this.inicio = inicio;
		this.termino = termino;
		this.cidade = cidade;
	}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEixos() {
        return eixos;
    }

    public void setEixos(String eixos) {
        this.eixos = eixos;
    }

    public String getFonteRecurso() {
        return fonteRecurso;
    }

    public void setFonteRecurso(String fonteRecurso) {
        this.fonteRecurso = fonteRecurso;
    }

    public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getTermino() {
		return termino;
	}

	public void setTermino(int termino) {
		this.termino = termino;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
    public void addCoordenador(Coordenador coordenador){
    	this.coordenadores.store(coordenador);
    }
    
    public void addPesquisador(Pesquisador pesquisador){
    	this.pesquisadores.store(pesquisador);
    }
	

}
