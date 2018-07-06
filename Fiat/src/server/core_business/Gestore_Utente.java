package server.core_business;
import java.util.ArrayList;

import server.entity.Auto;
import server.entity.Configurazione;
import server.entity.Utente;
import server.entity.InfoUtente;

public class Gestore_Utente {

	private static Gestore_Utente gestoreUtente_instance=null;
	private InfoUtente info_utente;
	
	private Gestore_Utente() {
		info_utente = InfoUtente.getInfoUtente();
	}
	public static synchronized Gestore_Utente getGestoreUtente() {
		if(gestoreUtente_instance==null) {
		//	System.out.println("Inizializzo il gestore");
			gestoreUtente_instance=new Gestore_Utente();
		}
		//System.out.println("Ritorna il gestore");
		return gestoreUtente_instance;
	}
	
	public Utente registraUtente(String s,int p) {
		return info_utente.registraUtente(s, p);
	}
	
	public ArrayList<Configurazione> getAllConf(Utente u) {
		return u.getAllConf();
	}
	
	public ArrayList<Auto> getAllAuto(Utente u){
		return u.getAllAuto();
	}
	
}

