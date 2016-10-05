package pod.q9.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INode2 extends Remote{
	void registryListener(Listener listener) throws RemoteException;
}
