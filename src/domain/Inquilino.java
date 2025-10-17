package domain;

public class Inquilino extends Pessoa{

    public Inquilino(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    @Override
    public String getTipoPessoa() {
        return "Inquilino";
    }
}
