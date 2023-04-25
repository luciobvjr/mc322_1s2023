import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
    private final String cpf;
    private String genero;
    private Date dataLicenca;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;

    // CONSTRUTOR
    public ClientePF(String nome, String endereco, List<Veiculo> listaVeiculos, String cpf, String genero, 
                     Date dataLicenca, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco, listaVeiculos);
        this.cpf = cpf;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
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
    
    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataNascimentoFormadata = new SimpleDateFormat("dd-MM-yyyy").format(getDataNascimento());
        String dataLicencaFormatada = new SimpleDateFormat("dd-MM-yyyy").format(getDataLicenca());

        String descricao = "";
        descricao += "Nome: " + getNome() + "\n";
        descricao += "CPF: " + getCpf() + "\n";
        descricao += "Gênero: " + getGenero() + "\n";
        descricao += "Data de nascimento: " + dataNascimentoFormadata + "\n";
        descricao += "Endereço: " + getEndereco() + "\n";
        descricao += "Lista de veículos: " + getListaVeiculos() + "\n";
        descricao += "Data de licença: " + dataLicencaFormatada + "\n";
        descricao += "Educação: " + getEducacao() + "\n";
        descricao += "Classe econômica: " + getClasseEconomica() + "\n";
        return descricao;
    }

    // Verifica se o CPF é válido (Tem 11 dígitos que não são todos iguais e os dígitos verificadores são válidos).
    // - Entrada: String representando um CPF. Os caracteres não numéricos são descartados
    // - Retorna: 'true' o CPF é válido e 'false' caso contrário
    static public boolean validarCPF(String cpf) {
        String numericCpf = cpf.replaceAll("[^0-9]", "");

        return cpfTemOnzeDigitos(numericCpf) && !cpfTemTodosDigitosIguais(numericCpf) && digitoVerificadorValido(numericCpf);
    }

    // MÉTODOS PRIVADOS

    // Verifica se o CPF tem exatamente 11 dígitos.
    // - Entrada: String representando um CPF apenas com caracteres numéricos
    // - Retorna: 'true' se possui 11 dígitos e 'false' caso contrário
    static private boolean cpfTemOnzeDigitos(String numericCpf) {
        if (numericCpf.length() == 11) {
            return true;
        }

        return false;
    }

    // Verifica se todos os dígitos do CPF são iguais.
    // - Entrada: String representando um CPF apenas com caracteres numéricos
    // - Retorna 'true' se todos os dígitos são iguais e 'false' caso contrário
    static private boolean cpfTemTodosDigitosIguais(String numericCpf) {
        char[] splittedCpf = numericCpf.toCharArray();
        for (char digit1 : splittedCpf) {
            for (char digit2 : splittedCpf) {
                if (digit1 != digit2) {
                    return false;
                }
            }
        }

        return true;
    }

    // Verifica se os dígitos verificadores do CPF são válidos.
    // - Entrada: String representando um CPF apenas com caracteres numéricos
    // - Retorna 'true' se os dígitos verificadores são válidos e 'false' caso contrário
    static private boolean digitoVerificadorValido(String numericCpf) {
        char[] splittedCpf = numericCpf.toCharArray();
        int verificador1 = Character.getNumericValue(splittedCpf[splittedCpf.length - 2]);
        int verificador2 = Character.getNumericValue(splittedCpf[splittedCpf.length - 1]);

        // Primeiro dígito verificador
        int soma = 0;
        int multiplicador = 10;
        for (int index = 0; index < splittedCpf.length - 2; index++) {
            int digito = Character.getNumericValue(splittedCpf[index]);
            soma += digito * multiplicador;

            multiplicador--;
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
        soma = 0;
        multiplicador = 11;
        for (int index = 0; index < splittedCpf.length - 1; index++) {
            int digito = Character.getNumericValue(splittedCpf[index]);;
            soma += digito * multiplicador;

            multiplicador--;
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
