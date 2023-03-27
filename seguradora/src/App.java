public class App {
    public static void main(String[] args) throws Exception {
        Cliente cliente = new Cliente("cliente teste",
                                      "641.171.160-70", 
                                      "27/03/1991", 
                                      "rua do cliente, 123");

        System.out.println(cliente.getIdade());
        cliente.setDataNascimento("27/07/1991");
        System.out.println(cliente.getIdade());

        Seguradora seguradora = new Seguradora("Seguradora",
                                               "19912345678",
                                               "seguradora@mail.com",
                                               "rua da seguradora, 123");


        System.out.println(Cliente.validarCPF("439.279.78"));
    }
}
