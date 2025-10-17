package domain;

public abstract class Imovel {

    private final int id;
    private static int CONTADOR;
    protected String endereco;
    protected int numero;
    protected boolean alugado;
    private Proprietario proprietario;

    public Imovel(String endereco, int numero, Proprietario proprietario) {
        this.id = CONTADOR;
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.alugado = false;
        CONTADOR++;
    }

    public int getId() {
        return this.id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public boolean estaAlugado() {
        return this.alugado;
    }

    public String contatoProprietario() {
        return "Contato do proprietario: " +
                "\nNome: " + this.proprietario.getNome() +
                "\nTelefone: " + this.proprietario.getTelefone();
    }

    public Integer calcularAluguel(int meses) {
        return 200 * meses;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", alugado=" + alugado +
                ", proprietario=" + proprietario +
                '}';
    }
}
