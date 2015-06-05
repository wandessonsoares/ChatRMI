package cliente;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteApp {
	
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		Scanner n = new Scanner(System.in);
		
		String name;
		String ip;
		String msg;
		
		System.out.println("Digite seu nome: ");
		name = n.nextLine().trim();
		System.out.println("Digite o IP do server: ");
		ip = n.nextLine().trim();
		
		Cliente c = new Cliente(name, ip);
		
		boolean keep = true;
		
		while(keep) {
			
			msg = n.nextLine();
			
			if (msg.equals("BYE")) {
				c.sair();
				keep = false;
			}
			
			if (msg.equals("LIST")) {
				c.listarUsuarios();
			}
		}
		
	}
	
}