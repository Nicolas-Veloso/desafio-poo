package service;

import domain.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class ProprietarioService {

    List<Proprietario> listaDeProprietarios = new ArrayList<>();

    public void cadastrarProprietario(String nome, String telefone, String cpf) {
        Proprietario newProprietario = new Proprietario(nome, telefone, cpf);
        listaDeProprietarios.add(newProprietario);
    }

    public Proprietario getProprietarioById(int id) {
        for (Proprietario proprietario : listaDeProprietarios) {
            if (proprietario.getId() == id) {
                return proprietario;
            }
        }
        return null;
    }

    public boolean estaVazio() {
        return listaDeProprietarios.isEmpty();
    }

    public void listarProprietarios() {
        listaDeProprietarios.forEach(System.out::println);
    }
}
