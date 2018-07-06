package server.server_proxy;


public class Server {

	public static void main(String[] args) {
		Gestore_CPS ges_cps= Gestore_CPS.getGestoreCPS();
		ges_cps.runSkeleton();

	}

}
