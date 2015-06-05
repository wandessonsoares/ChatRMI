package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.IServidor;

public class Cliente extends UnicastRemoteObject implements ICliente {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private IServidor servidor;

	public Cliente(String name, String ip) throws RemoteException, MalformedURLException, NotBoundException{
		this.name = name;
		this.servidor = (IServidor) Naming.lookup("rmi://"+ ip + "/server");
		servidor.entrar(this);
	}

	@Override
	public void sair() throws RemoteException {
		this.servidor.removerUsuario(this);
		
	}	
	
	@Override
	public void exibir(String msg) throws RemoteException {
		System.out.println(msg);
	}
	
	public void listarUsuarios() throws RemoteException{
		this.servidor.listarUsuarios(this);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}