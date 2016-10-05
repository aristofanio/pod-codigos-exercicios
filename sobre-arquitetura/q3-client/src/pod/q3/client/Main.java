package pod.q3.client;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q3.inode1e2.INode1e2;
import pod.q3.inode3.INode3;

public class Main {

	public static void testOp1(int port) throws RemoteException, NotBoundException{
		//
		String node1Server = "Node1Server";//40000
		String node2Server = "Node2Server";//40001
		//
		Registry registry = LocateRegistry.getRegistry(port);
		INode1e2 node = (INode1e2) registry.lookup(
				port == 40000 ? node1Server : node2Server
		);
		node.op1();
	}
	
	public static void testOp2() throws AccessException, RemoteException, NotBoundException{
		//
		String node3Server = "Node3Server";//40002
		//
		Registry registry = LocateRegistry.getRegistry(40002);
		INode3 node = (INode3) registry.lookup(node3Server);
		node.op2();
	}
	
	public static void testForwardOp1() throws RemoteException, NotBoundException{
		//
		String node3Server = "Node3Server";//40002
		//
		Registry registry = LocateRegistry.getRegistry(40002);
		INode1e2 node = (INode1e2) registry.lookup(node3Server);
		node.op1();
	}
	
	public static void testForwardOp2() throws RemoteException, NotBoundException{
		//
		String node1Server = "Node1Server";//40000
		//
		Registry registry = LocateRegistry.getRegistry(40000);
		INode3 node = (INode3) registry.lookup(node1Server);
		node.op2();
	}
	
	public static void main(String[] args) throws RemoteException, NotBoundException {
		for (int i = 0; i < 10; i++){
			//requisicao para Op1
			boolean isnode1 = ((int)(Math.random() * 1000) % 2) == 0;
			testOp1(isnode1 ? 40000 : 40001);
			//requisição para Op2
			testOp2();
			//encaminhar a requisição para Op1
			testForwardOp1();
			//encaminhar a requisição para Op2
			testForwardOp2();
		}
	}
	
}
