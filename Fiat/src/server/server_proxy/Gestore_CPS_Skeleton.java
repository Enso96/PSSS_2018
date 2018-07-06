package server.server_proxy;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import interfaccia.IGestoreCPS;


public abstract class Gestore_CPS_Skeleton implements IGestoreCPS {

	public void runSkeleton(){
		try{
			ServerSocket s= new ServerSocket(8585);
			System.out.println("Server avviato e in attesa");
			while(true){
				Socket socket=s.accept();
				DataInputStream din= new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				String comando= din.readUTF();
				if(comando.equalsIgnoreCase("associaConfigurazione")){
					/*Comunicazione con il client*/
					//L'utente si deve identificare con qualcosa( id)
					//IgestoreCPS deve avere un metodo per verificare l'utente
					//e dovrà passare per il gestore utente con il metodo getUtente(id)
					
					//this.associaConfigurazione(u);
				}else if( comando.equalsIgnoreCase("Altra Azione del server")){
					/*Comunicazione con il client*/
				}
				else{
					System.out.println("Comando non riconosciuto");
				}
				s.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}