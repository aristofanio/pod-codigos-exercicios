package pod.q9.node3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class Node3Impl extends UnicastRemoteObject implements INode3 {

	protected Node3Impl() throws RemoteException {
		super();
	}

	@Override
	public void update(String text) {
		File file = new File("disk.txt");
		try {
			FileOutputStream output = new FileOutputStream(file);
			output.write(text.getBytes());
			output.close();
		}
		catch(IOException e ){
			e.printStackTrace();
		}
	}

}
