package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cliente.ICliente;

public interface IServidor extends Remote{
	public void listarUsuarios(ICliente usuario) throws RemoteException;
	public void entrar(ICliente usuario) throws RemoteException;
	public void removerUsuario(ICliente usuario) throws RemoteException;
	public void broadcast(String msg) throws RemoteException;
	public void msgPrivada(String msg, String emitente, String remetente) throws RemoteException;
}
