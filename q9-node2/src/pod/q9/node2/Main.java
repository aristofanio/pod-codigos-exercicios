package pod.q9.node2;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q9.share.INode2;

public class Main {

	public static void main(String[] args) throws AlreadyBoundException, IOException, InterruptedException {
		System.out.println("Criando Node2");
		INode2 node = new Node2Impl();
		//
		Registry registry = LocateRegistry.createRegistry(40000);
		registry.bind("Node2Server", node);
		//
		while(true){
			((Node2Impl) node).check();
			Thread.sleep(3000);
		}
	}
}
