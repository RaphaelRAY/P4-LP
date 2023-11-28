package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServerTest {
    public static final String endereco = "127.0.0.1";
    public static final int porta = 3334;
 
    public static void main(String[] args) {
        try{
            String msg;
            ServerSocket server = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta " + porta);

            Socket cliente = server.accept();
            System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());

            PrintStream saida = new PrintStream(cliente.getOutputStream());
            

            Scanner entrada = new Scanner(cliente.getInputStream());

            saida.println("Envie <help> pra saber oque eu faço");

            while(entrada.hasNext()){
                msg = entrada.nextLine();
                if(cliente.isClosed()){
                    System.out.println("Cliente " + cliente.getInetAddress().getHostAddress() + " desconectado!");
                    break;
                } else
                if(msg.equalsIgnoreCase("help")){
                    saida.println("Bom dia! vou retornar a mensagem recebida.");
                } else{
                saida.println("Mensagem recebida " + "\"" + msg + "\"" );
                }
                System.out.println("Mensagem do cliente: " + msg);
            }

            System.out.println("Servidor finalizado!");
            entrada.close();
            server.close();
            
        } catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
