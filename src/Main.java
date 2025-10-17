
import domain.Proprietario;
import service.ImovelService;
import service.InquilinoService;
import service.ProprietarioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ImovelService imovelService = new ImovelService();
        ProprietarioService proprietarioService = new ProprietarioService();
        InquilinoService inquilinoService = new InquilinoService();

        int escolha = -1;
        while (escolha != 0) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar proprietário");
            System.out.println("2 - Cadastrar inquilino");
            System.out.println("3 - Cadastrar imóvel");
            System.out.println("4 - Deletar imóvel");
            System.out.println("5 - Calcular aluguel");
            System.out.println("6 - Alugar imóvel");
            System.out.println("7 - Disponibilizar imóvel");
            System.out.println("8 - Mostrar imóveis alugados");
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
                //2 - Cadastrar Inquilino
                case 2:
                    System.out.println("Informe o nome do inquilino: ");
                    String nomeInquilino = scanner.next();
                    System.out.println("Informe o telefone do inquilino: ");
                    String telefoneInquilino = scanner.next();
                    System.out.println("Informe o CPF do inquilino: ");
                    String cpfInquilino = scanner.next();
                    inquilinoService.cadastrarInquilino(nomeInquilino, telefoneInquilino, cpfInquilino);
                    System.out.println("Sucesso: Inquilino cadastrado com sucesso");
                    break;
                //3 - Cadastrar Imóvel
                case 3:
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
                //4 - Deletar imóvel
                case 4:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja excluir: ");
                    int idImovel = scanner.nextInt();
                    if (imovelService.deletarImovelById(idImovel)) {
                        System.out.println("Sucesso: Imóvel removido com sucesso");
                    } else {
                        System.out.println("Erro: Imóvel não encontrado");
                    }
                    break;
                //5 - Calcular aluguel
                case 5:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel: ");
                    int idImovelToCalc = scanner.nextInt();
                    System.out.println("Informe quantos meses de aluguel deseja calcular: ");
                    int meses = scanner.nextInt();
                    double precoAluguel = imovelService.calcularAluguel(idImovelToCalc, meses);
                    System.out.printf("O preço do aluguel para %d meses é R$%.2f\n", meses, precoAluguel);
                    break;
                //6 - Alugar imóvel
                case 6:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja alugar: ");
                    int idParaAlugar = scanner.nextInt();
                    imovelService.alugarImovel(idParaAlugar);
                    break;
                //7 - Disponibilizar imóvel
                case 7:
                    imovelService.listarImoveis();
                    System.out.println("Informe o ID do imóvel que deseja disponibilizar: ");
                    int idParaDisponibilizar = scanner.nextInt();
                    imovelService.disponibilizarImovel(idParaDisponibilizar);
                    break;
                //8 - Mostrar imóveis alugados
                case 8:
                    imovelService.mostrarImoveisAlugados();
            }
        }
        scanner.close();
    }
}
