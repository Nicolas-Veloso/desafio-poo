
import domain.Proprietario;
import service.ImovelService;
import service.ProprietarioService;

import java.util.Scanner;

public class Main {

    /*
    TODO: Implementar classe inquilino
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ImovelService imovelService = new ImovelService();
        ProprietarioService proprietarioService = new ProprietarioService();

        int escolha = -1;
        while (escolha != 0) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar proprietário");
            System.out.println("2 - Cadastrar imóvel");
            System.out.println("3 - Deletar imóvel");
            System.out.println("4 - Calcular aluguel");
            System.out.println("5 - Alugar imóvel");
            System.out.println("6 - Disponibilizar imóvel");
            System.out.println("7 - Mostrar imóveis alugados");
            System.out.println("0 - Sair");
            escolha = scanner.nextInt();
            //limpa o buffer do scanner
            scanner.nextLine();

            switch (escolha) {
                //1 - Cadastrar Proprietario
                case 1:
                    System.out.println("Informe o nome do proprietário: ");
                    String nome = scanner.next();
                    System.out.println("Informe o telefone do proprietario: ");
                    String telefone = scanner.next();
                    System.out.println("Informe o CPF do proprietario: ");
                    String cpf = scanner.next();
                    proprietarioService.cadastrarProprietario(nome, telefone, cpf);
                    System.out.println("Sucesso: Proprietario cadastrado com sucesso");
                    break;
                //2 - Cadastrar Imóvel
                case 2:
                    if (proprietarioService.estaVazio()) {
                        System.out.println("Erro: Nenhum proprietário cadastrado, Cadastre um proprietário (opção 1)");
                        break;
                    }
                    proprietarioService.listarProprietarios();
                    System.out.println("Informe o ID do proprietario para vincular: ");
                    int idProprietario = scanner.nextInt();
                    scanner.nextLine();
                    Proprietario proprietario = proprietarioService.getProprietarioById(idProprietario);
                    if (proprietario == null) {
                        System.out.println("Erro: Proprietario não encontrado");
                        break;
                    }
                    System.out.println("Informe o endereço do imóvel: ");
                    String endereco = scanner.nextLine();
                    System.out.println("Informe o número do imóvel: ");
                    int numero = scanner.nextInt();
                    imovelService.cadastrarImovel(endereco, numero, proprietario);
                    break;
                //3 - Deletar imóvel
                case 3:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja excluir: ");
                    int idImovel = scanner.nextInt();
                    if (imovelService.deletarImovelById(idImovel)) {
                        System.out.println("Sucesso: Imóvel removido com sucesso");
                    } else {
                        System.out.println("Erro: Imóvel não encontrado");
                    }
                    break;
                //4 - Calcular aluguel
                case 4:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel: ");
                    int idImovelToCalc = scanner.nextInt();
                    System.out.println("Informe quantos meses de aluguel deseja calcular: ");
                    int meses = scanner.nextInt();
                    double precoAluguel = imovelService.calcularAluguel(idImovelToCalc, meses);
                    System.out.printf("O preço do aluguel para %d meses é R$%.2f\n", meses, precoAluguel);
                    break;
                //5 - Alugar imóvel
                case 5:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja alugar: ");
                    int idParaAlugar = scanner.nextInt();
                    imovelService.alugarImovel(idParaAlugar);
                    break;
                //6 - Disponibilizar imóvel
                case 6:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja disponibilizar: ");
                    int idParaDisponibilizar = scanner.nextInt();
                    imovelService.disponibilizarImovel(idParaDisponibilizar);
                    break;
                //7 - Mostrar imóveis alugados
                case 7:
                    imovelService.mostrarImoveisAlugados();
            }
        }
    }
}
