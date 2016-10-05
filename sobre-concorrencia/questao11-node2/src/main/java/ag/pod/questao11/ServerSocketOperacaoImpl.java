package ag.pod.questao11;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketOperacaoImpl {
  
  public void start(int port) throws IOException, ServerForwarderException{
    //criar um socket para servidor
    ServerSocket serverSocket = new ServerSocket(port);
    //entrar em looping
    while(true){
      //aguardar uma conexão
      Socket socket = serverSocket.accept();
      //recuperar o stream de entrada
      InputStream input = socket.getInputStream();
      DataInputStream dataInputStream = new DataInputStream(input);
      //recuperar a primeira linha da chamada HTTP
      String line = dataInputStream.readLine();
      //verificar qual a requisição foi chamada
      if (line.contains("POST /op1/update")){//vindo de node3
        //atualizar op1
        GlobalVariable variable = GlobalVariable.instance();
        variable.incrOp1();
        socket.getOutputStream().write(variable.toString().getBytes());
      }
      else if (line.contains("POST /cgi")){//vindo de node1
        //chamar o rmi e atualizar op2
        ServerForwarder forwarder = new ServerForwarder();
        //forwarder.forward(socket, 1099);
        forwarder.forward(dataInputStream, socket.getOutputStream(), 1099);
      }
      else {
        socket.getOutputStream().write("ERRO".getBytes());
      }
      //
      socket.close();
    }
  }

}
