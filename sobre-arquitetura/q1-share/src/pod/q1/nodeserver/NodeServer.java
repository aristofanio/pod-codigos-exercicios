package pod.q1.nodeserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Responsável por disponibilizar um servidor.
 * 
 * @author arigarcia
 *
 */
public interface NodeServer extends Remote {
	String query(String params) throws RemoteException;
}
