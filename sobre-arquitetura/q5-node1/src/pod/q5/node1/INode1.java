package pod.q5.node1;

import java.util.List;

public interface INode1 {
	void request();
	void sync();
	void store(List<String> list);
	void update();
}
