import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ClientePF extends Cliente {
    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;
    private ArrayList<Veiculo> listaVeiculos;

    // CONSTRUTOR
    public ClientePF(String nome, String endereco, String telefone, String email, ArrayList<Veiculo> listaVeiculos, String cpf, String genero, 
                     Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
        this.listaVeiculos = listaVeiculos;
    }

    // GETTERS
    public String getCpf() {
        return cpf;
    }

    public String getGenero() {
        return genero;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    // SETTERS
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    
    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataNascimentoFormadata = new SimpleDateFormat("dd/MM/yyyy").format(getDataNascimento());
        String dataLicencaFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getDataLicenca());

        List<String> placasVeiculos = new ArrayList<String>();
        for (Veiculo veiculo : getListaVeiculos()) {
            placasVeiculos.add(veiculo.getPlaca());
        }
        String placasVeiculosFormatada = String.join(", ", placasVeiculos);

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CPF: " + getCpf() + " | ";
        descricao += "Gênero: " + getGenero() + " | ";
        descricao += "Data de nascimento: " + dataNascimentoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        descricao += "Email: " + getEmail() + " | ";
        descricao += "Lista de veículos: " + placasVeiculosFormatada + " | ";
        descricao += "Data de licença: " + dataLicencaFormatada + " | ";
        descricao += "Educação: " + getEducacao() + " | ";
        descricao += "Classe econômica: " + getClasseEconomica();
        return descricao;
    }

    // Calcula o valor do seguro do cliente PF 
    // - Retorna: valor do seguro calculado
    public double calculaScore() { 
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);

        calendar.setTime(dataNascimento);
        int birthYear = calendar.get(Calendar.YEAR);

        int idade = currentYear - birthYear;
        double fatorIdade = 1;
        
        if (idade >= 18 && idade < 30) {
            fatorIdade = CalcSeguro.FATOR_18_30.value;
        } else if (idade >= 30 && idade < 60) {
            fatorIdade = CalcSeguro.FATOR_30_60.value;
        } else if (idade >= 60 && idade < 90) {
            fatorIdade = CalcSeguro.FATOR_60_90.value;
        } else {
            return (-1);
        }
 
        double score = (CalcSeguro.VALOR_BASE.value * fatorIdade * this.getListaVeiculos().size());
        return score;
    }

    // Cadastra um novo veículo para o cliente.
    // - Entrada: Objeto do veículo a ser adicionado
    // - Retorna: 'true' se o veículo foi adicionado com sucesso e 'false' caso contrário
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        return this.getListaVeiculos().add(veiculo);
    }

    // Remove um veículo do cliente.
    // - Entrada: Placa do veículo a ser removido
    // - Retorna: 'true' se o veículo foi removido com sucesso e 'false' caso contrário
    public boolean removerVeiculo(String placa) {
        for (Veiculo veiculo : getListaVeiculos()) {
            if (veiculo.getPlaca().equals(placa)) {
                return this.getListaVeiculos().remove(veiculo);
            }
        }

        return false;
    }

    // Método para encontrar um veículo na lista de veículos do cliente
    // - Entrada: Placa do veículo a ser procurado
    // - Retorna: Veículo se for encontrado na lista e 'null' caso contrário
    public Veiculo getVeiculo(String placa) {
        for (Veiculo veiculo : getListaVeiculos()) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}