package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	
	@Override
	public void broadcast(String msg) throws RemoteException {
		this.servidor.broadcast(this.getName() + 
				" : " + 
				msg.replace("\n", "") + 
				" : " + 
				new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy").format(new Date())+"\n");
	}
	
	@Override
	public void msgPrivada(String msg, String remetente) throws RemoteException {
		String emitente = this.getName();
		this.servidor.msgPrivada(msg, emitente, remetente);
	}
	
	public ArrayList<ICliente> listarUsuarios() throws RemoteException{
		return this.servidor.listarUsuarios(this);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void renomear(String novonome) throws RemoteException{
		this.servidor.renomear(this,novonome);
	}
}
