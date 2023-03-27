public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente(
                "cliente teste",
                "641.171.160-70",
                "27/03/1991",
                "rua do cliente, 123");

        System.out.println(cliente.toString());
        System.out.println(Cliente.validarCPF(cliente.getCpf()));

        Seguradora seguradora = new Seguradora(
                "Seguradora",
                "19912345678",
                "seguradora@mail.com",
                "rua da seguradora, 123");

        Sinistro sinistro = new Sinistro(
                "27/03/2000",
                "rua do sinistro");

        Veiculo veiculo = new Veiculo(
                "abc-1234",
                "montadora",
                "veloz");
    }
}
