import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Seguradora seguradora = new Seguradora(
                "Seguradora TOP",
                "912345678",
                "top@seguradora.com",
                "rua do seguro, 123",
                new ArrayList<Sinistro>(),
                new ArrayList<Cliente>());

        Veiculo fuscaVeiculo = new Veiculo(
                "PCX-1234",
                "Volkswagen",
                "Fusca",
                1992);

        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(fuscaVeiculo);

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

        Sinistro sinistro = new Sinistro(
                "27/03/2000",
                "Rua do Sinistro, 123",
                seguradora,
                fuscaVeiculo,
                clientePF);

        System.out.println(clientePF);
    }
}
