package domain;

public class Apartamento extends Imovel {

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
}
