import domain.Imovel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Imovel> imoveisAlugados = new ArrayList<>();

    public static void main(String[] args) {
        int escolha = -1;
        while (escolha > 0) {
            System.out.println("===== Escolha uma opção =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Calcular aluguel");
            System.out.println("4 - Alugar Imovel");
            System.out.println("5 - Disponibilizar imóvel");
        }
    }
}
