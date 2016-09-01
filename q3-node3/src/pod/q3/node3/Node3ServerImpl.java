package pod.q3.node3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q3.inode3.INode3;

@SuppressWarnings("serial")
public class Node3ServerImpl extends UnicastRemoteObject implements INode3 {

	protected Node3ServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void op2() throws RemoteException {
		System.out.println("Operação op2 em node 3 executada.");
	}

}
