import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fila = new ArrayList<>();

        fila.add("Elemento1");
        fila.add("Elemento2");
        fila.add("Elemento3");
        System.out.println("Fila após adições: " + fila);

        fila.remove(0);
        System.out.println("Fila após remoção: " + fila);

        fila.add("Elemento4");
        System.out.println("Fila após nova adição: " + fila);

        String cabeca = fila.get(0);
        System.out.println("Primeiro elemento da fila (peek): " + cabeca);
        System.out.println("Fila após operação de peek: " + fila);

        System.out.println("Iterando sobre a fila:");
        for(String elemento : fila) {
            System.out.println(elemento);
        }
    }
}
