package Q2;
interface Operacao {
    int execute(int a, int b);
}

public class ExemploFuncaoAnonima {
    //exemplo pg 9
    /*public static void main(String[] args) {
        Operacao adicao = new Operacao() {
            @Override
            public int execute(int a, int b) {
                return a + b;
            }
        };
        int resulatado = adicao.execute(5, 3);
        System.out.println(resulatado);
    }*/
    
    //exemplo pg 10
    public static void main(String[] args) {
        Operacao adicao = (a,b) -> a + b ;
        int resulatado = adicao.execute(5, 3);
        System.out.println(resulatado);
    }


}
