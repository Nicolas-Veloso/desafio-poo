package domain;

public class Casa extends Imovel {

    public Casa(String endereco, int numero, boolean alugado, Proprietario proprietario) {
        super(endereco, numero, alugado, proprietario);
    }

    @Override
    public boolean estaAlugado() {
        if (this.alugado) {
            System.out.println("A casa está alugada");
            return true;
        }
        System.out.println("A casa está disponível");
        return false;
    }
}
