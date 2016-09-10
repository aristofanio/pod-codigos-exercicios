package pod.q9.node1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q9.share.INode2;

public class Node1 {

	public void printInfo(String text){
		System.out.println("notify: " + text);
	}
	
	@SuppressWarnings("serial")
	public void registryInNode2(){
		try {
			Registry registry = LocateRegistry.getRegistry(40000);
			INode2 node2 = (INode2) registry.lookup("Node2Server");
			node2.registryListener(new ListenerImpl(){
				@Override
				public void notifyNode1(String text) throws RemoteException {
					System.out.println(text);
				}
			});
		} catch (RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}
