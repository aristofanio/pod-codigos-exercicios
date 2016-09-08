package pod.q3.node2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q3.node2.impl.Node2Impl;

public class Main {

	public static void main(String... args) throws RemoteException, AlreadyBoundException{
		Registry registry = LocateRegistry.createRegistry(40000);
		registry.bind("Node2Server", new Node2Impl());
	}
}
