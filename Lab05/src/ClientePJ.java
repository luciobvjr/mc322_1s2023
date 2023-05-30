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
    private ArrayList<Frota> listaFrotas;

    // CONSTRUTOR
    public ClientePJ(String nome, String endereco, String telefone, String email,
            String cnpj, Date dataFundacao, int qtdeFuncionarios, ArrayList<Frota> listaFrotas) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
        this.listaFrotas = listaFrotas;
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

    public ArrayList<Frota> getListaFrotas() {
        return listaFrotas;
    }

    // SETTERS
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public void setListaFrotas(ArrayList<Frota> listaFrotas) {
        this.listaFrotas = listaFrotas;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataFundacaoFormadata = new SimpleDateFormat("dd/MM/yyyy").format(getDataFundacao());

        String codigosFrotasFormatado = "Vazio";
        if (!getListaFrotas().isEmpty()) {
            List<String> codigosFrotas = new ArrayList<String>();
            for (Frota frota : getListaFrotas()) {
                codigosFrotas.add(frota.getCode());
            }
            codigosFrotasFormatado = String.join(", ", codigosFrotas);
        }

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CNPJ: " + getCnpj() + " | ";
        descricao += "Data de Fundação: " + dataFundacaoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        descricao += "Lista de frotas: " + codigosFrotasFormatado;
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

    // Cadastra uma nova frota para o cliente.
    // - Entrada: Objeto da frota a ser adicionada
    // - Retorna: 'true' se a frota foi adicionada com sucesso e 'false' caso
    // contrário
    public boolean cadastrarFrota(Frota frota) {
        return this.getListaFrotas().add(frota);
    }

    // Adiciona ou remove veículos de uma frota ou apaga a frota
    // - Entrada: code = código da frota
    // deveApagarFrota = booleano, se 'true', a frota será apagada.
    // veiculosAdd = lista de veículos a serem adicionados na frota.
    // veiculosRemover = lista de veículos a serem removidos na frota.
    // - Retorna: 'true' se a frota foi atualizada com sucesso e 'false' caso
    // contrário
    public boolean atualizarFrotas(String code, Boolean deveApagarFrota, ArrayList<Veiculo> veiculosAdd,
            ArrayList<Veiculo> veiculosRemover) {
        if (deveApagarFrota) {
            return listaFrotas.removeIf(frota -> frota.code.equals(code));
        }

        for (Frota frota : listaFrotas) {
            if (frota.code.equals(code)) {
                frota.listaVeiculos.addAll(veiculosAdd);
                frota.listaVeiculos.removeAll(veiculosRemover);
                return true;
            }
        }

        return false;
    }

    // Disponibiliza a lista de veículos de uma frota
    // - Entrada: code = código da frota.
    // - Retorna: lista de veículos da frota.
    public ArrayList<Veiculo> getVeiculosPorFrota(String code) {
        for (Frota frota : listaFrotas) {
            if (frota.code.equals(code)) {
                return frota.listaVeiculos;
            }
        }

        return null;
    }
}