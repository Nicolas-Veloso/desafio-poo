package service;

import domain.Proprietario;

public class ProprietarioService {

    public static Proprietario cadastrarProprietario(String nome, String telefone, String cpf) {
        return new Proprietario(nome, telefone, cpf);
    }

    public static void alugarImovel() {
        
    }
}
