package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import servidor.SimpleServerTest;

public class SimpleClientTest {
    private Socket cliente;

    public Socket getCliente() {
        return cliente;
    }

    public SimpleClientTest() throws IOException {
        inicaCliente();
    }

    private void inicaCliente() throws IOException{
        cliente = new Socket(SimpleServerTest.endereco, SimpleServerTest.porta);
    }

    public void enviaMensagem(String msg) throws IOException{
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        saida.println(msg);
    }
    
    public void Terminar_conecao() throws IOException{
        cliente.close();
    }
    
}
