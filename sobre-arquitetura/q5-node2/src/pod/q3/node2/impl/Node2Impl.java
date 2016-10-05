package pod.q3.node2.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import pod.q3.node2.Datastore;
import pod.q5.share.INode2;


@SuppressWarnings("serial")
public class Node2Impl extends UnicastRemoteObject implements INode2 {

	public Node2Impl() throws RemoteException {}
	
	@Override
	public List<String> fetchAll(int offset) {
		//
		List<String> result = new ArrayList<>();
		//
		Datastore datastore = new DatastoreImpl();
		List<String> list = datastore.listItems();
		for (int i = offset; i < list.size(); i++){
			result.add(list.get(i));
		}
		//
		return result;
	}

}
