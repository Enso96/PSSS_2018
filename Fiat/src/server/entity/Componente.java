package server.entity;

public class Componente {

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
