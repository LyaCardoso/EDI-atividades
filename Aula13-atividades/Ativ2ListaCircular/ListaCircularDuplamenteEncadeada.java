public class ListaCircularDuplamenteEncadeada {
    private Node sentinela;

    public ListaCircularDuplamenteEncadeada() {
        sentinela = new Node(0);
        sentinela.next = sentinela;
        sentinela.prev = sentinela;
    }

    // Método para inserir ordenadamente na lista
    public void inserirOrdenado(int data) {
        Node novoNode = new Node(data);
        Node atual = sentinela.next;

        // Percorre a lista até encontrar a posição correta
        while (atual != sentinela && atual.data < data) {
            atual = atual.next;
        }

        // Insere o novo nó antes do nó atual
        novoNode.next = atual;
        novoNode.prev = atual.prev;
        atual.prev.next = novoNode;
        atual.prev = novoNode;
    }

    // Método para imprimir a lista em ordem crescente
    public void imprimirCrescente() {
        Node atual = sentinela.next;
        while (atual != sentinela) {
            System.out.print(atual.data + " ");
            atual = atual.next;
        }
        System.out.println();
    }

    // Método para imprimir a lista em ordem decrescente
    public void imprimirDecrescente() {
        Node atual = sentinela.prev;
        while (atual != sentinela) {
            System.out.print(atual.data + " ");
            atual = atual.prev;
        }
        System.out.println();
    }

    // Método para verificar se um número é primo
    private boolean ehPrimo(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Método para remover todos os números primos da lista
    public void removerPrimos() {
        Node atual = sentinela.next;
        while (atual != sentinela) {
            if (ehPrimo(atual.data)) {
                atual.prev.next = atual.next;
                atual.next.prev = atual.prev;
            }
            atual = atual.next;
        }
    }
}
