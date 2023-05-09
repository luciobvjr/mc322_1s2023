import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Instanciação de Veículos
        Veiculo fuscaVeiculo = new Veiculo(
                "PCX-1234",
                "Volkswagen",
                "Fusca",
                1992);

        Veiculo motoVeiculo = new Veiculo(
                "ABC-7777",
                "Yamaha",
                "MT-09",
                2023);

        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(fuscaVeiculo);
        listaVeiculos.add(motoVeiculo);

        // Instanciação de Clientes PF
        Calendar calendar = new GregorianCalendar();
        calendar.set(2000, 3, 15);
        Date dataLicenca = calendar.getTime();

        calendar.set(2000, 2, 27);
        Date dataNascimento = calendar.getTime();

        ClientePF clienteFisico1 = new ClientePF(
                "Michael Jackson da Silva",
                "rua do Michael, 123",
                listaVeiculos,
                "641.171.160-70",
                "Masculino",
                dataLicenca,
                "Ensino médio completo",
                dataNascimento,
                "Média");

        ClientePF clienteFisico2 = new ClientePF(
                "Poliana Moça de Azevedo",
                "rua da Poliana, 123",
                listaVeiculos,
                "395.519.440-03",
                "Feminino",
                dataLicenca,
                "Ensino médio cursando",
                dataNascimento,
                "Média");

        ClientePF clienteFisico3 = new ClientePF(
                "Tirulipa de Almeida",
                "rua do Tirulipa, 123",
                listaVeiculos,
                "927.323.970-67",
                "Masculino",
                dataLicenca,
                "Doutorando em física nuclear",
                dataNascimento,
                "Média");

        List<ClientePF> listaClientesPF = new ArrayList<ClientePF>();
        listaClientesPF.add(clienteFisico1);
        listaClientesPF.add(clienteFisico2);
        listaClientesPF.add(clienteFisico3);

        // Instanciação de Clientes PJ
        calendar.set(2015, 8, 2);
        Date dataFundacao = calendar.getTime();

        ClientePJ clienteJuridico1 = new ClientePJ(
                "Unicamp Sorvetes",
                "Rua Zeferino Vaz, 321",
                listaVeiculos,
                "04.490.765/0001-08",
                dataFundacao,
                5000);

        ClientePJ clienteJuridico2 = new ClientePJ(
                "Consultório da Zezé",
                "Rua da Zezé, 321",
                listaVeiculos,
                "75.907.387/0001-63",
                dataFundacao,
                20);

        ClientePJ clienteJuridico3 = new ClientePJ(
                "Empresa teste",
                "Rua da empresa, 321",
                listaVeiculos,
                "65.496.143/0001-81",
                dataFundacao,
                30);

        List<ClientePJ> listaClientesPJ = new ArrayList<ClientePJ>();
        listaClientesPJ.add(clienteJuridico1);
        listaClientesPJ.add(clienteJuridico2);
        listaClientesPJ.add(clienteJuridico3);

        // Instanciação de Seguradora 
        Seguradora seguradora = new Seguradora(
                "Seguradora TOP",
                "912345678",
                "top@seguradora.com",
                "rua do seguro, 123",
                new ArrayList<Sinistro>(),
                new ArrayList<Cliente>());

        // Instanciação de Sinistro
        Sinistro sinistro = new Sinistro(
                new Date(),
                "Rua do Sinistro, 123",
                seguradora,
                motoVeiculo,
                clienteFisico1);

        // Cadastro de clientes na seguradora
        for (ClientePF clientePF : listaClientesPF) {
                if (Validacao.validarCPF(clientePF.getCpf())) {
                        seguradora.cadastrarCliente(clientePF);
                }
        }

        for (ClientePJ clientePJ : listaClientesPJ) {
                if (Validacao.validarCNPJ(clientePJ.getCnpj())) {
                        seguradora.cadastrarCliente(clientePJ);
                }
        }

        // Remoção de clientes na seguradora
        seguradora.removerCliente(clienteFisico3.getCpf());
        seguradora.removerCliente(clienteJuridico3.getCnpj());

        // Geração de sinistro
        seguradora.gerarSinistro(sinistro.getData(), sinistro.getEndereco(), sinistro.getVeiculo(), sinistro.getCliente());

        seguradora.calcularPrecoSeguroCliente();

        // Print toString() de cada classe
        System.out.println("---------- Chamada toString de cada classe:");
        System.out.println(clienteFisico1.toString() + "\n");
        System.out.println(clienteJuridico1.toString() + "\n");
        System.out.println(seguradora.toString() + "\n");
        System.out.println(sinistro.toString() + "\n");
        System.out.println(fuscaVeiculo.toString() + "\n");

        // Chamada de métodos da seguradora (listarClientes, listarSinistros e visualizarSinistro)
        seguradora.listarClientes("GERAL");
        seguradora.listarSinistros();
        seguradora.visualizarSinistro(clienteFisico1.getCpf());

        // Método para visualizar dados de seguradora a partir de entrada
        List<Seguradora> seguradoras = new ArrayList<>();
        seguradoras.add(seguradora);
        menuPrincipal(seguradoras);
    }

    public static void menuPrincipal(List<Seguradora> seguradoras) {
        String menuTextual = "";
        menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
        menuTextual += "0 - Sair\n";
        menuTextual += "1 - Cadastros\n";
        menuTextual += "2 - Listar\n";
        menuTextual += "3 - Excluir\n";
        menuTextual += "4 - Gerar Sinistro\n";
        menuTextual += "5 - Transferir Seguro\n";
        menuTextual += "6 - Calcular Receita da Seguradora\n";
        System.out.println(menuTextual);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
                case "0":
                        // encerrar o programa
                        break;
                case "1":
                        menuCadastro(seguradoras);
                        break;
                case "2":
                        menuListar(seguradoras);
                        break;
                case "3":
                        menuExcluir(seguradoras);
                        break;
                case "4":
                        // gerar sinistro
                        break;
                case "5":
                        // transferir seguro
                        break;
                case "6":
                        // calcular receita
                        break;
                default:
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                        break;
        }

        scanner.close();
    }

    public static void menuCadastro(List<Seguradora> seguradoras) {
        String menuTextual = "";
        menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
        menuTextual += "0 - Voltar\n";
        menuTextual += "1 - Cadastrar cliente PF\n";
        menuTextual += "2 - Cadastrar cliente PJ\n";
        menuTextual += "3 - Cadastrar veículo\n";
        menuTextual += "4 - Cadastrar seguradora\n";
        System.out.println(menuTextual);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
                case "0":
                        menuPrincipal(seguradoras);
                        break;
                case "1":
                        // Cadastrar cliente PF
                        break;
                case "2":
                        // Cadastrar cliente PJ
                        break;
                case "3":
                        // Cadastrar veículo
                        break;
                case "4":
                        System.out.println("Nome da seguradora: ");
                        String nomeSeguradora = scanner.nextLine();
                        if (nomeSeguradora.isBlank()) {
                                System.out.println("Erro: Nome inválido");
                                break;
                        }

                        System.out.println("\nTelefone da seguradora (Digite apenas os números)");
                        String telefone = scanner.nextLine();
                        if (!Validacao.validarTelefone(telefone)) {
                                System.out.println("Erro: Número de telefone inválido");
                                break;
                        }

                        System.out.println("\nEmail da seguradora");
                        String email = scanner.nextLine();
                        if (!Validacao.validarEmail(email)) {
                                System.out.println("Erro: Endereço de email inválido");
                                break;
                        }

                        System.out.println("\nEndereço da seguradora");
                        String endereco = scanner.nextLine();
                        if (endereco.isBlank()) {
                                System.out.println("Erro: Endereço inválido");
                                break;
                        }

                        Seguradora seguradora = new Seguradora(nomeSeguradora, telefone, email, endereco, new ArrayList<Sinistro>(), new ArrayList<Cliente>());
                        seguradoras.add(seguradora);

                        System.out.println("\nSeguradora " + seguradora.getNome() + " cadastrada com sucesso!!!");
                        menuPrincipal(seguradoras);
                        break;
                default:
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                        break;
        }

        scanner.close();
    }

    public static void menuListar(List<Seguradora> seguradoras) {
        String menuTextual = "";
        menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
        menuTextual += "0 - Voltar\n";
        menuTextual += "1 - Listar todos os clientes\n";
        menuTextual += "2 - Listar clientes PF\n";
        menuTextual += "3 - Listar clientes PJ\n";
        menuTextual += "4 - Listar Sinistros\n";
        System.out.println(menuTextual);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
                case "0":
                        menuPrincipal(seguradoras);
                        break;
                case "1":
                        // Listar todos os clientes
                        break;
                case "2":
                        // Listar clientes PF
                        break;
                case "3":
                        // Listar clientes PJ
                        break;
                case "4":
                        // Listar sinistros
                        break;
                default:
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                        break;
        }

        scanner.close();
    }

    public static void menuExcluir(List<Seguradora> seguradoras) {
        String menuTextual = "";
        menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
        menuTextual += "0 - Voltar\n";
        menuTextual += "1 - Excluir cliente\n";
        menuTextual += "2 - Excluir veículo\n";
        menuTextual += "3 - Excluir sinistro\n";
        System.out.println(menuTextual);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
                case "0":
                        menuPrincipal(seguradoras);
                        break;
                case "1":
                        // Excluir cliente
                        break;
                case "2":
                        // Excluir veículo
                        break;
                case "3":
                        // Excluir sinistro
                        break;
                default:
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                        break;
        }

        scanner.close();
    }
}