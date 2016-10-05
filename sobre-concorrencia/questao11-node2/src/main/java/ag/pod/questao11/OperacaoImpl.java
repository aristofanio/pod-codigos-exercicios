package ag.pod.questao11;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperacaoImpl extends UnicastRemoteObject implements Operacao {
  
  protected OperacaoImpl() throws RemoteException {
    super();
  }

  public String op() throws RemoteException {
    System.out.println("Estou processando");
    GlobalVariable variable = GlobalVariable.instance();
    String value;
    synchronized (variable) {
      variable.incrOp2();
      value = variable.toString();
    }
    return value;
  }

}
