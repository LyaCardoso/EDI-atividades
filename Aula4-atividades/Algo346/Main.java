import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Frase frase = new Frase();
        Opcao op = new Opcao();
        do {
            System.out.println("\nMENU");
            System.out.println("1 - Imprime o comprimento da frase");
            System.out.println("2 - Imprime os dois primeiros e os dois últimos caracteres da frase");
            System.out.println("3 - Imprime a frase espelhada");
            System.out.println("4 - Termina o algoritmo");
            System.out.print("OPCAO: ");

            op.op = scanner.nextInt();
            scanner.nextLine();

            switch (op.op) {
                case 1:
                    System.out.print("Digite uma frase: ");
                    frase.frase = scanner.nextLine();
                    System.out.println("Número de caracteres da frase: " + frase.frase.length());
                    break;
                case 2:
                    System.out.print("Digite uma frase: ");
                    frase.frase = scanner.nextLine();
                    System.out.println("Os dois primeiros caracteres: " + frase.frase.substring(0, 2));
                    int length = frase.frase.length();
                    System.out.println("Os dois últimos caracteres: " + frase.frase.substring(length - 2));
                    break;
                case 3:
                    System.out.print("Digite uma frase: ");
                    frase.frase = scanner.nextLine();
                    for (int x = frase.frase.length() - 1; x >= 0; x--) {
                        System.out.print(frase.frase.charAt(x));
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Fim do algoritmo");
                    break;
                default:
                    System.out.println("Opção não disponível");
            }
        } while (op.op != 4);

        System.out.println("\n\n");
        scanner.close();
    }
}