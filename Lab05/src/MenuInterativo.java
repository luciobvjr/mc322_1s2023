import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Menu.MenuCadastro;
import Menu.MenuExcluir;
import Menu.MenuListar;
import Menu.MenuOperacoes;

public class MenuInterativo {
        public static Seguradora seguradora;

        public static void menuPrincipal() {
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

                if (input.equals(MenuOperacoes.SAIR.operacao)) {
                        // encerrar o programa
                } else if (input.equals(MenuOperacoes.CADASTRAR.operacao)) {
                        menuCadastro();
                } else if (input.equals(MenuOperacoes.LISTAR.operacao)) {
                        menuListar();
                } else if (input.equals(MenuOperacoes.EXCLUIR.operacao)) {
                        menuExcluir();
                } else if (input.equals(MenuOperacoes.GERAR_SINISTRO.operacao)) {
                        // gerar sinistro
                } else if (input.equals(MenuOperacoes.TRANSFERIR_SEGURO.operacao)) {
                        // transferir seguro
                } else if (input.equals(MenuOperacoes.CALCULAR_RECEITA.operacao)) {
                        // calcular receita
                } else {
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                }

                scanner.close();
        }

        public static void menuCadastro() {
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

                if (input.equals(MenuCadastro.VOLTAR.operacao)) {
                        menuPrincipal();
                } else if (input.equals(MenuCadastro.CADASTRAR_CLIENTE_PF.operacao)) {
                        cadastrarClientePF(scanner);
                        menuPrincipal();
                } else if (input.equals(MenuCadastro.CADASTRAR_CLIENTE_PJ.operacao)) {
                        cadastrarClientePJ(scanner);
                        menuPrincipal();
                } else if (input.equals(MenuCadastro.CADASTRAR_VEICULO.operacao)) {
                        cadastrarVeiculo(scanner);
                        menuPrincipal();
                } else if (input.equals(MenuCadastro.CADASTRAR_SEGURADORA.operacao)) {
                        Seguradora seguradora = criarSeguradora(scanner);
                        MenuInterativo.seguradora = seguradora;
                        System.out.println(seguradora);
                        menuPrincipal();
                } else {
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                }

                scanner.close();
        }

        public static void menuListar() {
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

                if (input.equals(MenuListar.VOLTAR.operacao)) {
                        menuPrincipal();
                } else if (input.equals(MenuListar.LISTAR_CLIENTES_GERAL.operacao)) {
                        // Listar todos os clientes
                } else if (input.equals(MenuListar.LISTAR_CLIENTES_PF.operacao)) {
                        // Listar clientes PF
                } else if (input.equals(MenuListar.LISTAR_CLIENTES_PJ.operacao)) {
                        // Listar clientes PJ
                } else if (input.equals(MenuListar.LISTAR_SINISTROS.operacao)) {
                        // Listar sinistros
                } else {
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                }

                scanner.close();
        }

        public static void menuExcluir() {
                String menuTextual = "";
                menuTextual += "\nDigite o número em frente à ação descrita para realizá-la:\n";
                menuTextual += "0 - Voltar\n";
                menuTextual += "1 - Excluir cliente\n";
                menuTextual += "2 - Excluir veículo\n";
                menuTextual += "3 - Excluir sinistro\n";
                System.out.println(menuTextual);

                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();

                if (input.equals(MenuExcluir.VOLTAR.operacao)) {
                        menuPrincipal();
                } else if (input.equals(MenuExcluir.EXCLUIR_CLIENTE.operacao)) {
                        // Excluir cliente
                } else if (input.equals(MenuExcluir.EXCLUIR_VEICULO.operacao)) {
                        // Excluir veículo
                } else if (input.equals(MenuExcluir.EXCLUIR_SINISTRO.operacao)) {
                        // Excluir sinistro
                } else {
                        System.out.println("Operação inválida. Tente novamente com uma das opções apresentadas.");
                }

                scanner.close();
        }

        // MÉTODOS PRIVADOS

        private static Seguradora criarSeguradora(Scanner scanner) {
                System.out.println("Nome da seguradora: ");
                String nomeSeguradora = scanner.nextLine();
                if (nomeSeguradora.isBlank()) {
                        System.out.println("\nErro: Nome inválido");
                }

                System.out.println("\nTelefone da seguradora (Digite apenas os números)");
                String telefone = scanner.nextLine();
                if (!Validacao.validarTelefone(telefone)) {
                        System.out.println("\nErro: Número de telefone inválido");
                }

                System.out.println("\nEmail da seguradora");
                String email = scanner.nextLine();
                if (!Validacao.validarEmail(email)) {
                        System.out.println("\nErro: Endereço de email inválido");
                }

                System.out.println("\nEndereço da seguradora");
                String endereco = scanner.nextLine();
                if (endereco.isBlank()) {
                        System.out.println("\nErro: Endereço inválido");
                }

                Seguradora seguradora = new Seguradora(nomeSeguradora, telefone, email, endereco,
                                new ArrayList<Sinistro>(), new ArrayList<Cliente>());

                System.out.println("\nSeguradora " + seguradora.getNome() + " cadastrada com sucesso!!!");

                return seguradora;
        }

        private static void cadastrarClientePF(Scanner scanner) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                System.out.println("\nNome do cliente: ");
                String nomeCliente = scanner.nextLine();
                if (nomeCliente.isBlank()) {
                        System.out.println("\nErro: Nome inválido");
                        return;
                }

                System.out.println("\nEndereço do cliente");
                String endereco = scanner.nextLine();
                if (endereco.isBlank()) {
                        System.out.println("\nErro: Endereço inválido");
                        return;
                }

