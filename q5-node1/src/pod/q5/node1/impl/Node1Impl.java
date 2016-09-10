package pod.q5.node1.impl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import pod.q5.node1.INode1;
import pod.q5.share.INode2;

public class Node1Impl implements INode1 {
	private static List<String> list = new ArrayList<>();
	private int offset = 0;
	
	private void requestLocal(){
		for (String s : list) {
			System.out.println("local: " + s);
		}
	}

	private boolean requestRemote(){
		try{
			Registry registry = LocateRegistry.getRegistry(40000);
			INode2 node = (INode2) registry.lookup("Node2Server");
			List<String> list = node.fetchAll(offset);
			store(list);
			for (String s : list) {
				System.out.println(s);
			}
			return true;
		}
		catch(IOException | NotBoundException e){
			return false;
		}
	}
	
	@Override
	public void request() {
		if (!requestRemote()){//
			requestLocal();
		}
	}

	@Override
	public void sync() {
		try{
			Registry registry = LocateRegistry.getRegistry(40000);
			INode2 node = (INode2) registry.lookup("Node2Server");
			List<String> list = node.fetchAll(offset);
			store(list);
		}
		catch(IOException | NotBoundException e){
			e.printStackTrace();
		}
	}

	@Override
	public void store(List<String> items) {
		list.addAll(items);
		offset += items.size();
	}

	@Override
	public void update() {
		System.out.println("Atualizar itens existentes.");
	}

}
