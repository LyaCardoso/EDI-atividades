package Algo356;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int[] media = new int[15];
        String[] nomes = new String[15];
        String[] sit = new String[15];
        double[] pr1 = new double[15];
        double[] pr2 = new double[15];

        for (int i = 0; i < 15; i++) {
            nomes[i] = JOptionPane.showInputDialog(null, "Digite o nome do aluno " + (i + 1) + ": ");

            while (nomes[i].length() > 30) {
                JOptionPane.showMessageDialog(null, "Nomes com até 30 caracteres. Digite novamente.");
                nomes[i] = JOptionPane.showInputDialog(null, "Digite o nome do aluno " + (i + 1) + ": ");
            }

            int t = 30 - nomes[i].length();
            for (int c = 1; c <= t; c++) {
                nomes[i] += " ";
            }

            pr1[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota da PR1 do aluno " + (i + 1) + ": "));
            pr2[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a nota da PR2 do aluno " + (i + 1) + ": "));

            media[i] = (int) Math.round((pr1[i] + pr2[i]) / 2.0);

            if (media[i] >= 5) {
                sit[i] = "AP";
            } else {
                sit[i] = "RP";
            }
        }

        StringBuilder output = new StringBuilder("\n\n\t\t\t\tRELACAO FINAL\n");
        for (int i = 0; i < 15; i++) {
            output.append((i + 1)).append("- ").append(nomes[i]).append("\t").append(pr1[i]).append("\t").append(pr2[i]).append("\t").append(media[i]).append("\t").append(sit[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, output.toString());
    }
}