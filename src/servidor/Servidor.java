package servidor;

import java.net.MalformedURLException; 
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cliente.ICliente;

public class Servidor extends UnicastRemoteObject implements IServidor {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<ICliente> usuarios;
	
	protected Servidor() throws RemoteException {
		this.usuarios = new ArrayList<ICliente>();
	}

	@Override
	public ArrayList<ICliente> listarUsuarios(ICliente usuario) throws RemoteException {
		return usuarios;
	}

	@Override
	public void entrar(ICliente usuario) throws RemoteException {
		usuarios.add(usuario);
		for (ICliente u : usuarios) {
			if(!u.equals(usuario)) u.exibir(usuario.getName() + " acabou de entrar \n");
			else usuario.exibir("Bem vindo ao chat.");
		}
	}

	public ArrayList<ICliente> getUsuarios() {
		return usuarios;
	}
	
	@Override
	public void removerUsuario(ICliente user) throws RemoteException {
		usuarios.remove(user);
		user.exibir(user.getName() + " saiu");
	}
	
	@Override
	public void broadcast(String msg) throws RemoteException {
		for (ICliente user : usuarios) {
			user.exibir(msg);
		}
	}
	
	@Override
	public void msgPrivada(String msg, String emitente, String remetente) throws RemoteException {
		String msgFormatada = emitente + 
				" : " + 
				msg.replace("\n", "") + 
				" : " + 
				new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy").format(new Date())+"\n";
		
		for(ICliente user: usuarios) {
			if (user.getName().equals(remetente)){
				user.exibir(msgFormatada);
			}
		}
		
	}
	
	@Override
	public void renomear(ICliente usuario, String novonome) throws RemoteException {
		boolean usado = false;
		
		for (ICliente c : usuarios) {
			if(novonome.equals(c.getName())){
				usado = true;
			}
		}
		
		if(usado == true){
			usuario.exibir("\n**Nome de usuario ja em uso.");
		}
		
		else{
			usuario.setName(novonome);
			usuario.exibir("\n**Renomeado com sucesso.");
		}
	}

	public static void main(String[] args) {
		
		try {
			Servidor s = new Servidor();
			// criando o serviço de registro
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			// registrando o objeto
			Naming.bind("server", s);
			System.out.println("Servidor rodando...");
			
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}