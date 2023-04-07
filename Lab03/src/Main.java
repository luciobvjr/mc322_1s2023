import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Seguradora seguradora = new Seguradora(
                "Seguradora TOP",
                "912345678",
                "top@seguradora.com",
                "rua do seguro, 123",
                new ArrayList<Sinistro>(),
                new ArrayList<Cliente>());

        Cliente cliente = new Cliente(
                "cliente teste",
                "641.171.160-70",
                "27/03/1991",
                "rua do cliente, 123");

        seguradora.cadastrarCliente(cliente);
        System.out.println(seguradora.getListaClientes());

        seguradora.removerCliente(cliente.getCpf());
        System.out.println(seguradora.getListaClientes());
    }
}
