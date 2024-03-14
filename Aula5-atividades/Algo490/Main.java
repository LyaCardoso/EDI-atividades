import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String[] palavras = new String[10];

        // Recebendo as palavras do usuário
        for (int i = 0; i < 10; i++) {
            palavras[i] = JOptionPane.showInputDialog("Digite a palavra em letras minúsculas " + (i+1) + ":");
        }

        // Substituindo os caracteres e imprimindo o resultado
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            String palavraAlterada = Caractere(palavras[i], 'a');
            resultado.append((i+1) + " - " + palavraAlterada).append("\n");
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    public static String Caractere(String palavra, char caractere) {
        char[] vetor = palavra.toCharArray();

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == caractere) {
                vetor[i] = '*';
            }
        }

        return new String(vetor);
    }
}