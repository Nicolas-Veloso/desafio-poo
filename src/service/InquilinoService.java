package service;

import domain.Imovel;
import domain.Inquilino;
import domain.Proprietario;

import java.util.ArrayList;
import java.util.List;

public class InquilinoService {
    ImovelService imovelService = new ImovelService();

    List<Inquilino> listaDeInquilinos = new ArrayList<>();

//    public void cadastrarEAlugar(String nome, String telefone, String cpf, int idImovelAlugado) {
//        Imovel imovelParaAlugar = imovelService.getImovelById(idImovelAlugado);
//
//        if (imovelParaAlugar == null) {
//            System.out.println("Erro: Imóvel com ID " + idImovelAlugado + " não foi encontrado");
//            return;
//        }
//        if (imovelParaAlugar.estaAlugado()) {
//            System.out.println("Atenção: O imovel com ID " + idImovelAlugado + " ja está alugado");
//            return;
//        }
//
//        Proprietario donoDoImovel = imovelParaAlugar.getProprietario();
//
//        if (donoDoImovel == null || donoDoImovel.getCpf().equals(cpf)) {
//            System.out.println("Proprietario não pode ser inquilino do próprio imóvel");
//            return;
//        }
//
//        Inquilino newInquilino = new Inquilino(nome, telefone, cpf, imovelParaAlugar);
//
//        newInquilino.getImovelAlugado().setAlugado(true);
//
//        System.out.println("Sucesso: Imóvel alugado com sucesso");
//
//        listaDeInquilinos.add(newInquilino);
//    }

    public Inquilino getInquilinoById(int id) {
        for (Inquilino inquilino : listaDeInquilinos) {
            if (inquilino.getId() == id) {
                return inquilino;
            }
        }
        return null;
    }
}
