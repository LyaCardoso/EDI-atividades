import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            pessoas.add(new Pessoa("Pessoa " + i, "Telefone " + i, "Endereço " + i, "CPF " + i));
        }

        int indiceSobrevivente = josephus(pessoas);
        System.out.println("A pessoa sobrevivente é: " + pessoas.get(indiceSobrevivente));
    }

    public static int josephus(List<Pessoa> pessoas) {
        Random random = new Random();
        int m = random.nextInt(pessoas.size()) + 1;
        int indice = 0;

        while (pessoas.size() > 1) {
            indice = (indice + m - 1) % pessoas.size();
            pessoas.remove(indice);
        }

        return 0; // O índice da pessoa restante na lista
    }
}
