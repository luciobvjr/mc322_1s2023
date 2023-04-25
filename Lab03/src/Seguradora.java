import java.util.LinkedList;
import java.util.List;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;

    // CONSTRUCTOR
    public Seguradora(String nome, String telefone, String email, String endereco, List<Sinistro> listaSinistros,
            List<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
    }

    // GETTERS
    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public List<Sinistro> getListaSinistros() {
        return this.listaSinistros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    // MÉTODOS PÚBLICOS

    // Adiciona um novo cliente na seguradora.
    // - Entrada: Objeto do cliente a ser adicionado
    // - Retorna: 'true' se o cliente foi adicionado com sucesso e 'false' caso contrário
    public boolean cadastrarCliente(Cliente cliente) {
        return this.listaClientes.add(cliente);
    }

    // Remove um cliente da seguradora.
    // - Entrada: CPF(caso PF) ou CNPJ(caso PJ) do cliente a ser removido
    // - Retorna: 'true' se o cliente foi removido com sucesso e 'false' caso contrário
    public boolean removerCliente(String cliente) {
        for (Cliente clienteObj : listaClientes) {
            if (clienteObj instanceof ClientePF) {
                ClientePF clientePF = (ClientePF) clienteObj;
                if (clientePF.getCpf() == cliente) {
                    return this.listaClientes.remove(clienteObj);
                }
            } else if (clienteObj instanceof ClientePJ) {
                ClientePJ clientePJ = (ClientePJ) clienteObj;
                if (clientePJ.getCnpj() == cliente) {
                    return this.listaClientes.remove(clienteObj);
                }
            }
        } 
        return false;
    }

    // Lista os clientes da seguradora.
    // - Entrada: String "PF" para listar pessoas físicas
    //            String "PJ" para listar pessoas jurídicas
    //            String "GERAL" para listar todos clientes
    // - Retorna: String contendo as informações dos clientes do tipo selecionado
    public String listarClientes(String tipoCliente) {
        List<String> listaDocumentos = new LinkedList<String>();

        switch (tipoCliente) {
            case "PF":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePF) {
                        ClientePF clientePF = (ClientePF) clienteObj;
                        listaDocumentos.add(clientePF.toString());
                    }
                }
                break;
            case "PJ":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePJ) {
                        ClientePJ clientePJ = (ClientePJ) clienteObj;
                        listaDocumentos.add(clientePJ.toString());
                    }
                }
                break;
            case "GERAL":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePF) {
                        ClientePF clientePF = (ClientePF) clienteObj;
                        listaDocumentos.add(clientePF.toString());
                    } else if (clienteObj instanceof ClientePJ) {
                        ClientePJ clientePJ = (ClientePJ) clienteObj;
                        listaDocumentos.add(clientePJ.toString());
                    }
                }
                break;
            default:
                return "Tipo de cliente inválido. Tente 'PF' para listar pessoas físicas, 'PJ' para listar pessoas jurídicas ou 'GERAL' para listar todos os clientes";
        }

        String listaClientedFormatada = String.join("\n", listaDocumentos);
        return listaClientedFormatada;
    }

    // Gera um novo sinistro.
    // - Entrada: endereco - String representando o endereço do sinistro
    //            veiculo - Veiculo da ocorrência do sinistro
    //            cliente - Cliente relacionado ao sinistro
    // - Retorna: 'true'
    public boolean gerarSinistro(String data, String endereco, Veiculo veiculo, Cliente cliente) {
        Sinistro sinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        this.listaSinistros.add(sinistro);
        return true;
    }
}
