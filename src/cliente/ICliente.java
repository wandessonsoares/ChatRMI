package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote{
	public void sair() throws RemoteException;
	public String getName() throws RemoteException;
	public void exibir(String msg) throws RemoteException;
}