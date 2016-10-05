package pod.q3.node1;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import pod.q3.inode1e2.INode1e2;
import pod.q3.inode3.INode3;

@SuppressWarnings("serial")
public class Node1ServerImpl extends UnicastRemoteObject implements INode1e2, INode3 {

	protected Node1ServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void op1() throws RemoteException {
		System.out.println("Operação 1 em node 1 executada.");
	}
	
	@Override
	public void op2() throws RemoteException {
		//
		System.out.println("Operação 2 encaminhada para node 3.");
		//
		Registry registry = LocateRegistry.getRegistry(40002);
		//
		try {
			INode3 node = (INode3) registry.lookup("Node3Server");
			node.op2();
		} 
		catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
