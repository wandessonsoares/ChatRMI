package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote{
	public void sair() throws RemoteException;
	public String getName() throws RemoteException;
	public void setName(String nome) throws RemoteException;
	public void renomear(String msg) throws RemoteException;
	public void exibir(String msg) throws RemoteException;
	public void broadcast(String msg) throws RemoteException;
	public void msgPrivada(String msg, String remetente) throws RemoteException;
}
