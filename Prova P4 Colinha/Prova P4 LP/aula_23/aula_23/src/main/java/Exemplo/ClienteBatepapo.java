package Exemplo;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteBatepapo implements Runnable {
    private SocketCliente clientSocket;
    private Scanner scanner;
    
    public ClienteBatepapo() {
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException{
        try {
            clientSocket = new SocketCliente(new Socket(ServidorBatePapo.ADDRESS, ServidorBatePapo.PORT));
            new Thread(this).start();
            messageLoop();
        } finally{
            clientSocket.close();
        }
    }
    
    @Override
    public void run(){
        String msg;
        while((msg = clientSocket.getMessage()) != null){
            System.out.printf("\n-> %s\n",msg);
            System.out.print("Digite uma mensagem(ou <sair> para finalizar): ");
        }
    }

    private void messageLoop() throws IOException{
        String msg;
        System.out.print("Digite uma mensagem(ou <sair> para finalizar): ");
        do{
            System.out.print("<-");
            msg = scanner.nextLine();
            clientSocket.sendMsg(msg);
        } while(!msg.equalsIgnoreCase("sair"));
    }

    public static void main(String[] args) throws IOException{
        System.out.println("*v*v*v* CONSOLE DO CLIENTE *v*v*v*");
        ClienteBatepapo client = new ClienteBatepapo();
        client.start();
    }


}
