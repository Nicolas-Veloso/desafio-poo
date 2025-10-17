package domain;

public abstract class Imovel {

    protected String endereco;
    protected int numero;
    protected boolean alugado;
    private Proprietario proprietario;

    public Imovel(String endereco, int numero, boolean alugado, Proprietario proprietario) {
        this.endereco = endereco;
        this.numero = numero;
        this.alugado = alugado;
        this.proprietario = proprietario;
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

    public boolean isAlugado() {
        return this.alugado;
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
        return this.isAlugado();
    }

    public String contatoProprietario() {
        return "Contato do proprietario: " +
                "\nNome: " + this.proprietario.getNome() +
                "\nTelefone: " + this.proprietario.getTelefone();
    }

    public Integer calcularAluguel(int periodoDeTempo) {
        return 100 * periodoDeTempo;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", alugado=" + alugado +
                ", proprietario=" + proprietario +
                '}';
    }
}
