import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Integer idade;
    private String endereco;

    // CONSTRUCTOR
    public Cliente(String nome, String cpf, String dataNascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;   
        
        configurarIdadeAPartirDoAniversário();
    }

    // GETTERS
    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public Integer getIdade() {
        return this.idade;
    }

    public String getEndereco() {
        return this.endereco;
    }
    
    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        configurarIdadeAPartirDoAniversário();
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // MÉTODOS PÚBLICOS
    static public boolean validarCPF(String cpf) {
        String numericCpf = cpf.replaceAll("[^0-9]", "");

        return cpfTemOnzeDigitos(numericCpf) && !cpfTemTodosDigitosIguais(numericCpf) && digitoVerificadorValido(numericCpf);
    }

    @Override
    public String toString() {
        String descricao = "";
        descricao += "Nome: " + nome + "\n";
        descricao += "CPF: " + cpf + "\n";
        descricao += "Data de nascimento: " + dataNascimento + "\n";
        descricao += "Idade: " + idade + "\n";
        descricao += "Endereço: " + endereco + "\n";
        return descricao;
    }

    // MÉTODOS PRIVADOS
    private void configurarIdadeAPartirDoAniversário() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        try {
            LocalDate dataFormatada = formato.parse(this.dataNascimento).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
            LocalDate dataAtual = LocalDate.now();
            Period periodo = Period.between(dataFormatada, dataAtual);
            this.idade = periodo.getYears();
        } catch (ParseException e) {
            this.idade = null;
        } 
    }

    static private boolean cpfTemOnzeDigitos(String numericCpf) {
        if (numericCpf.length() == 11) {
            return true;
        }

        return false;
    }

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
