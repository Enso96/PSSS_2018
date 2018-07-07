package server.entity;

import java.io.Serializable;

public class Configurabilita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
