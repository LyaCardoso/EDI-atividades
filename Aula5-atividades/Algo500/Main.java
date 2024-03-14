import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vetorA = new int[5];
        int[] vetorB = new int[5];
        boolean dadosAInseridos = false;
        boolean dadosBInseridos = false;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("VETORES");
            System.out.println("1. Dados do VETOR A");
            System.out.println("2. Dados do VETOR B");
            System.out.println("3. Imprime VETORES");
            System.out.println("4. Soma VETORES");
            System.out.println("5. Subtrai VETORES");
            System.out.println("6. Sai do programa");
            System.out.print("OPÇÃO: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    dadosAInseridos = true;
                    inserirDados("VETOR A", vetorA, scanner);
                    break;
                case 2:
                    dadosBInseridos = true;
                    inserirDados("VETOR B", vetorB, scanner);
                    break;
                case 3:
                    if (!dadosAInseridos || !dadosBInseridos) {
                        System.out.println("Escolha primeiro opções 1 e 2.");
                        break;
                    }
                    imprimeVetores("VETOR A", vetorA);
                    imprimeVetores("VETOR B", vetorB);
                    break;
                case 4:
                    if (!dadosAInseridos || !dadosBInseridos) {
                        System.out.println("Escolha primeiro opções 1 e 2.");
                        break;
                    }
                    imprimeSomaSubtracao("Soma", vetorA, vetorB, '+');
                    break;
                case 5:
                    if (!dadosAInseridos || !dadosBInseridos) {
                        System.out.println("Escolha primeiro opções 1 e 2.");
                        break;
                    }
                    imprimeSomaSubtracao("Diferença", vetorA, vetorB, '-');
                    break;
                case 6:
                    System.out.println("Saindo do Algoritmo");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void inserirDados(String nomeVetor, int[] vetor, Scanner scanner) {
        System.out.println("Entrada do " + nomeVetor);
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite número " + (i + 1) + ": ");
            vetor[i] = scanner.nextInt();
        }
    }

    public static void imprimeVetores(String nomeVetor, int[] vetor) {
        System.out.println(nomeVetor);
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void imprimeSomaSubtracao(String operacao, int[] vetorA, int[] vetorB, char operador) {
        System.out.println(operacao);
        for (int i = 0; i < vetorA.length; i++) {
            if (operador == '+') {
                System.out.println(vetorA[i] + vetorB[i]);
            } else if (operador == '-') {
                System.out.println(vetorA[i] - vetorB[i]);
            }
        }
    }
}