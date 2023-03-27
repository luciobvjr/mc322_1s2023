public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private Integer idade;
    private String endereco;

    // CONSTRUCTOR
    public Cliente(String nome, String cpf, String dataNascimento, Integer idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;    
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
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // MÉTODOS ESTÁTICOS
    static public boolean validarCPF(String cpf) {
        String numericCpf = cpf.replaceAll("/\\D+/g", cpf);

        return cpfTemOnzeDigitos(numericCpf) && !cpfTemTodosDigitosIguais(numericCpf) && digitoVerificadorValido(numericCpf);
    }

    // MÉTODOS PRIVADOS
    static private boolean cpfTemOnzeDigitos(String numericCpf) {
        if (numericCpf.length() == 11) {
            return false;
        }

        return true;
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
        int verificador1 = splittedCpf[splittedCpf.length - 2];
        int verificador2 = splittedCpf[splittedCpf.length - 1];

        // Primeiro dígito verificador
        int soma = 0;
        int multiplicador = 10;
        for (int index = 0; index < splittedCpf.length - 3; index++) {
            int digito = splittedCpf[index];
            soma += digito * multiplicador;

            multiplicador--;
        }

        int resto = soma % 11;
        if (verificador1 != 11 - resto) {
            return false;
        }

        // Segundo dígito verificador
        soma = 0;
        multiplicador = 11;
        for (int index = 0; index < splittedCpf.length - 2; index++) {
            int digito = splittedCpf[index];
            soma += digito * multiplicador;

            multiplicador--;
        }

        resto = soma % 11;
        if (verificador2 != 11 - resto) {
            return false;
        }

        return true;
    }
}
