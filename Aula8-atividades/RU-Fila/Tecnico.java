class Tecnico {
    private int siape;
    private String nome;

    public Tecnico(int siape, String nome) {
        this.siape = siape;
        this.nome = nome;
    }

    // Getters
    public int getSiape() {
        return siape;
    }

    public String getNome() {
        return nome;
    }

    // Método para imprimir informações do Técnico 
    public void imprimirInformacoes() {
        System.out.println("Técnico Administrativo: " + nome + ", SIAPE: " + siape);
    }
}