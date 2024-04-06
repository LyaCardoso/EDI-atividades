class Aluno {
    private int matricula;
    private String nome;
    private String curso;

    public Aluno(int matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    // Getters
    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    // Método para imprimir informações do Aluno
    public void imprimirInformacoes() {
        System.out.println("Aluno: " + nome + ", Matrícula: " + matricula + ", Curso: " + curso);
    }
}