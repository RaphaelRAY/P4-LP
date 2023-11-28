package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import servidor.SimpleServerTest;

public class SimpleClientTest {
    private static Socket cliente;
    public static void main(String[] args) {
        try{
            String msg;
            inicaCliente();
            System.out.println("Mensagem para o servidor: ");
            do{
                msg = JOptionPane.showInputDialog("Digite uma mensagem para o servidor ou <sair>: ");
                if(!msg.equalsIgnoreCase("sair")){
                    System.out.println("Enviando mensagem para o servidor: " + msg);
                    enviaMensagem(msg);
                }
            } while(!msg.equalsIgnoreCase("sair"));
            System.out.println("Cliente finalizado!");

        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private static void inicaCliente() throws IOException{
            cliente = new Socket(SimpleServerTest.endereco, SimpleServerTest.porta);
            System.out.println("Cliente conectado ao servidor " + SimpleServerTest.endereco + ":" + SimpleServerTest.porta);
    }

    private static void enviaMensagem(String msg) throws IOException{
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(msg);
    }
}
