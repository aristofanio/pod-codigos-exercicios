package pod.q3.node2;

import org.junit.Test;

import pod.q3.node2.impl.DatastoreImpl;

public class DatastoreTest {

	@Test
	public void test() {
		Datastore datastore = new DatastoreImpl();
		//
		datastore.saveItem("Ari");
		datastore.saveItem("Well");
		//
		for (String item : datastore.listItems()) {
			System.out.println(item);
		}
	}

}
