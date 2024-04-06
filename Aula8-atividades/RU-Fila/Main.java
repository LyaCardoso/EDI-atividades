import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Object> filaRefeitorio = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione o tipo de frequentador a ser adicionado:");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Técnico ");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 0) {
                break;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite a matrícula do aluno:");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite o curso do aluno:");
                    String curso = scanner.nextLine();
                    filaRefeitorio.add(new Aluno(matricula, nomeAluno, curso));
                    break;
                case 2:
                    System.out.println("Digite o SIAPE do professor:");
                    int siape = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do professor:");
                    String nomeProfessor = scanner.nextLine();
                    System.out.println("Digite a titulação do professor:");
                    String titulacao = scanner.nextLine();
                    filaRefeitorio.add(new Professor(siape, nomeProfessor, titulacao));
                    break;
                case 3:
                    System.out.println("Digite o SIAPE do técnico :");
                    int siapeTecnico = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do técnico :");
                    String nomeTecnico = scanner.nextLine();
                    filaRefeitorio.add(new Tecnico(siapeTecnico, nomeTecnico));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        // Fechando o scanner
        scanner.close();

        // Simulando o acesso ao refeitório (removendo e imprimindo os frequentadores)
        System.out.println("\nFila de acesso ao refeitório:");
        while (!filaRefeitorio.isEmpty()) {
            Object frequentador = filaRefeitorio.poll();

            if (frequentador instanceof Aluno) {
                ((Aluno) frequentador).imprimirInformacoes();
            } else if (frequentador instanceof Professor) {
                ((Professor) frequentador).imprimirInformacoes();
            } else if (frequentador instanceof Tecnico) {
                ((Tecnico) frequentador).imprimirInformacoes();
            }
        }
    }
}
