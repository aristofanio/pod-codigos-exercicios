package pod.q3.node2;

import java.util.List;

public interface Datastore {
	void saveItem(String text);
	List<String> listItems();
}
