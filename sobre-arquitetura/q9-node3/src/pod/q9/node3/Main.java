package pod.q9.node3;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws RemoteException {
		System.out.println("Criando Node3");
		INode3 node = new Node3Impl();
		Scanner s = new Scanner(System.in);
		while(true){
			String text = s.nextLine();
			node.update(text);
			if ("break".equals(text)) break;
		}
		s.close();
	}
}
