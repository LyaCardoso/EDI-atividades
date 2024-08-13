import java.util.Scanner;

class No {
    String valor;
    No anterior;
    No proximo;

    No(String valor) {
        this.valor = valor;
        this.anterior = null;
        this.proximo = null;
    }
}

class ListaDuplamenteEncadeada {
    private No inicio;
    private No fim;
    private int tamanho;

    ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    void inserir(String valor) {
        No novoNo = new No(valor);
        if (this.inicio == null) {
            this.inicio = this.fim = novoNo;
        } else {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        tamanho++;
    }

    void inserirNoInicio(String valor) {
        No novoNo = new No(valor);
        if (this.inicio == null) {
            this.inicio = this.fim = novoNo;
        } else {
            novoNo.proximo = this.inicio;
            this.inicio.anterior = novoNo;
            this.inicio = novoNo;
        }
        tamanho++;
    }

    void inserirNaPosicao(int posicao, String valor) {
        if (posicao <= 0) {
            inserirNoInicio(valor);
            return;
        } else if (posicao >= tamanho) {
            inserir(valor);
            return;
        }

        No novoNo = new No(valor);
        No atual = getNoNaPosicao(posicao - 1);

        novoNo.proximo = atual.proximo;
        novoNo.anterior = atual;
        atual.proximo.anterior = novoNo;
        atual.proximo = novoNo;
        tamanho++;
    }

    void removerDoInicio() {
        if (this.inicio != null) {
            this.inicio = this.inicio.proximo;
            if (this.inicio != null) {
                this.inicio.anterior = null;
            } else {
                this.fim = null;
            }
            tamanho--;
        }
    }

    void removerDoFim() {
        if (this.fim != null) {
            this.fim = this.fim.anterior;
            if (this.fim != null) {
                this.fim.proximo = null;
            } else {
                this.inicio = null;
            }
            tamanho--;
        }
    }

    void removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho)
            return;
        if (posicao == 0) {
            removerDoInicio();
            return;
        } else if (posicao == tamanho - 1) {
            removerDoFim();
            return;
        }

        No atual = getNoNaPosicao(posicao);

        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;

        tamanho--;
    }

    boolean contem(String valor) {
        No atual = this.inicio;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    int tamanho() {
        return this.tamanho;
    }

    void esvaziar() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    void exibir() {
        No atual = this.inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    private No getNoNaPosicao(int posicao) {
        No atual = this.inicio;
        for (int i = 0; i < posicao && atual != null; i++) {
            atual = atual.proximo;
        }
        return atual;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1) Adicionar personagem");
            System.out.println("2) Adicionar personagem em uma posição específica");
            System.out.println("3) Adicionar personagem no início da lista");
            System.out.println("4) Imprimir lista");
            System.out.println("5) Esvaziar lista");
            System.out.println("6) Imprimir tamanho da lista");
            System.out.println("7) Verificar personagem na lista");
            System.out.println("8) Remover personagem do início da lista");
            System.out.println("9) Remover personagem do fim da lista");
            System.out.println("10) Remover personagem em uma posição específica");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do personagem: ");
                    String nome = scanner.nextLine();
                    lista.inserir(nome);
                    break;
                case 2:
                    System.out.print("Digite a posição: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o nome do personagem: ");
                    nome = scanner.nextLine();
                    lista.inserirNaPosicao(posicao, nome);
                    break;
                case 3:
                    System.out.print("Digite o nome do personagem: ");
                    nome = scanner.nextLine();
                    lista.inserirNoInicio(nome);
                    break;
                case 4:
                    System.out.println("Lista de personagens:");
                    lista.exibir();
                    break;
                case 5:
                    lista.esvaziar();
                    System.out.println("Lista esvaziada.");
                    break;
                case 6:
                    System.out.println("Tamanho da lista: " + lista.tamanho());
                    break;
                case 7:
                    System.out.print("Digite o nome do personagem a verificar: ");
                    nome = scanner.nextLine();
                    if (lista.contem(nome)) {
                        System.out.println(nome + " está na lista.");
                    } else {
                        System.out.println(nome + " não está na lista.");
                    }
                    break;
                case 8:
                    lista.removerDoInicio();
                    System.out.println("Personagem removido do início da lista.");
                    break;
                case 9:
                    lista.removerDoFim();
                    System.out.println("Personagem removido do fim da lista.");
                    break;
                case 10:
                    System.out.print("Digite a posição do personagem a remover: ");
                    posicao = scanner.nextInt();
                    lista.removerNaPosicao(posicao);
                    System.out.println("Personagem removido da posição " + posicao + ".");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}