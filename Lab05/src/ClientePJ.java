import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;
    private ArrayList<Sinistro> listaSinistros;

    // CONSTRUTOR
    public ClientePJ(String nome, String endereco, String telefone, String email, List<Veiculo> listaVeiculos,
            String cnpj, Date dataFundacao, int qtdeFuncionarios, ArrayList<Sinistro> listaSinistros) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
        this.listaSinistros = listaSinistros;
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

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    // SETTERS
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataFundacaoFormadata = new SimpleDateFormat("dd/MM/yyyy").format(getDataFundacao());

        /*
         * MUDAR P FROTA
         * List<String> placasVeiculos = new ArrayList<String>();
         * for (Veiculo veiculo : getListaVeiculos()) {
         * placasVeiculos.add(veiculo.getPlaca());
         * }
         * String placasVeiculosFormatada = String.join(", ", placasVeiculos);
         */

        String listaSinistrosFormatada = "Vazio";
        if (!getListaSinistros().isEmpty()) {
            listaSinistrosFormatada = "";
            ArrayList<String> listaSinistroID = new ArrayList<String>();
            for (Sinistro sinistro : getListaSinistros()) {
                listaSinistroID.add(sinistro.getId().toString());
            }
            listaSinistrosFormatada = String.join(", ", listaSinistroID);
        }

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CNPJ: " + getCnpj() + " | ";
        descricao += "Data de Fundação: " + dataFundacaoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        // descricao += "Lista de veículos: " + placasVeiculosFormatada;
        descricao += "Sinistros: " + listaSinistrosFormatada;
        return descricao;
    }

    // Caldula idade do cliente a partir da data de nascimento
    // - Retorna: Idade do cliente em anos
    public Integer calcularIdade() {
        LocalDate dataFundacaoLocalDate = dataFundacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(dataFundacaoLocalDate, dataAtual);
        int idade = periodo.getYears();
        return idade;
    }
}