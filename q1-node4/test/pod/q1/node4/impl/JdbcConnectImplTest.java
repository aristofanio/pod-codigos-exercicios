package pod.q1.node4.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import pod.q1.node4.impl.JdbcConnectImpl;

public class JdbcConnectImplTest {

	@Test
	public void testConnect() {
		JdbcConnectImpl impl = new JdbcConnectImpl();
		assertNotNull(impl.connection());
	}
	
	@Test
	public void testQuery() {
		JdbcConnectImpl impl = new JdbcConnectImpl();
		assertNotNull(impl.query(null));
	}

}
