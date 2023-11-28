package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleServerTest {
    public static final String endereco = "127.0.0.1";
    public static final int porta = 3334;
    
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(porta);
            System.out.println("Servidor iniciado na porta " + porta);

            Socket cliente = server.accept();
            System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());

            Scanner entrada = new Scanner(cliente.getInputStream());

            System.out.println("Mensagem do cliente: ");
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
            System.out.println("Servidor finalizado!");
            entrada.close();
            server.close();
        } catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    
}
