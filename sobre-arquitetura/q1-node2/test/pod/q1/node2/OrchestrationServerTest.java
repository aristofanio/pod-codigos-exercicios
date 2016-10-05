package pod.q1.node2;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import pod.q1.node2.impl.OrchestrationServerImpl;

public class OrchestrationServerTest {

	@Test
	public void test() throws RemoteException {
		OrchestrationServer orchestrationServer = new OrchestrationServerImpl();
		String result =  orchestrationServer.query(null);
		assertEquals("Ari Garcia Garcia Araujo", result);
	}

}
