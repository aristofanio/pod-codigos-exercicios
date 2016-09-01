package pod.q1.node3;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q1.node3.impl.NodeServerImpl;

public class Main {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(40000);
		registry.bind("Node3Server", new NodeServerImpl());
	}
}
