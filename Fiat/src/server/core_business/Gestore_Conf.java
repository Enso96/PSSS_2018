package server.core_business;

import java.util.ArrayList;

import server.entity.Auto;
import server.entity.Componente;
import server.entity.Configurazione;

public class Gestore_Conf {

	private static Gestore_Conf gestoreConf_instance=null;
	
	private Gestore_Conf() {
		
	}
	public static synchronized Gestore_Conf getGestoreConf() {
		if(gestoreConf_instance==null) {
		//	System.out.println("Inizializzo il gestore");
			gestoreConf_instance=new Gestore_Conf();
		}
		//System.out.println("Ritorna il gestore");
		return gestoreConf_instance;
	}
	
	public ArrayList<Componente> getAllComp(Configurazione c) {
		return c.getAllComp();
	}
	
	public void aggiungiAutoConfig(Auto a,Configurazione c) {
		c.aggiungiAutoConfig(a);
	}
}
