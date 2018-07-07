package server.server_proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import interfaccia.IGestoreCPS_Server;
import server.entity.Utente;
import server.entity.Auto;
import server.entity.Configurazione;
public class SkeletonThread implements Runnable{

	private Socket socket;
	private IGestoreCPS_Server ges_cps;
	
	public SkeletonThread(Socket s, IGestoreCPS_Server iges) {
		socket=s;
		ges_cps=iges;
	}
	
	@Override
	public void run() {
		try {
			DataInputStream din= new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
			ObjectInputStream ois= new ObjectInputStream(din);
			
			System.out.println("OK");
			Utente utente=(Utente)ois.readObject();
			Utente u=this.ges_cps.checkUtente(utente);
			System.out.println("Id_utente: "+u.getId());
			System.out.println("Questo utente ha macchine pari a:"+u.getListaProprieta().size() );
			String comando= din.readUTF();
			if(comando.equalsIgnoreCase("associaConfigurazione")){
				
				/*Comunicazione con il client*/
				System.out.println("Associa conf");
				ArrayList<Auto> listaAuto= new ArrayList<Auto>(ges_cps.SelezionaAuto(u) );
				DataOutputStream dos= new DataOutputStream(new BufferedOutputStream(socket.getOutputStream() ));
				ObjectOutputStream oos= new ObjectOutputStream(dos);
				
				oos.writeObject(listaAuto);
				oos.flush();
				System.out.println("Aspetto scelta Auto");
				Auto autoScelta=(Auto)ois.readObject();
				System.out.println("Scelto Auto");
				
				ArrayList<Configurazione> listaConfigurazione= new ArrayList<Configurazione>(ges_cps.SelezionaConfigurazione(u));
				oos.writeObject(listaConfigurazione);
				oos.flush();
				System.out.println("Aspetto scelta Conf");
				Configurazione confScelta=(Configurazione)ois.readObject();
				System.out.println("Scelto Conf");
				
				//ges_cps.SelezionaConfigurazione(u);
				//ges_cps.associaConfigurazione(u);
				this.ges_cps.associaConfigurazione(autoScelta,confScelta);
				System.out.println("Configurata");
			}else{
				System.out.println("Comando non riconosciuto");
			}
		}catch(IOException e ){
				e.printStackTrace();
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
		}	
	}
}
