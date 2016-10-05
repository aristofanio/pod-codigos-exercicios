package pod.q1.node4.impl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import pod.q1.node4.impl.NodeServerImpl;

public class NodeServerImplTest {

	@Test
	public void test() throws RemoteException {
		NodeServerImpl impl = new NodeServerImpl();
		assertNotNull(impl.query(null));
		assertEquals("Garcia Araujo", impl.query(null));
	}

}
