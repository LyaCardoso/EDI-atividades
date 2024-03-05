package Algo351;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numero num = new Numero();
        String[] nomes = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("\nNome " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        System.out.print("\nDigite o número da pessoa: ");
        num.num = scanner.nextInt();

        while (num.num < 1 || num.num > 5) {
            System.out.println("\nNúmero fora do intervalo. Digite novamente: ");
            num.num = scanner.nextInt();
        }
        System.out.println("\n" + nomes[num.num - 1]);
    }
}