                System.out.println("\nTelefone do cliente");
                String telefone = scanner.nextLine();
                if (endereco.isBlank()) {
                        System.out.println("\nErro: Telefone inválido");
                        return;
                }

                System.out.println("\nEmail do cliente");
                String email = scanner.nextLine();
                if (!Validacao.validarEmail(email)) {
                        System.out.println("\nErro: Email inválido");
                        return;
                }

                System.out.println("\nCPF do cliente: ");
                String cpf = scanner.nextLine();
                if (!Validacao.validarCPF(cpf)) {
                        System.out.println("\nErro: CPF inválido");
                        return;
                }

                System.out.println("\nGênero do cliente: ");
                String genero = scanner.nextLine();

                System.out.println("\nData de licença do cliente (DD/MM/AAAA): ");
                String dataLicencaString = scanner.nextLine();
                Date dataLicenca;
                try {
                        dataLicenca = dateFormat.parse(dataLicencaString);
                } catch (ParseException e) {
                        System.out.println("Erro: Data inválida");
                        return;
                }

                System.out.println("\nNível de educação do cliente: ");
                String nivelEducacao = scanner.nextLine();

                System.out.println("\nData de nascimento do cliente (DD/MM/AAAA): ");
                String dataNascimentoString = scanner.nextLine();
                Date dataNascimento;
                try {
                        dataNascimento = dateFormat.parse(dataNascimentoString);
                } catch (ParseException e) {
                        System.out.println("\nErro: Data inválida");
                        return;
                }

                System.out.println("\nClasse econômica do cliente: ");
                String classeEconomica = scanner.nextLine();

                Cliente cliente = new ClientePF(nomeCliente, endereco, telefone, email, new ArrayList<Veiculo>(), cpf, genero, dataLicenca,
                                nivelEducacao, dataNascimento, classeEconomica, new ArrayList<Sinistro>());
                seguradora.cadastrarCliente(cliente);

                return;
        }

        private static void cadastrarClientePJ(Scanner scanner) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                System.out.println("\nNome do cliente: ");
                String nomeCliente = scanner.nextLine();
                if (nomeCliente.isBlank()) {
                        System.out.println("\nErro: Nome inválido");
                        return;
                }

                System.out.println("\nEndereço do cliente");
                String endereco = scanner.nextLine();
                if (endereco.isBlank()) {
                        System.out.println("\nErro: Endereço inválido");
                        return;
                }

                System.out.println("\nEndereço do cliente");
                String telefone = scanner.nextLine();
                if (endereco.isBlank()) {
                        System.out.println("\nErro: Endereço inválido");
                        return;
                }

                System.out.println("\nEmail do cliente");
                String email = scanner.nextLine();
                if (!Validacao.validarEmail(email)) {
                        System.out.println("\nErro: Email inválido");
                        return;
                }

                System.out.println("CNPJ do cliente: ");
                String cnpj = scanner.nextLine();
                if (!Validacao.validarCNPJ(cnpj)) {
                        System.out.println("\nErro: CNPJ inválido");
                        return;
                }

                System.out.println("\nData de fundação da empresa (DD/MM/AAAA): ");
                String dataFundacaoString = scanner.nextLine();
                Date dataFundacao;
                try {
                        dataFundacao = dateFormat.parse(dataFundacaoString);
                } catch (ParseException e) {
                        System.out.println("\nErro: Data inválida");
                        return;
                }

                System.out.println("\nQuantidade de funcionários: ");
                String qtdeFuncionariosString = scanner.nextLine();
                Integer qtdeFuncionarios = Integer.valueOf(qtdeFuncionariosString);

                Cliente cliente = new ClientePJ(nomeCliente, endereco, email, telefone, new ArrayList<Veiculo>(), cnpj,
                                dataFundacao, qtdeFuncionarios, new ArrayList<Sinistro>());
                seguradora.cadastrarCliente(cliente);
        }

        private static void cadastrarVeiculo(Scanner scanner) {
                System.out.println("\nCPF do cliente: ");
                String cpf = scanner.nextLine();
                if (!Validacao.validarCPF(cpf)) {
                        System.out.println("\nErro: CPF inválido");
                        return;
                }

                ClientePF clientePF = seguradora.getClientePF(cpf);
                if (clientePF == null) {
                        System.out.println("\nErro: Cliente inexistente");
                        return;
                }

                System.out.println("\nPlaca: ");
                String placa = scanner.nextLine();
                if (placa.isBlank()) {
                        System.out.println("\nErro: Placa inválida");
                        return;
                }

                System.out.println("\nMarca");
                String marca = scanner.nextLine();
                if (marca.isBlank()) {
                        System.out.println("\nErro: Marca inválida");
                        return;
                }

                System.out.println("\nModelo");
                String modelo = scanner.nextLine();
                if (modelo.isBlank()) {
                        System.out.println("\nErro: Modelo inválido");
                        return;
                }

                System.out.println("\nAno de fabricação: ");
                String anoFabricacaoString = scanner.nextLine();
                Integer anoFabricacao = Integer.valueOf(anoFabricacaoString);

                if (anoFabricacaoString.isBlank() || anoFabricacao > 2023) {
                        System.out.println("\nErro: Ano de fabricação inválido");
                        return;
                }

                Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                clientePF.cadastrarVeiculo(veiculo);

                System.out.println("\nVeículo " + veiculo.getPlaca() + " cadastrada com sucesso para o cliente " + clientePF.getNome() + " !!!");
        }
}
