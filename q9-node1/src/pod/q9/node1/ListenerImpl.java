package pod.q9.node1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import pod.q9.share.Listener;

/**
 * Em RMI todos os objetos precisam ser serializáveis (quando precisar de dados)
 * e exportáveis quando precisar do serviço (que implementa uma interface Remote).
 * Como não posso usar um listener apenas como interface, eu o torno exportável 
 * utilizando UnicastRemoteObject.
 * 
 * Caminho indicado por Wenstay e Natarajan, só falta dizer onde implementar.
 * O resultado é este: 
 * - implementar o listener como exportável do lado do cliente!
 * 
 * @author arigarcia
 *
 */
@SuppressWarnings("serial")
public abstract class ListenerImpl extends UnicastRemoteObject implements Listener {

	protected ListenerImpl() throws RemoteException {
		super();
	}

}
