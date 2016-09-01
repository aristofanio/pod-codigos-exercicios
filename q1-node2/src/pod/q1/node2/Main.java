package pod.q1.node2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q1.node2.impl.OrchestrationServerImpl;

public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(40002);
		registry.bind("Node2Server", new OrchestrationServerImpl());
	}
}
