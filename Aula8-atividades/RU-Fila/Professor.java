class Professor {
    private int siape;
    private String nome;
    private String titulacao;

    public Professor(int siape, String nome, String titulacao) {
        this.siape = siape;
        this.nome = nome;
        this.titulacao = titulacao;
    }

    // Getters
    public int getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    // Método para imprimir informações do Professor
    public void imprimirInformacoes() {
        System.out.println("Professor: " + nome + ", SIAPE: " + siape + ", Titulação: " + titulacao);
    }
}