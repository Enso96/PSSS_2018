package client.client_core;

import client.client_proxy.GestoreCPS_Proxy;
import server.entity.Utente;

public class UtenteConsole {

	public static void main(String[] args) {
		GestoreCPS_Proxy ges_cps=new GestoreCPS_Proxy();
		Utente u= new Utente("dario",1234);
		System.out.println(u.getId());
		ges_cps.associaConfigurazione(u);
	}

}
