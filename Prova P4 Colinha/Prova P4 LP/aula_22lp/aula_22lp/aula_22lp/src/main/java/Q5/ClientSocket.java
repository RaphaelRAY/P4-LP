package Q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;


public class ClientSocket {
    private final Socket socket;
    private final BufferedReader entrada;
    private final PrintWriter saida;

    public ClientSocket(final Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Conexão estabelecida com o cliente " + socket.getRemoteSocketAddress());
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        saida = new PrintWriter(socket.getOutputStream(), true);
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close(){
        try{
            entrada.close();
            saida.close();
            socket.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getMessage() {
        try{
            return entrada.readLine();
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean sendMessage(String msg) {
        saida.println(msg);
        return !saida.checkError();
    }

}
