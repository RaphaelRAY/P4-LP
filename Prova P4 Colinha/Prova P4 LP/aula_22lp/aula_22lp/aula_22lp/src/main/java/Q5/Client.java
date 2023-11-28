package Q5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket clientSocket;
    private Scanner scanner;
    private PrintWriter saida;

    public Client() {
        scanner = new Scanner(System.in);
    }

    public void start() throws IOException {
        clientSocket = new Socket(Server.ADRESS, Server.PORT);
        saida = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Cliente" + Server.ADRESS + ":" + Server.PORT + " conectado ao servidor!");
        messageLoop();
    }

    private void messageLoop() throws IOException {
        String msg;
        System.out.println("Aguardando a digitacao de uma mensagem!");
        do {
            System.out.print("Digite uma mensagem (ou <sair> para finalizar): ");
            msg = scanner.nextLine();
            saida.println(msg);
        } while (!msg.equalsIgnoreCase("sair"));
    }

    

    public static void main(String args[]) {
        try {
            Client client = new Client();
            client.start();
        } catch (IOException ex) {
            System.out.println("Erro ao iniciar o cliente:" + ex.getMessage());
        }
        System.out.println("Cliente finalizado!");
    }
}
