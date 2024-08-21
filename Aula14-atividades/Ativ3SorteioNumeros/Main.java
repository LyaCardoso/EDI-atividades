import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> pilha1 = new Stack<>();
        Stack<Integer> pilha2 = new Stack<>();
        Stack<Integer> pilha3 = new Stack<>();

        // Fase 1: Sorteio de 100 números aleatórios e distribuição nas pilhas
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1; // Sorteio entre 1 e 9
            if (numero >= 1 && numero <= 3) {
                pilha1.push(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.push(numero);
            } else if (numero >= 7 && numero <= 9) {
                pilha3.push(numero);
            }
        }

        // Impressão inicial das pilhas
        System.out.println("Estado inicial das pilhas:");
        imprimirPilhas(pilha1, pilha2, pilha3);

        // Fase 2: Movimentação dos elementos
        for (int i = 0; i < 100; i++) {
            int destino = random.nextInt(3) + 1; // Sorteio entre 1 e 3
            System.out.println("\nSorteio: " + destino);

            if (destino == 1 && !pilha2.isEmpty() && !pilha3.isEmpty()) {
                System.out.println("Empilhando os números " + pilha2.peek() + " e " + pilha3.peek() + " na pilha 1");
                pilha1.push(pilha2.pop());
                pilha1.push(pilha3.pop());
            } else if (destino == 2 && !pilha1.isEmpty() && !pilha3.isEmpty()) {
                System.out.println("Empilhando os números " + pilha1.peek() + " e " + pilha3.peek() + " na pilha 2");
                pilha2.push(pilha1.pop());
                pilha2.push(pilha3.pop());
            } else if (destino == 3 && !pilha1.isEmpty() && !pilha2.isEmpty()) {
                System.out.println("Empilhando os números " + pilha1.peek() + " e " + pilha2.peek() + " na pilha 3");
                pilha3.push(pilha1.pop());
                pilha3.push(pilha2.pop());
            }

            imprimirPilhas(pilha1, pilha2, pilha3);

            if (pilha1.isEmpty() || pilha2.isEmpty() || pilha3.isEmpty()) {
                System.out.println("\nO programa foi encerrado porque a pilha " + (pilha1.isEmpty() ? "1" : pilha2.isEmpty() ? "2" : "3") + " está vazia.");
                break;
            }
        }

        if (!pilha1.isEmpty() && !pilha2.isEmpty() && !pilha3.isEmpty()) {
            System.out.println("\nO programa foi encerrado após atingir o total de 100 movimentos.");
        }
    }

    // Método para imprimir o estado atual das pilhas
    private static void imprimirPilhas(Stack<Integer> pilha1, Stack<Integer> pilha2, Stack<Integer> pilha3) {
        System.out.println("Pilha 1: " + pilha1);
        System.out.println("Pilha 2: " + pilha2);
        System.out.println("Pilha 3: " + pilha3);
    }
}
