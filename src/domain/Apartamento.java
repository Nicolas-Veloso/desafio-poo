package domain;

public class Apartamento extends Imovel {

    private final double VALOR_CONDOMINIO = 300;

    public Apartamento(String endereco, int numero, Proprietario proprietario) {
        super(endereco, numero, proprietario);
    }

    @Override
    public boolean estaAlugado() {
        if (this.alugado) {
            System.out.println("O apartamento de número " + this.numero + " está alugado");
            return true;
        }
        System.out.println("O apartamento de número " + this.numero + " está disponivel");
        return false;
    }

    @Override
    public double calcularCustosAdicionais() {
        return VALOR_CONDOMINIO;
    }
}
