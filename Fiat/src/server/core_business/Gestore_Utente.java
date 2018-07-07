package server.core_business;
import java.util.ArrayList;
// ìò poXxò tù nò
import server.entity.Auto;
import server.entity.Configurazione;
import server.entity.Utente;
import server.entity.InfoUtente;
import server.entity.Proprieta;

public class Gestore_Utente {

	private static Gestore_Utente gestoreUtente_instance=null;
	private InfoUtente info_utente;
	
	private Gestore_Utente() {
		info_utente = InfoUtente.getInfoUtente();
	}
	public static synchronized Gestore_Utente getGestoreUtente() {
		if(gestoreUtente_instance==null) {
		//	System.out.println("Inizializzo il gestoreUtente");
			gestoreUtente_instance=new Gestore_Utente();
		}
		//System.out.println("Ritorna il gestoreUtente");
		return gestoreUtente_instance;
	}
	
	public Utente registraUtente(String s,int p) {
		return info_utente.registraUtente(s, p);
	}
	
	public ArrayList<Configurazione> getListaConf(Utente u) {
		return u.getListaConf();
	}
	
	public ArrayList<Auto> getAllAuto(Utente u){
		ArrayList<Proprieta> lista_proprieta=new ArrayList<Proprieta>(u.getListaProprieta());
		ArrayList<Auto> lista_auto=new ArrayList<Auto>();
		for(int i=0;i<lista_proprieta.size();i++) {
			lista_auto.add(lista_proprieta.get(i).getAuto());
			}
		return lista_auto;
	}
	
	public Utente getUtente(int id) {
		return info_utente.getUtente(id);
	}
	
	public Utente checkUtente(Utente u) {
		return info_utente.checkUtente(u);
	}
	
}

