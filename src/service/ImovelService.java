package service;

import domain.Apartamento;
import domain.Casa;
import domain.Imovel;
import domain.Proprietario;

import java.util.Scanner;

public class ImovelService {

    private static final Scanner SCANNER_DE_ENTRADA = new Scanner(System.in);

    public static Imovel cadastrarImovel(String endereco, int numero, boolean alugado, Proprietario proprietario) {
        if (selecionarImovel().equalsIgnoreCase("casa")) {
            return new Casa(endereco, numero, alugado, proprietario);
        } else if (selecionarImovel().equalsIgnoreCase("apartamento")) {
            return new Apartamento(endereco, numero, alugado, proprietario);
        } else {
            return null;
        }
    }

    private static String selecionarImovel() {
        System.out.println("Informe o tipo de imóvel que deseja criar: (casa / apartamento)");
        return SCANNER_DE_ENTRADA.nextLine().trim();
    }

    public static void fecharScanner() {
        SCANNER_DE_ENTRADA.close();
    }
}
