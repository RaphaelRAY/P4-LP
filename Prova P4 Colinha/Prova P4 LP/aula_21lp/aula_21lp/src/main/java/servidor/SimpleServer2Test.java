package servidor;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SimpleServer2Test {
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
                    saida.println("Bom dia! vou retornar a mensagem recebida editada pelo servidor.");
                } else{
                msg = editar_mensagem(msg);
                saida.println("Mensagem editada " + "\"" + msg + "\"" );
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

    private static String editar_mensagem(String msg){
            msg = JOptionPane.showInputDialog("Digite a mensagem que deseja enviar ao cliente sendo a mensagem" + msg + ": ");
            return msg;
    }
}
