import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static String inverterPalavras(String texto) {
        String[] palavras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            Stack<Character> pilha = new Stack<>();
            for (char c : palavra.toCharArray()) {
                pilha.push(c);
            }
            while (!pilha.isEmpty()) {
                resultado.append(pilha.pop());
            }
            resultado.append(" ");
        }

        return resultado.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o texto: ");
        String texto = scanner.nextLine();
        scanner.close();

        String textoInvertido = inverterPalavras(texto);
        System.out.println("Texto invertido: " + textoInvertido);
    }
}
