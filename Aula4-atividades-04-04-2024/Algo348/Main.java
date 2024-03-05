package Algo348;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aluno[] nomes = new Aluno[5];
        Notas[] pr1 = new Notas[5];
        Notas[] pr2 = new Notas[5];
        Notas[] media = new Notas[5];

        int L;

        for (L = 0; L <= 4; L++) {
            nomes[L] = new Aluno();
            pr1[L] = new Notas();
            pr2[L] = new Notas();
            media[L] = new Notas();

            System.out.print("\nDigite " + (L + 1) + "º nome: ");
            nomes[L].nomes = scanner.nextLine();

            System.out.print("Digite 1ª nota: ");
            pr1[L].pr1 = scanner.nextDouble();

            System.out.print("Digite 2ª nota: ");
            pr2[L].pr2 = scanner.nextDouble();
            scanner.nextLine();

            media[L].media = (pr1[L].pr1 + pr2[L].pr2) / 2;
        }

        System.out.println("\n\n\n\t\t\t\tRELACAO FINAL");
        for (L = 0; L <= 4; L++) {
            System.out.println("\n " + (L + 1) + " - " + nomes[L].nomes);
            System.out.println(pr1[L].pr1 + "\t" + pr2[L].pr2 + "\t" + media[L].media);
        }

        System.out.println("\n");
        scanner.close();
    }
}
