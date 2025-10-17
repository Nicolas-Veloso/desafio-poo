package domain;

public class Inquilino extends Pessoa{

    private Imovel imovelAlugado;

    public Inquilino(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    @Override
    public String getTipoPessoa() {
        return "Inquilino";
    }

    public Imovel getImovelAlugado() {
        return imovelAlugado;
    }

    public void setImovelAlugado(Imovel imovelAlugado) {
        this.imovelAlugado = imovelAlugado;
    }
}
