import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

                ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
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
                                "19912345678",
                                "michael@jackson.com",
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
                                "19912345678",
                                "poliana@moca.com",
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
                                "19912345678",
                                "tirulipa@almeida.com",
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
                                "19912345678",
                                "unicamp@sorvetes.com",
                                "04.490.765/0001-08",
                                dataFundacao,
                                5000, 
                                new ArrayList<Frota>());

                ClientePJ clienteJuridico2 = new ClientePJ(
                                "Consultório da Zezé",
                                "Rua da Zezé, 321",
                                "19912345678",
                                "consultorio@zeze.com",
                                "75.907.387/0001-63",
                                dataFundacao,
                                20, 
                                new ArrayList<Frota>());

                ClientePJ clienteJuridico3 = new ClientePJ(
                                "Empresa teste",
                                "Rua da empresa, 321",
                                "19912345678",
                                "empresa@teste.com",
                                "65.496.143/0001-81",
                                dataFundacao,
                                30, 
                                new ArrayList<Frota>());

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

                // Instanciação de Frota
                Frota frota = new Frota("1", listaVeiculos);

                // Instanciação de Seguro
                SeguroPF seguroPF = new SeguroPF(
                                dataNascimento,
                                dataFundacao,
                                seguradora,
                                new ArrayList<>(),
                                new ArrayList<>(),
                                100.0,
                                motoVeiculo,
                                clienteFisico3);

                SeguroPJ seguroPJ = new SeguroPJ(
                                dataNascimento,
                                dataFundacao,
                                seguradora,
                                new ArrayList<>(),
                                new ArrayList<>(),
                                150.0,
                                frota,
                                clienteJuridico3);

                // Instanciação de Condutor
                Condutor condutor = new Condutor(
                                "Nelso",
                                "Rua do Nelso, 23",
                                "19912345678",
                                "nelso@email.com",
                                "468.039.620-24",
                                dataNascimento,
                                new ArrayList<Sinistro>());

                // Instanciação de Sinistro
                Sinistro sinistro = new Sinistro(new Date(), "Rua do Sinistro, 123", condutor, seguroPF);
                Sinistro sinistro2 = new Sinistro(new Date(), "Rua do Jambolão, 123", condutor, seguroPJ);

                condutor.adicionarSinistro(sinistro);
                condutor.adicionarSinistro(sinistro2);

                // Remoção de clientes na seguradora
                seguradora.removerCliente(clienteFisico3.getCpf());
                seguradora.removerCliente(clienteJuridico3.getCnpj());

                // Print toString() de cada classe
                System.out.println("---------- Chamada toString de cada classe:");
                System.out.println(clienteFisico1.toString() + "\n");
                System.out.println(clienteJuridico1.toString() + "\n");
                System.out.println(seguradora.toString() + "\n");
                System.out.println(sinistro.toString() + "\n");
                System.out.println(fuscaVeiculo.toString() + "\n");
                System.out.println(frota.toString() + "\n");
                System.out.println(condutor.toString() + "\n");
                System.out.println(seguroPF.toString() + "\n");
                System.out.println(seguroPJ.toString() + "\n");

                // Chamada de métodos da seguradora
                seguradora.listarClientes("GERAL");
                seguradora.listarSinistros();
                // System.out.println("Receita total da Seguradora TOP: " +
                // seguradora.calcularReceita() + "\n");

                // Método para visualizar dados de seguradora a partir de entrada
                MenuInterativo.seguradora = seguradora;
                MenuInterativo.menuPrincipal();
        }
}