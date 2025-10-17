package domain;

public class Apartamento extends Imovel {

    public Apartamento(String endereco, int numero, boolean alugado, Proprietario proprietario) {
        super(endereco, numero, alugado, proprietario);
    }

    @Override
    public boolean estaAlugado() {
        if (this.alugado) {
            System.out.printf("\nO apartamento de número %d está alugado", this.numero);
            return true;
        }
        System.out.printf("\nO apartamento de número %d está disponível", this.numero);
        return false;
    }
}
