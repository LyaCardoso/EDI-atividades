package Algo470;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Digite um número: ");
        int num = Integer.parseInt(input);

        Primo p = new Primo();
        int pri = p.primo(num);

        if (pri == 0) {
            JOptionPane.showMessageDialog(null, "É primo: " + num);
        } else {
            JOptionPane.showMessageDialog(null, "Não é primo: " + num);
        }
    }
}