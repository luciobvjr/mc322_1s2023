import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Seguradora {
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Seguro> listaSeguros;

    // CONSTRUCTOR
    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco,
            ArrayList<Cliente> listaClientes, ArrayList<Seguro> listaSeguros) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaClientes = listaClientes;
        this.listaSeguros = listaSeguros;
    }

    // GETTERS
    public String getCnpj() {
        return cnpj;
    }

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

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
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

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    // MÉTODOS PÚBLICOS

    @Override
    public String toString() {
        String nomesClientesFormatado = "Vazio";
        if (listaClientes.isEmpty()) {
            List<String> nomesClientes = new ArrayList<String>();
            for (Cliente cliente : getListaClientes()) {
                nomesClientes.add(cliente.getNome());
            }
            nomesClientesFormatado = String.join(", ", nomesClientes);
        }

        String segurosFormatado = "Vazio";
        if (!listaClientes.isEmpty()) {
            List<String> seguros = new ArrayList<String>();
            for (Seguro seguro : listaSeguros) {
                seguros.add(seguro.getId().toString());
            }
            segurosFormatado = String.join(", ", seguros);
        }

        String descricao = "";
        descricao += "CNPJ: " + getCnpj() + " | ";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        descricao += "Email: " + getEmail() + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Lista de clientes: " + nomesClientesFormatado + " | ";
        descricao += "Lista de seguros: " + segurosFormatado;
        return descricao;
    }

    // Adiciona um novo cliente na seguradora.
    // - Entrada: Objeto do cliente a ser adicionado
    // - Retorna: 'true' se o cliente foi adicionado com sucesso e 'false' caso
    // contrário
    public boolean cadastrarCliente(Cliente cliente) {
        return this.listaClientes.add(cliente);
    }

    // Remove um cliente da seguradora.
    // - Entrada: CPF(caso PF) ou CNPJ(caso PJ) do cliente a ser removido
    // - Retorna: 'true' se o cliente foi removido com sucesso e 'false' caso
    // contrário
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

    // Printa os clientes da seguradora.
    // - Entrada: String "PF" para listar pessoas físicas
    // String "PJ" para listar pessoas jurídicas
    // String "GERAL" para listar todos clientes
    public void listarClientes(String tipoCliente) {
        List<String> listaClientesStrings = new LinkedList<String>();

        switch (tipoCliente) {
            case "PF":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePF) {
                        ClientePF clientePF = (ClientePF) clienteObj;
                        listaClientesStrings.add(clientePF.toString());
                    }
                }
                break;
            case "PJ":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePJ) {
                        ClientePJ clientePJ = (ClientePJ) clienteObj;
                        listaClientesStrings.add(clientePJ.toString());
                    }
                }
                break;
            case "GERAL":
                for (Cliente clienteObj : listaClientes) {
                    if (clienteObj instanceof ClientePF) {
                        ClientePF clientePF = (ClientePF) clienteObj;
                        listaClientesStrings.add(clientePF.toString());
                    } else if (clienteObj instanceof ClientePJ) {
                        ClientePJ clientePJ = (ClientePJ) clienteObj;
                        listaClientesStrings.add(clientePJ.toString());
                    }
                }
                break;
            default:
                System.out.println(
                        "Tipo de cliente inválido. Tente 'PF' para listar pessoas físicas, 'PJ' para listar pessoas jurídicas ou 'GERAL' para listar todos os clientes");
                return;
        }

        String listaClientedFormatada = String.join("\n", listaClientesStrings);
        System.out.println("\n---------- Lista de clientes da seguradora: " + this.getNome());
        System.out.println(listaClientedFormatada);
        return;
    }

    // Método para encontrar um cliente PF na lista de clientes da seguradora
    // - Entrada: CPF do cliente a ser procurado
    // - Retorna: Cliente se for encontrado na lista e 'null' caso contrário
    public ClientePF getClientePF(String cpf) {
        for (Cliente cliente : getListaClientes()) {
            if (cliente instanceof ClientePF) {
                ClientePF clientePF = (ClientePF) cliente;
                if (clientePF.getCpf().equals(cpf)) {
                    return clientePF;
                }
            }
        }
        return null;
    }

    // Método para encontrar um cliente PJ na lista de clientes da seguradora
    // - Entrada: CNPJ do cliente a ser procurado
    // - Retorna: Cliente se for encontrado na lista e 'null' caso contrário
    public ClientePJ getClientePJ(String cnpj) {
        for (Cliente cliente : getListaClientes()) {
            if (cliente instanceof ClientePJ) {
                ClientePJ clientePJ = (ClientePJ) cliente;
                if (clientePJ.getCnpj().equals(cnpj)) {
                    return clientePJ;
                }
            }
        }
        return null;
    }

    public boolean gerarSeguroPF(ClientePF cliente, Date dataInicio, Date dataFim, Veiculo veiculo) {
        SeguroPF seguroPF = new SeguroPF(dataInicio, dataFim, this, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), 0.0, veiculo, cliente);
        return listaSeguros.add(seguroPF);
    }

    public boolean gerarSeguroPJ(ClientePJ cliente, Date dataInicio, Date dataFim, Frota frota) {
        SeguroPJ seguroPJ = new SeguroPJ(dataInicio, dataFim, this, new ArrayList<Sinistro>(), new ArrayList<Condutor>(), 0.0, frota, cliente);
        return listaSeguros.add(seguroPJ);
    }

    public boolean cancelarSeguro(Integer id) {
        return listaSeguros.removeIf(seguro -> seguro.getId().equals(id));
    }
}
