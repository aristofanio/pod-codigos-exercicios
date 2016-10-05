package pod.q1.node3.impl;

import static org.junit.Assert.*;

import org.junit.Test;

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
