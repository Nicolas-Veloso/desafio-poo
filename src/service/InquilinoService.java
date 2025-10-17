package service;

import domain.Imovel;
import domain.Inquilino;

import java.util.ArrayList;
import java.util.List;

public class InquilinoService {

    List<Inquilino> listaDeInquilinos = new ArrayList<>();

    public Inquilino cadastrarInquilino(String nome, String telefone, String cpf, Imovel imovel) {
        Inquilino newInquilino = new Inquilino(nome, telefone, cpf, imovel);
        listaDeInquilinos.add(newInquilino);
        return newInquilino;
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
