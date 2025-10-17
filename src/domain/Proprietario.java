package domain;

public class Proprietario extends Pessoa{

    public Proprietario(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    }

    @Override
    public String getTipoPessoa() {
        return "Proprietario";
    }
}
