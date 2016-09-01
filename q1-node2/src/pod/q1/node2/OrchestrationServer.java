package pod.q1.node2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrchestrationServer extends Remote {
	String query(String params) throws RemoteException;
}
