package domain;

public abstract class Pessoa {
    private final int ID;

    //Contador para incrementar o ID
    private static int contador;

    protected String nome;
    protected String telefone;
    protected String cpf;

    public Pessoa(String nome, String telefone, String cpf) {
        this.ID = contador;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        contador++;
    }

    public int getId() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "nome='" + nome + '\'' +
                ", ID=" + ID +
                '}';
    }

    public abstract String getTipoPessoa();
}

