package service;

import domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ImovelService {

    private final Scanner SCANNER_DE_ENTRADA = new Scanner(System.in);
    List<Imovel> listaDeImoveis = new ArrayList<>();
    InquilinoService inquilinoService = new InquilinoService();

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

    public double calcularAluguel(int id, int meses) {
        Imovel imovel = getImovelById(id);

        if (imovel == null) {
            throw new IllegalArgumentException("Erro: Imóvel com o ID " + id + " não encontrado");
        }
        if (meses <= 0) {
            throw new IllegalArgumentException("O período de meses deve ser um número inteiro maior que 0");
        }
        double precoTotal = imovel.calcularAluguel(meses);
        if (meses >= 12 && meses < 24) {
            System.out.println("O periodo de " + meses + " meses disponibiliza um desconto de 10%");
            return precoTotal -= precoTotal * 0.1;
        } else if (meses >= 24 && meses < 36) {
            System.out.println("O periodo de " + meses + " meses disponibiliza um desconto de 15%");
            return precoTotal -= precoTotal * 0.15;
        } else if (meses >= 36) {
            System.out.println("O periodo de " + meses + " meses disponibiliza um desconto de 20%");
            return precoTotal -= precoTotal * 0.2;
        } else {
            return precoTotal;
        }
    }

    public void realizarAluguel(String nome, String telefone, String cpf, int idImovel) {

        Imovel imovel = getImovelById(idImovel);

        if (imovel == null) {
            System.out.println("Erro: Imóvel com ID " + idImovel + " não encontrado.");
            return;
        }

        if (imovel.estaAlugado()) {
            System.out.println("Atenção: Imóvel com ID " + idImovel + " já está alugado");
            return;
        }

        Proprietario donoDoImovel = imovel.getProprietario();
        if (donoDoImovel != null && donoDoImovel.getCpf().equals(cpf)) {
            System.out.println("Erro: Proprietário não pode ser Inquilino do próprio imóvel.");
            return;
        }

        Inquilino novoInquilino = inquilinoService.cadastrarInquilino(nome, telefone, cpf, imovel);

        if (novoInquilino == null) {
            System.out.println("Erro ao criar Inquilino.");
            return;
        }

        imovel.setAlugado(true);

        System.out.println("Sucesso: Imóvel alugado com sucesso e inquilino cadastrado.");
    }

    public void disponibilizarImovel(int idImovel, int idAgente)
            throws SecurityException, IllegalArgumentException
    {
        Imovel imovel = getImovelById(idImovel);

        if (imovel == null) {
            throw new IllegalArgumentException("Imóvel com ID " + idImovel + " não encontrado.");
        }

        Proprietario donoDoImovel = imovel.getProprietario();

        if (donoDoImovel == null || donoDoImovel.getId() != idAgente) {
            throw new SecurityException("Ação negada: Você não é o proprietário (ID " + idAgente + ") deste imóvel. Apenas o proprietário pode encerrar o contrato.");
        }

        if (!imovel.estaAlugado()) {
            System.out.println("Atenção: Imóvel já está disponível para aluguel.");
            return;
        }

        imovel.setAlugado(false);

        System.out.println("Sucesso: Contrato encerrado. Imóvel ID " + idImovel + " agora está disponível.");
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
        }
    }
}
