package client.client_proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import interfaccia.IGestoreCPS;
import server.entity.Auto;
import server.entity.Configurazione;
import server.entity.Utente;

public class GestoreCPS_Proxy implements IGestoreCPS {

	private static final int NUMPORTA=8585;
	private Socket socket;
	public GestoreCPS_Proxy(){
		try{
			socket= new Socket(InetAddress.getLocalHost().getHostAddress(),NUMPORTA);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void associaConfigurazione(Utente u) {
		try{
			DataOutputStream dos= new DataOutputStream(new BufferedOutputStream(socket.getOutputStream() ));
		    ObjectOutputStream oos = new ObjectOutputStream(dos);
			
			
			System.out.println("Entro2");
			oos.writeObject(u);
			dos.writeUTF("associaConfigurazione");
			dos.flush();
			
			DataInputStream dis= new DataInputStream(new BufferedInputStream(socket.getInputStream() ));
			ObjectInputStream ois= new ObjectInputStream(dis);
			ArrayList<Auto> listaAuto=new ArrayList<Auto>();
			listaAuto=(ArrayList<Auto>)ois.readObject();
			System.out.println("ottenuto lista Auto"+listaAuto.size());
			System.out.println("Scelgo Auto con targa:"+listaAuto.get(0).getTarga());
			oos.writeObject(listaAuto.get(0));
			oos.flush();
			
			ArrayList<Configurazione> listaConfigurazione=new ArrayList<Configurazione>();
			listaConfigurazione=(ArrayList<Configurazione>)ois.readObject();
			System.out.println("ottenuto lista Configurazione"+listaConfigurazione.size());
			oos.writeObject(listaConfigurazione.get(0));
			oos.flush();
			
			dis.close();
			dos.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
