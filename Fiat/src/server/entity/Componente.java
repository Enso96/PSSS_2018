package server.entity;

public class Componente {

	private String nome;
	private int altezza;
	public Componente(String n) {
		nome=n;
	}
	
	public void configuraComp(Componente c) {
		altezza=c.altezza;
	}
}
