package pod.q1.node1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q1.node2.OrchestrationServer;

public class Main {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(40002);
		OrchestrationServer server = (OrchestrationServer) registry.lookup("Node2Server");
		System.out.println(server.query(null));
	}
}
