package server.entity;

import java.io.Serializable;

public class Componente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int altezza;
	public Componente(String n,int a) {
		nome=n;
		altezza=a;
	}
	
	public void configuraComp(Componente c) {
		altezza=c.altezza;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
}
