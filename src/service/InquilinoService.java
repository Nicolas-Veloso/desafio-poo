package service;

import domain.Inquilino;

import java.util.ArrayList;
import java.util.List;

public class InquilinoService {

    List<Inquilino> listaDeInquilinos = new ArrayList<>();

    public void cadastrarInquilino(String nome, String telefone, String cpf) {
        Inquilino newInquilino = new Inquilino(nome, telefone, cpf);
        listaDeInquilinos.add(newInquilino);
    }

    public Inquilino getInquilinoById(int id) {
        for (Inquilino inquilino : listaDeInquilinos) {
            if (inquilino.getId() == id) {
                return inquilino;
            }
        }
        return null;
    }
}
