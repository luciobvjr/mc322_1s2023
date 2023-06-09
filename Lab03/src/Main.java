import java.util.Date;
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
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 3, 15);
        Date dataLicenca = calendar.getTime();

        calendar.set(1991, 2, 27);
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
                dataFundacao);

        ClientePJ clienteJuridico2 = new ClientePJ(
                "Consultório da Zezé",
                "Rua da Zezé, 321",
                listaVeiculos,
                "75.907.387/0001-63",
                dataFundacao);

        ClientePJ clienteJuridico3 = new ClientePJ(
                "Empresa teste",
                "Rua da empresa, 321",
                listaVeiculos,
                "65.496.143/0001-81",
                dataFundacao);

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
                "27/03/2000",
                "Rua do Sinistro, 123",
                seguradora,
                motoVeiculo,
                clienteFisico1);

        // Cadastro de clientes na seguradora
        for (ClientePF clientePF : listaClientesPF) {
                if (ClientePF.validarCPF(clientePF.getCpf())) {
                        seguradora.cadastrarCliente(clientePF);
                }
        }

        for (ClientePJ clientePJ : listaClientesPJ) {
                if (ClientePJ.validarCNPJ(clientePJ.getCnpj())) {
                        seguradora.cadastrarCliente(clientePJ);
                }
        }

        // Remoção de clientes na seguradora
        seguradora.removerCliente(clienteFisico3.getCpf());
        seguradora.removerCliente(clienteJuridico3.getCnpj());

        // Geração de sinistro
        seguradora.gerarSinistro(sinistro.getData(), sinistro.getEndereco(), sinistro.getVeiculo(), sinistro.getCliente());

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
        menu(seguradora);
    }

    public static void menu(Seguradora seguradora) {
        String menuTextual = "";
        menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
        menuTextual += "1 - Visualizar lista de todos os CLIENTES da seguradora\n";
        menuTextual += "2 - Visualizar lista de todos os CLIENTES PESSOA FÍSICA da seguradora\n";
        menuTextual += "3 - Visualizar lista de todos os CLIENTES PESSOA JURÍDICA da seguradora\n";
        menuTextual += "4 - Visualizar lista de todos os SINISTROS da seguradora\n";
        menuTextual += "N° do documento - Visualizar SINISTRO referente ao cliente que possui o documento inserido\n";
        System.out.println(menuTextual);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
                case "1":
                        seguradora.listarClientes("GERAL");
                        break;
                case "2":
                        seguradora.listarClientes("PF");
                        break;
                case "3":
                        seguradora.listarClientes("PJ");
                        break;
                case "4":
                        seguradora.listarSinistros();
                        break;
                default:
                        seguradora.visualizarSinistro(input);
                        break;
        }

        scanner.close();
    }
}
