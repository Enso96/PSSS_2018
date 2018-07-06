package server.entity;

public class Configurabilita {

	private Componente comp;
	private Auto auto;
	
	public Configurabilita(Auto a,Componente c) {
		auto=a;
		comp=c;
	}
	
	public Componente getComponente() {
		return comp;
	}
	
	public Auto getAuto() {
		return auto;
	}
}
