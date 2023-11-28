package Q3;

import java.util.Random;

public class MultipleThreadExample extends Thread {
    private static final long TOTAL_NUMEROS = 1_000_000_000L;
    private final long numerosAGerar;

    public MultipleThreadExample(long numerosAGerar){
        this.numerosAGerar = numerosAGerar;
        System.out.printf("----> Thread criada (%s)!\n", getName());
    }

    public static void main(String args[]) {
        final int threads = args.length == 0 ? 1 : Integer.valueOf(args[0]);
        final long numeroPorThread = (TOTAL_NUMEROS / threads);
        System.out.printf("\nMissao: Gerar um bilhao de numeros aleatorios usando Threads!\n");
        System.out.printf("-> Thread iniciada (%s)...\n", Thread.currentThread().getName());
        System.out.printf("-> Criando +%d Thread(s) para isso!\n", threads);
        // Le o tempo do sistema no inicio do processamento
        final double startTime = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            new MultipleThreadExample(numeroPorThread).start(); // Threads em paralelo!
        }
        // Tempo de processamento em segundos
        final double totalSecs = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.printf("-> Threads finalizada (%s) em %.2fs!\n", Thread.currentThread().getName(), totalSecs);
    }

    @Override
    public void run() {
        System.out.printf("----> Iniciando Thread (%s)...\n", Thread.currentThread().getName());
        final double startTime = System.currentTimeMillis();
        // Sorteia um numero (randomico)
        Random rand = new Random();
        // Eleva a 10a potencia cada numero para o processamento mais complexo
        for (int i = 0; i < numerosAGerar; i++) {
            Math.pow(rand.nextDouble(), 10);
        }
        final double totalSecs = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.printf("----> Encerrando Thread (%s)!\n", Thread.currentThread().getName());
        System.out.printf("----> Missao da Thread (%s) cumprida em %.2f!\n\n", Thread.currentThread().getName(),
                totalSecs);
    }
}
