import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    // CONSTRUTOR
    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco, listaVeiculos);
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
        String dataFundacaoFormadata = new SimpleDateFormat("dd-MM-yyyy").format(getDataFundacao());
        
        List<String> placasVeiculos = new ArrayList<String>();
        for (Veiculo veiculo : getListaVeiculos()) {
            placasVeiculos.add(veiculo.getPlaca());
        }
        String placasVeiculosFormatada = String.join(", ", placasVeiculos);

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CNPJ: " + getCnpj() + " | ";
        descricao += "Data de Fundação: " + dataFundacaoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Lista de veículos: " + placasVeiculosFormatada;
        return descricao;
    }

        // Calcula o valor do seguro do cliente PF 
    // - Retorna: valor do seguro calculado
    public double calculaScore() { 
        double score = (CalcSeguro.VALOR_BASE.value * (1 + ( this.qtdeFuncionarios ) /100) * this.getListaVeiculos().size());
        this.setValorSeguro(score);
        return score;
    }

    // Verifica se o CNPJ é válido (Tem 14 dígitos que não são todos iguais e os dígitos verificadores são válidos).
    // - Entrada: String representando um CNPJ. Os caracteres não numéricos são descartados
    // - Retorna: 'true' o CNPJ é válido e 'false' caso contrário
    static public boolean validarCNPJ(String cnpj) {
        String numericCnpj = cnpj.replaceAll("[^0-9]", "");

        return cnpjTemQuatorzeDigitos(numericCnpj) && !cnpjTemTodosDigitosIguais(numericCnpj) && digitoVerificadorValido(numericCnpj);
    }

    // MÉTODOS PRIVADOS

    // Verifica se o CNPJ tem exatamente 14 dígitos.
    // - Entrada: String representando um CNPJ apenas com caracteres numéricos
    // - Retorna: 'true' se possui 14 dígitos e 'false' caso contrário
    static private boolean cnpjTemQuatorzeDigitos(String numericCnpj) {
        if (numericCnpj.length() == 14) {
            return true;
        }

        return false;
    }

    // Verifica se todos os dígitos do CNPJ são iguais.
    // - Entrada: String representando um CNPJ apenas com caracteres numéricos
    // - Retorna: 'true' se todos os dígitos são iguais e 'false' caso contrário
    static private boolean cnpjTemTodosDigitosIguais(String numericCnpj) {
        char[] splittedCnpj = numericCnpj.toCharArray();
        for (char digit1 : splittedCnpj) {
            for (char digit2 : splittedCnpj) {
                if (digit1 != digit2) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica se os dígitos verificadores do CNPJ são válidos.
    // - Entrada: String representando um CNPJ apenas com caracteres numéricos
    // - Retorna: 'true' se os dígitos verificadores são válidos e 'false' caso contrário
    static private boolean digitoVerificadorValido(String numericCnpj) {
        char[] splittedCnpj = numericCnpj.toCharArray();
        int verificador1 = Character.getNumericValue(splittedCnpj[splittedCnpj.length - 2]);
        int verificador2 = Character.getNumericValue(splittedCnpj[splittedCnpj.length - 1]);

        int[] multiplicadores = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        // Primeiro dígito verificador
        int soma = 0;
        for (int index = 0; index < splittedCnpj.length - 2; index++) {
            int digito = Character.getNumericValue(splittedCnpj[index]);
            soma += digito * multiplicadores[index];
        }

        int resto = soma % 11;
        int verificadorCalculado = 11 - resto;
        if (verificadorCalculado >= 10) {
            verificadorCalculado = 0;
        }
        if (verificador1 != verificadorCalculado) {
            return false;
        }

        // Segundo dígito verificador
        int[] multiplicadores2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2}; 

        soma = 0;
        for (int index = 0; index < splittedCnpj.length - 1; index++) {
            int digito = Character.getNumericValue(splittedCnpj[index]);;
            soma += digito * multiplicadores2[index];
        }

        resto = soma % 11;
        verificadorCalculado = 11 - resto;
        if (verificadorCalculado >= 10) {
            verificadorCalculado = 0;
        }
        if (verificador2 != verificadorCalculado) {
            return false;
        }

        return true;
    }
}