package cliente;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClienteApp {
	
	private static Scanner teclado;

	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
		
		teclado = new Scanner(System.in);
		
		String nome;
		String ip;
		String comando;
		
		System.out.println("Digite seu nome: ");
		nome = teclado.nextLine().trim();
		System.out.println("Digite o IP do servidor: ");
		ip = teclado.nextLine().trim();
		
		Cliente c = new Cliente(nome, ip);
		
		boolean conectado = true;
		
		while(conectado) {
			
			comando = teclado.nextLine();
			
			if (comando.equals("bye")) {
				c.sair();
				conectado = false;
			}
			
			if (comando.equals("list")) {
				c.listarUsuarios();
			}
			
			if (comando.contains("send -all")){
				String mensagem = comando.substring(9);
				c.broadcast(mensagem);
			}
			
			if (comando.contains("send -user")){
				String temp = comando.substring(11);
				String remetente = temp.substring(0, temp.indexOf(" "));
				String mensagem = temp.substring(temp.indexOf(" "));
				
				c.msgPrivada(mensagem, remetente);
			}
			
			if(comando.contains("rename")){
				String novonome = comando.substring(7);
				
				c.renomear(novonome);
			}
		}
		
	}
	
}