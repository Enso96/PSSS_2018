package server.core_business;

import java.util.ArrayList;

import server.entity.Auto;
import server.entity.Componente;

public class Gestore_Auto {
	private static Gestore_Auto gestoreAuto_instance=null;
	
	private Gestore_Auto() {
		
	}
	public static synchronized Gestore_Auto getGestoreAuto() {
		if(gestoreAuto_instance==null) {
		//	System.out.println("Inizializzo il gestore");
			gestoreAuto_instance=new Gestore_Auto();
		}
		//System.out.println("Ritorna il gestore");
		return gestoreAuto_instance;
	}
	
	public ArrayList<Componente> getAllComp(Auto a) {
		return a.getAllComp();
	}

}
