package server.entity;

import java.util.ArrayList;

public class Auto {

	private int targa;
	private int id;
	private ArrayList<Configurabilita> lista_configurabilita=null;
	
	public Auto(int t,int id) {
		this.targa=t;
		this.id=id;
	}
	
	public void aggiungiConfigurabilita(Componente comp) {
		Configurabilita configurab= new Configurabilita(this,comp);
		lista_configurabilita.add(configurab);
	}
	
	public ArrayList<Componente> getAllComp() {
		ArrayList<Componente> lista_comp=null;
		for(int i=0;i<lista_configurabilita.size();i++) {
			if(lista_configurabilita.get(i).getAuto().equals(this) ) {
				lista_comp.add(lista_configurabilita.get(i).getComponente());
			}
		}
		return lista_comp;
	}
	
}
