import java.time.Duration;
import java.time.Instant;

public class Main {
    private static int contadorDeMovimentos = 0; // Contador para o número de movimentos

    // Função recursiva para resolver a Torre de Hanói
    public static void torreDeHanoi(int n, char origem, char auxiliar, char destino) {
        if (n == 1) {
            contadorDeMovimentos++;
            return;
        }
        torreDeHanoi(n - 1, origem, destino, auxiliar);
        contadorDeMovimentos++;
        torreDeHanoi(n - 1, auxiliar, origem, destino);
    }

    // Método principal
    public static void main(String[] args) {
        int n =41; // Número de discos
        Instant inicio = Instant.now(); // Hora de início

        torreDeHanoi(n, 'A', 'B', 'C'); // Hastes

        Instant fim = Instant.now(); // Hora de término
        Duration tempoDecorrido = Duration.between(inicio, fim); // Tempo decorrido

        long horas = tempoDecorrido.toHours();
        long minutos = tempoDecorrido.toMinutes() % 60;
        long segundos = tempoDecorrido.getSeconds() % 60;
        long milissegundos = tempoDecorrido.toMillis() % 1000;

        System.out.printf("Total de movimentos: %d\n", contadorDeMovimentos);
        System.out.printf("Tempo decorrido: %02d:%02d:%02d:%03d\n", horas, minutos, segundos, milissegundos);
    }
}
