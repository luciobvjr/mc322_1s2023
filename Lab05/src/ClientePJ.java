import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    // CONSTRUTOR
    public ClientePJ(String nome, String endereco, String telefone, String email, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    // GETTERS
    public String getCnpj() {
        return cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    // SETTERS
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataFundacaoFormadata = new SimpleDateFormat("dd/MM/yyyy").format(getDataFundacao());
        
        /* MUDAR P FROTA
        List<String> placasVeiculos = new ArrayList<String>();
        for (Veiculo veiculo : getListaVeiculos()) {
            placasVeiculos.add(veiculo.getPlaca());
        }
        String placasVeiculosFormatada = String.join(", ", placasVeiculos);
        */

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CNPJ: " + getCnpj() + " | ";
        descricao += "Data de Fundação: " + dataFundacaoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        //descricao += "Lista de veículos: " + placasVeiculosFormatada;
        return descricao;
    }
}