import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Pessoa {
    int id;
    String sexo;
    int idade;
    boolean gestante;
    boolean lactante;
    boolean necessidadeEspecial;
    int prioridade;

    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
        definirPrioridade();
    }

    private void definirPrioridade() {
        if (gestante || lactante) {
            this.prioridade = 3;
        } else if (necessidadeEspecial) {
            this.prioridade = 2;
        } else if (idade >= 60) {
            this.prioridade = 1;
        } else {
            this.prioridade = 0;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Prioridade: " + prioridade + ", Idade: " + idade + ", Gestante: " + gestante + ", Lactante: " + lactante + ", Necessidade Especial: " + necessidadeEspecial;
    }
}

class FilaAtendimento {
    private ArrayDeque<Pessoa> fila;
    private int capacidade;

    public FilaAtendimento(int capacidade) {
        this.fila = new ArrayDeque<>(capacidade);
        this.capacidade = capacidade;
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (fila.size() < capacidade) {
            fila.addLast(pessoa);
        } else {
            System.out.println("Fila cheia! Não é possível adicionar mais pessoas.");
        }
    }

    public List<Pessoa> atenderPessoas(int quantidade) {
        List<Pessoa> atendidos = new ArrayList<>();
        for (int i = 0; i < quantidade && !fila.isEmpty(); i++) {
            atendidos.add(fila.pollFirst());
        }
        return atendidos;
    }

    public void mostrarFila() {
        for (Pessoa p : fila) {
            System.out.println(p);
        }
    }

    public int tamanho() {
        return fila.size();
    }
}

public class Main {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento(100);
        Random random = new Random();
        int id = 1;

        // Criar 100 pessoas aleatórias
        for (int i = 0; i < 100; i++) {
            String sexo = random.nextBoolean() ? "M" : "F";
            int idade = random.nextInt(80);  // Gera idade entre 0 e 79
            boolean gestante = sexo.equals("F") && random.nextInt(100) < 10;  // 10% de chance
            boolean lactante = sexo.equals("F") && random.nextInt(100) < 10;  // 10% de chance
            boolean necessidadeEspecial = random.nextInt(100) < 10;  // 10% de chance
            Pessoa pessoa = new Pessoa(id++, sexo, idade, gestante, lactante, necessidadeEspecial);
            fila.adicionarPessoa(pessoa);
        }

        int[] grupos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  // Quantidade de pessoas atendidas por grupo
        List<Pessoa> atendidos = new ArrayList<>();

        // Simulação do atendimento
        for (int grupo : grupos) {
            List<Pessoa> atendidosGrupo = fila.atenderPessoas(grupo);
            atendidos.addAll(atendidosGrupo);
        }

        // Mostrar pessoas atendidas
        System.out.println("Pessoas atendidas:");
        for (Pessoa p : atendidos) {
            System.out.println(p);
        }

        // Mostrar pessoas não atendidas
        System.out.println("\nPessoas não atendidas:");
        fila.mostrarFila();
    }
}
