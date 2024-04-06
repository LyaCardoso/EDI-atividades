public class Fila {
    int tamanho;
    int[] elementos;
    int inicio;
    int fim;
    int quantidade;

    // Método para criar uma nova fila
    public void criarFila(int tamanhoMaximo) {
        tamanho = tamanhoMaximo;
        elementos = new int[tamanhoMaximo];
        inicio = 0;
        fim = -1;
        quantidade = 0;
    }

    // Método para destruir a fila
    public void destruirFila() {
        elementos = null;
    }

    // Método para verificar se a fila está cheia
    public boolean filaCheia() {
        return quantidade == tamanho;
    }

    // Método para inserir um elemento na fila
    public void inserirElemento(int elemento) {
        if (filaCheia()) {
            System.out.println("Erro: A fila está cheia.");
            return;
        }
        fim = (fim + 1) % tamanho;
        elementos[fim] = elemento;
        quantidade = quantidade + 1;
    }

    // Método para remover um elemento da fila
    public int removerElemento() {
        int elementoRemovido = elementos[inicio];
        inicio = (inicio + 1) % tamanho;
        quantidade = quantidade - 1;
        return elementoRemovido;
    }

    // Método para localizar um elemento na fila
    public int localizarElemento(int elemento) {
        int posicao = -1;
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == elemento) {
                posicao = i;
                break;
            }
        }
        return posicao;
    }
}