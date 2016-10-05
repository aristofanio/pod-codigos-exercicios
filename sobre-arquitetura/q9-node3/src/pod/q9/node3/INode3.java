package pod.q9.node3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface INode3 extends Remote {
	void update(String text) throws RemoteException;
}
