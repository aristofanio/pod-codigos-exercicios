package pod.q1.node4.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q1.nodeserver.NodeServer;


@SuppressWarnings("serial")
public class NodeServerImpl extends UnicastRemoteObject implements NodeServer {

	public NodeServerImpl() throws RemoteException{
		super();
	}
	
	@Override
	public String query(String params) throws RemoteException {
		JdbcConnectImpl impl = new JdbcConnectImpl();
		return impl.query(params);
	}
}
