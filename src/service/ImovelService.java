package service;

import domain.Apartamento;
import domain.Casa;
import domain.Imovel;
import domain.Proprietario;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ImovelService {

    private final Scanner SCANNER_DE_ENTRADA = new Scanner(System.in);
    List<Imovel> listaDeImoveis = new ArrayList<>();

    public void cadastrarImovel(String endereco, int numero, Proprietario proprietario) throws NoSuchElementException{
        String tipoImovel = selecionarImovel();

        if (tipoImovel.equalsIgnoreCase("CASA")) {
            Imovel casa = new Casa(endereco, numero, proprietario);
            listaDeImoveis.add(casa);
        } else if (tipoImovel.equalsIgnoreCase("APARTAMENTO")) {
            Imovel ap = new Apartamento(endereco, numero, proprietario);
            listaDeImoveis.add(ap);
        } else {
            throw new IllegalArgumentException("Tipo de imóvel" + tipoImovel + " inválido");
        }
    }

    public boolean deletarImovelById(int id) {
        for (Imovel imovel : listaDeImoveis) {
            if (imovel.getId() == id) {
                listaDeImoveis.remove(imovel);
                return true;
            }
        }
        return false;
    }

    public int calcularAluguel(int id, int meses) {
        Imovel imovel = getImovelById(id);
        if (imovel != null) {
            return imovel.calcularAluguel(meses);
        }
        return -1;
    }

    public void alugarImovel(int id) {
        Imovel imovel = getImovelById(id);
        if (imovel == null) {
            System.out.println("Erro: Imóvel com id " + id + " não encontrado");
            return;
        }

        if (imovel.estaAlugado()) {
            System.out.println("Atenção: Imóvel com o id " + id + " já está alugado");
        } else {
            imovel.setAlugado(true);
            System.out.println("Sucesso: Imóvel com o id " + id + " foi alugado com sucesso");
        }
    }

    public void disponibilizarImovel(int id) {
        Imovel imovel = getImovelById(id);

        if (imovel == null) {
            System.out.println("Erro: Imóvel com id " + id + " não encontrado");
            return;
        }

        if (!imovel.estaAlugado()) {
            System.out.println("Atenção: Imóvel com id " + id + " ja está disponível");
        } else {
            imovel.setAlugado(false);
            System.out.println("Sucesso: Imóvel com o id " + id + " foi disponibilizado com sucesso");
        }
    }

    public void mostrarImoveisAlugados() {
        List<Imovel> imoveisAlugados = new ArrayList<>();
        for (Imovel imovel : listaDeImoveis) {
            if (imovel.estaAlugado()) {
                imoveisAlugados.add(imovel);
            }
        }
        if (imoveisAlugados.isEmpty()) {
            System.out.println("Não há nenhum imóvel alugado");
            return;
        }
        imoveisAlugados.forEach(System.out::println);
    }

    public Imovel getImovelById(int id) {
        for (Imovel imovel : listaDeImoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        return null;
    }

    private String selecionarImovel() {
        System.out.println("Informe o tipo de imóvel que deseja criar: (casa / apartamento)");
        return SCANNER_DE_ENTRADA.next().trim();
    }

    public void listarImoveis() {
        for (Imovel imovel : listaDeImoveis) {
            System.out.println(imovel);
            System.out.println(imovel.getId());
        }
    }
}
