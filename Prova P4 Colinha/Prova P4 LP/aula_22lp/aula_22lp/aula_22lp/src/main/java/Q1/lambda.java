package Q1;

interface Operation {
    int executar(int a, int b);
}

public class lambda {
    /*
     * Usando uma expressão lambda para criar uma função que adiciona números
     * inteiros
     */
    public static void main(String[] args) {
        Operation soma = (a, b) -> a + b;
        int resultado = soma.executar(5, 3); // resultado é 8
        System.out.println(resultado);
    }

    
    // Você também pode especificar os tipos de parâmetros se desejar
   /* 
    Comparador<String> comparador = (String s1, String s2) -> s1.compareTo(s2);
    // resultado é um valor que indica a ordem lexicográfica
    int resultado = comparador.compare("maçã", "banana"); 
    /* 
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    */
}
