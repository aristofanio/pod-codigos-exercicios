package pod.q1.node2.impl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import pod.q1.node2.ServicesOrchestration;
import pod.q1.nodeserver.NodeServer;

public class ServicesOrchestrationImpl implements ServicesOrchestration {

	@Override
	public String query1(String params) {
		try {
			Registry registry = LocateRegistry.getRegistry(40000);
			NodeServer server = (NodeServer) registry.lookup("Node3Server");
			return server.query(params);
		}
		catch(IOException | NotBoundException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String query2(String params) {
		try {
			Registry registry = LocateRegistry.getRegistry(40001);
			NodeServer server = (NodeServer) registry.lookup("Node4Server");
			return server.query(params);
		}
		catch(IOException | NotBoundException e){
			e.printStackTrace();
		}
		return null;
	}

}
