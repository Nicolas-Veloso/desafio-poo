package domain;

public abstract class Imovel {

    private final int ID;

    //Contador para incrementar o ID
    private static int contador;

    protected String endereco;
    protected int numero;
    protected boolean alugado;
    private Proprietario proprietario;

    private final double valorBaseAluguel = 100;

    public Imovel(String endereco, int numero, Proprietario proprietario) {
        this.ID = contador;
        this.endereco = endereco;
        this.numero = numero;
        this.proprietario = proprietario;
        this.alugado = false;
        contador++;
    }

    public int getId() {
        return this.ID;
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

    public abstract double calcularCustosAdicionais();

    public double calcularAluguel(int meses) {
        double custoMensal = this.valorBaseAluguel + calcularCustosAdicionais();
        return custoMensal * meses;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "ID=" + ID +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", alugado=" + alugado +
                ", proprietario=" + proprietario +
                '}';
    }
}
