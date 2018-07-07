package server.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Configurazione implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Componente> lista_comp=null;
	private ArrayList<Auto> lista_auto_config=null;
	private static int id=0;
	private String name;
	
	public Configurazione(ArrayList<Componente> l_comp) {
		lista_comp=new ArrayList<Componente>(l_comp);
		lista_auto_config= new ArrayList<Auto>();
		id=id++;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Componente> getListaComp() {
		return lista_comp;
	}
	
	public void aggiungiAutoConfig(Auto a) {
		lista_auto_config.add(a);
	}
	
	public ArrayList<Auto> getAutoConfig() {
		return lista_auto_config;
	}
}
