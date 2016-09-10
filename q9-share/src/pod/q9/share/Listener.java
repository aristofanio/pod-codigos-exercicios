package pod.q9.share;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Listener extends Remote {
	void notifyNode1(String text) throws RemoteException;
}
