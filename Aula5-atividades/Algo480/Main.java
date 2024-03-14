public class Main {
    public static void main(String[] args) {
        int n, x;
        Reverso reverso = new Reverso();

        System.out.println("\nDigite numero: ");
        n = Integer.parseInt(System.console().readLine());

        x = reverso.reverso(n);

        System.out.println("\n" + n + " - " + x);

        if (x == n) {
            System.out.println("\nE um numero capicua");
        } else {
            System.out.println("\nNao e um numero capicua");
        }

        System.out.println();
    }
}