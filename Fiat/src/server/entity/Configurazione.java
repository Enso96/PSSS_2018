package server.entity;

import java.util.ArrayList;

public class Configurazione {
	private ArrayList<Componente> lista_comp=null;
	private ArrayList<Auto> lista_auto_config=null;
	
	public Configurazione(ArrayList<Componente> l_comp) {
		lista_comp=new ArrayList<Componente>(l_comp);
		lista_auto_config= new ArrayList<Auto>();
	}
	
	public ArrayList<Componente> getAllComp() {
		return lista_comp;
	}
	
	public void aggiungiAutoConfig(Auto a) {
		lista_auto_config.add(a);
	}
	
	public ArrayList<Auto> getAutoConfig() {
		return lista_auto_config;
	}
}
