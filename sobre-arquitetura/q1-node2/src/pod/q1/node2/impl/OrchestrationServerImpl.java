package pod.q1.node2.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q1.node2.OrchestrationServer;

@SuppressWarnings("serial")
public class OrchestrationServerImpl extends UnicastRemoteObject implements OrchestrationServer {

	public OrchestrationServerImpl() throws RemoteException{
		super();
	}
	
	@Override
	public String query(String params) throws RemoteException {
		ServicesOrchestrationImpl impl = new ServicesOrchestrationImpl();
		//
		String queryResult1 = impl.query1(params);
		String queryResult2 = impl.query2(params);
		//
		return queryResult1 + " " + queryResult2;
	}

}
