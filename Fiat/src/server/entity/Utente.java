package server.entity;

import java.util.ArrayList;

public class Utente {

	private int password;
	private String name;
	private static int id=0;
	private ArrayList<Configurazione> lista_conf= null;
	private ArrayList<Proprieta> lista_proprieta= null;
	public Utente(String n,int p) {
		this.password=p;
		this.name=n;
		id=id++;
	}

	public int getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void aggiungi_Conf(Configurazione c) {
		lista_conf.add(c);
	}
	
	public void aggiungi_Proprieta(Auto a) {
		Proprieta p= new Proprieta(a,this);
		lista_proprieta.add(p);
	}
	
	public ArrayList<Configurazione> getAllConf() {
		return this.lista_conf;
	}
	
	public ArrayList<Auto> getAllAuto(){
		ArrayList<Auto> lista_auto=null;
		for(int i=0;i<lista_proprieta.size();i++) {
			if(lista_proprieta.get(i).getProprietario().equals(this) ) {
				lista_auto.add(lista_proprieta.get(i).getAuto() );
			}
		}
		return lista_auto;
	}
	
}
