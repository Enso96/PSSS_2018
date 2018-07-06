package server.core_business;

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
	
}
