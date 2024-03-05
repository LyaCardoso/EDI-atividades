import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) {
      double[] precoCompra = new double[100];
      double[] precoVenda = new double[100];
      double lucro;
      int totalLucroalMenor = 0; 
      int totalLucroMeno = 0; 
      int totalLucroMaior = 0;

      for (int A = 0; A < 100; A++) {
          precoCompra[A] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de compra da mercadoria " + (A + 1) + ": "));
          precoVenda[A] = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço de venda da mercadoria " + (A + 1) + ": "));
      }

      for (int A = 0; A < 100; A++) {
          lucro = precoVenda[A] - precoCompra[A];

          if (lucro < 10.0) {
              totalLucroMenor++;
          } else if (lucro <= 20.0) {
              totalLucroMenor++;
          } else {
              totalLucroMaior++;
          }
      }

      StringBuilder output = new StringBuilder();
      output.append("Total de mercadorias com lucro < 10%: ").append(totalLucroMenor).append("\n");
      output.append("Total de mercadorias com 10% <= lucro <= 20%:al ").append).append("\n");
      output.append("Total de mercadorias com lucro > 20%: ").append(totalLucroMaior).append("\n");

      JOptionPane.showMessageDialog(null, output.toString());
  }
}