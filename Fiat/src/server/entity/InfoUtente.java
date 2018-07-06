package server.entity;

import java.util.ArrayList;


public class InfoUtente {

	private static InfoUtente InfoUtente_instance=null;
	private ArrayList<Utente> lista_utente;
	
	private InfoUtente() {
		lista_utente= new ArrayList<Utente>();
	}
	
	public static synchronized InfoUtente getInfoUtente() {
		if(InfoUtente_instance==null) {
		//	System.out.println("Inizializzo il gestore");
			InfoUtente_instance=new InfoUtente();
		}
		//System.out.println("Ritorna il gestore");
		return InfoUtente_instance;
	}
	
	public Utente registraUtente(String s,int p) {
		Utente u= new Utente(s,p);
		lista_utente.add(u);
		return u;
	}
	
	
}
