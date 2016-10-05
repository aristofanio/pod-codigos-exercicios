package pod.q3.node2;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q3.inode1e2.INode1e2;

@SuppressWarnings("serial")
public class Node2ServerImpl extends UnicastRemoteObject implements INode1e2 {

	protected Node2ServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void op1() throws RemoteException {
		System.out.println("Operação 1 em node 2 executada.");
	}

}
