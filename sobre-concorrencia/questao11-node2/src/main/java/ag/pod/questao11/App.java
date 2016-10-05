package ag.pod.questao11;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class App {
  
  public static void main(String[] args) throws IOException, ServerForwarderException, AlreadyBoundException {
    //registrar o serviço no servidor de rmi
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind(OperacaoImpl.SERVICE_NAME, new OperacaoImpl());
    //registrar o servidor web
    ServerSocketOperacaoImpl impl = new ServerSocketOperacaoImpl();
    impl.start(80);
  }
  
}
