import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        ListaCircularDuplamenteEncadeada lista = new ListaCircularDuplamenteEncadeada();
        Random random = new Random();

        // Geração de 1000 números aleatórios e armazenamento no vetor
        for (int i = 0; i < 1000; i++) {
            vetor[i] = random.nextInt(19999) - 9999;
            System.out.println("Vetor[" + i + "] => " + vetor[i]);
            lista.inserirOrdenado(vetor[i]);
        }

        // Impressão da lista em ordem crescente
        System.out.println("\nLista em ordem crescente:");
        lista.imprimirCrescente();

        // Impressão da lista em ordem decrescente
        System.out.println("\nLista em ordem decrescente:");
        lista.imprimirDecrescente();

        // Remoção de números primos
        lista.removerPrimos();
        System.out.println("\nLista após remoção dos números primos (em ordem crescente):");
        lista.imprimirCrescente();
    }
}
