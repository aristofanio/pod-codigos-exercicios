package pod.q9.node2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q9.share.INode2;
import pod.q9.share.Listener;

@SuppressWarnings("serial")
public class Node2Impl extends UnicastRemoteObject implements INode2 {
	private String oldText = "";
	private Listener listener = null;

	protected Node2Impl() throws RemoteException {
		super();
	}

	@Override
	public void registryListener(Listener listener) throws RemoteException {
		this.listener = listener;
	}
	
	public Listener getListener() {
		return listener;
	}
	
	public void check() throws IOException{
		String path = "/Volumes/MacintoshHDExt/ari.aula/ifpb.pod/exercicio-20161/q9-node3/disk.txt";
		File file = new File(path);
		if (file.exists()){
			FileInputStream input = new FileInputStream(file);
			byte[] b = new byte[1024];
			input.read(b);
			input.close();
			String text = new String(b).trim();
			if (!oldText.equals(text) && text != null){
				oldText = text;
				System.out.println("Encontrado texto diferente.");
				if (listener != null) {
					System.out.println("Notificando listener");
					listener.notifyNode1(text);
				}
			}			
		}
	}

}
