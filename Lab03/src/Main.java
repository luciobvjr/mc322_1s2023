import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Veículo

        Veiculo fuscaVeiculo = new Veiculo(
                "PCX-1234",
                "Volkswagen",
                "Fusca",
                1992);

        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(fuscaVeiculo);

        // Cliente PF

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 3, 15);
        Date dataLicenca = calendar.getTime();

        calendar.set(1991, 2, 27);
        Date dataNascimento = calendar.getTime();

        ClientePF clientePF = new ClientePF(
                "cliente teste",
                "rua do cliente, 123",
                listaVeiculos,
                "641.171.160-70",
                "Feminino",
                dataLicenca,
                "Ensino médio completo",
                dataNascimento,
                "Média");

        // Cliente PJ

        calendar.set(2015, 8, 2);
        Date dataFundacao = calendar.getTime();

        ClientePJ clientePJ = new ClientePJ(
                "Empresa teste",
                "Rua da empresa, 321",
                listaVeiculos,
                "04.490.765/0001-08",
                dataFundacao);

        // Sinistro

        Sinistro sinistro = new Sinistro(
                "27/03/2000",
                "Rua do Sinistro, 123",
                null,
                fuscaVeiculo,
                clientePF);

        // Seguradora 

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(clientePF);
        listaClientes.add(clientePJ);

        Seguradora seguradora = new Seguradora(
                "Seguradora TOP",
                "912345678",
                "top@seguradora.com",
                "rua do seguro, 123",
                new ArrayList<Sinistro>(),
                listaClientes);

        calendar.set(2021, 2, 15);
        Date dataSinistro = calendar.getTime();
        String dataSinistroFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataSinistro);
        seguradora.gerarSinistro(dataSinistroFormatada, sinistro.getEndereco(), sinistro.getVeiculo(), sinistro.getCliente());

        seguradora.listarClientes("PJ");
        seguradora.listarSinistros();
    }
}
