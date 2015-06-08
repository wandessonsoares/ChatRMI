package servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import cliente.ICliente;

public interface IServidor extends Remote{
	public ArrayList<ICliente> listarUsuarios(ICliente usuario) throws RemoteException;
	public void entrar(ICliente usuario) throws RemoteException;
	public void renomear(ICliente usuario, String msg) throws RemoteException;
	public void removerUsuario(ICliente usuario) throws RemoteException;
	public String broadcast(String msg) throws RemoteException;
	public void msgPrivada(String msg, String emitente, String remetente) throws RemoteException;
}
