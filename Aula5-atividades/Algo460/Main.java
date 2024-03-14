import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int a;
        for (int c = 0; c < 3; c++) {
            String input = JOptionPane.showInputDialog(null, "Digite numero:");
            a = Integer.parseInt(input);
            JOptionPane.showMessageDialog(null, "dobro: " + dob(a));
        }
        JOptionPane.showMessageDialog(null, "");
    }

    public static int dob(int x) {
        return x * 2;
    }
}