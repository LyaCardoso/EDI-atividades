import java.util.Scanner;

class Pilha {
    private Node topo;

    private class Node {
        int valor;
        Node proximo;

        Node(int valor) {
            this.valor = valor;
            this.proximo = topo;
        }
    }

    // Método para empilhar (push) um valor
    public void push(int valor) {
        Node novoNode = new Node(valor);
        topo = novoNode;
    }

    // Método para desempilhar (pop) um valor
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha está vazia!");
        }
        int valor = topo.valor;
        topo = topo.proximo;
        return valor;
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == null;
    }

    // Método para contar o número de elementos restantes na pilha
    public int countElements() {
        int count = 0;
        Node atual = topo;
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }
        return count;
    }

    // Método para listar os elementos restantes na pilha
    public void listElements() {
        Node atual = topo;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilhaPar = new Pilha();
        Pilha pilhaImpar = new Pilha();

        int valor;
        do {
            System.out.print("Digite um valor inteiro (-127 a 128) ou 0 para finalizar: ");
            valor = scanner.nextInt();

            if (valor == 0) break;

            if (valor % 2 == 0) {
                pilhaPar.push(valor);
            } else {
                pilhaImpar.push(valor);
            }
        } while (valor != 0);

        boolean turnoImpar = true;
        while (!pilhaImpar.isEmpty() && !pilhaPar.isEmpty()) {
            if (turnoImpar) {
                System.out.println("Desempilhando da pilha Ímpar: " + pilhaImpar.pop());
            } else {
                System.out.println("Desempilhando da pilha Par: " + pilhaPar.pop());
            }
            turnoImpar = !turnoImpar;
        }

        if (!pilhaImpar.isEmpty()) {
            System.out.println("\nPilha Ímpar ainda possui elementos.");
            System.out.println("Número de elementos: " + pilhaImpar.countElements());
            System.out.print("Elementos restantes: ");
            pilhaImpar.listElements();
        } else if (!pilhaPar.isEmpty()) {
            System.out.println("\nPilha Par ainda possui elementos.");
            System.out.println("Número de elementos: " + pilhaPar.countElements());
            System.out.print("Elementos restantes: ");
            pilhaPar.listElements();
        } else {
            System.out.println("\nAmbas as pilhas estão vazias.");
        }

        scanner.close();
    }
}
