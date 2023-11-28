package Q5;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static final String ADRESS = "127.0.0.1";
    public static final int PORT = 4000;
    private ServerSocket serverSoket;

    public void start() throws IOException { 
        serverSoket = new ServerSocket(PORT);
        System.out.println("Server started");
        clienteConnectionLoop();
    }

    private void clienteConnectionLoop() throws IOException {
        System.out.println("Waiting for connection...");
        do{
            ClientSocket client = new ClientSocket(serverSoket.accept());
            new Thread (() -> clientMessageLoop(client)).start();
        }while(true);
    }

    private void clientMessageLoop(ClientSocket client) {
        String msg;
        try{
            while((msg = client.getMessage()) != null && !msg.equals("sair")){
                System.out.println("Message received: " + msg + "from " + client.getRemoteSocketAddress());
            }
        } finally{
            client.close();
        }
    }

    public static void main(String[] args){
        System.out.println("Server starting...");
        try{
            new Server().start();
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Server finished");
    }
}
