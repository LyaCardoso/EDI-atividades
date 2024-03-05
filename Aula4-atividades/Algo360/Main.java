import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
      int[] ultDia = new int[12];
      String[] signo = new String[12];
      int data, dia, mes;

      for (int i = 0; i < 12; i++) {
          signo[i] = JOptionPane.showInputDialog("Digite o nome do signo:");
          ultDia[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o último dia do signo " + signo[i] + ":"));
      }

      data = Integer.parseInt(JOptionPane.showInputDialog("Digite a data no formato ddmm ou 9999 para terminar:"));

      while (data != 9999) {
          dia = data / 100;
          mes = data % 100;
          mes--;

          if (dia > ultDia[mes]) {
              mes = (mes + 1) % 12;
          }

          JOptionPane.showMessageDialog(null, "Signo: " + signo[mes]);

          data = Integer.parseInt(JOptionPane.showInputDialog("Digite a data no formato ddmm ou 9999 para terminar:"));
      }

      JOptionPane.showMessageDialog(null, "Fim do programa.");
  }
}