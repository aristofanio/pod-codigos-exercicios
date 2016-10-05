package pod.q3.node3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import pod.q3.inode1e2.INode1e2;
import pod.q3.inode3.INode3;

@SuppressWarnings("serial")
public class Node3ServerImpl extends UnicastRemoteObject implements INode3, INode1e2 {

	protected Node3ServerImpl() throws RemoteException {
		super();
	}

	@Override
	public void op2() throws RemoteException {
		System.out.println("Operação op2 em node 3 executada.");
	}
	
	@Override
	public void op1() throws RemoteException {
		//nome dos servidores
		String node1 = "Node1Server";
		String node2 = "Node2Server";
		//porta dos servidores
		int port[] = new int[]{40000, 40001};
		//decisão aleatória para o servidor
		int porta = port[(int)(Math.random() * 2)/*0 ou 1*/];//40000 ou 40001
		Registry registry = LocateRegistry.getRegistry(porta);
		//log
		if (porta == 40000) System.out.println("Operação 1 encaminhada para node 1.");
		else System.out.println("Operação 1 encaminhada para node 2.");
		//execução do serviço
		try {
			INode1e2 node = (INode1e2) registry.lookup(porta == 40000 ? node1 : node2);
			node.op1();
		}
		catch(RemoteException | NotBoundException e){
			e.printStackTrace();
		}
		
	}

}
