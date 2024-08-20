import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChecarParenteses checker = new ChecarParenteses();

        System.out.print("Digite a expressão: ");
        String expression = scanner.nextLine();

        if (checker.isBalanced(expression)) {
            System.out.println("A expressão está correta.");
        } else {
            System.out.println("A expressão está incorreta.");
        }

        scanner.close();
    }
}