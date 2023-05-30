import java.util.regex.Pattern;

public class Validacao {
        // Verifica se o CPF é válido (Tem 11 dígitos que não são todos iguais e os dígitos verificadores são válidos).
    // - Entrada: String representando um CPF. Os caracteres não numéricos são descartados
    // - Retorna: 'true' o CPF é válido e 'false' caso contrário
    static public boolean validarCPF(String cpf) {
        String numericCpf = cpf.replaceAll("[^0-9]", "");

        return cpfTemOnzeDigitos(numericCpf) && !docTemTodosDigitosIguais(numericCpf) && digitoVerificadorValidoCPF(numericCpf);
    }

    // Verifica se o CNPJ é válido (Tem 14 dígitos que não são todos iguais e os dígitos verificadores são válidos).
    // - Entrada: String representando um CNPJ. Os caracteres não numéricos são descartados
    // - Retorna: 'true' o CNPJ é válido e 'false' caso contrário
    static public boolean validarCNPJ(String cnpj) {
        String numericCnpj = cnpj.replaceAll("[^0-9]", "");

        return cnpjTemQuatorzeDigitos(numericCnpj) && !docTemTodosDigitosIguais(numericCnpj) && digitoVerificadorValidoCNPJ(numericCnpj);
    }

    // Verifica se o nome é válido (Tem apenas letras e espaços).
    // - Entrada: String representando um nome
    // - Retorna: 'true' o nome é válido e 'false' caso contrário
    static public boolean validarNomePF(String nome) {
        if (nome.isBlank()) {
            return false;
        }

        char[] charArray = nome.toCharArray();
        for (char ch : charArray) {
            if (!Character.isLetter(ch) && !Character.isSpaceChar(ch)) {
                return false;
            }
        }
        return true;
    }

    // Verifica se o endereço de email é válido.
    // - Entrada: String representando um endereço de email
    // - Retorna: 'true' o email é válido e 'false' caso contrário
    static public boolean validarEmail(String email) {
        if (email.isBlank()) {
            return false;
        }

        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        return Pattern.compile(regexPattern)
                    .matcher(email)
                    .matches();
    }

    // Verifica se o número de telefone é válido. (Possui apenas números)
    // - Entrada: String representando um número de telefone
    // - Retorna: 'true' o número de telefone é válido e 'false' caso contrário
    static public boolean validarTelefone(String telefone) {
        if (telefone.isBlank()) {
            return false;
        }

        char[] charArray = telefone.toCharArray();
        for (char ch : charArray) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
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

        // Verifica se o CNPJ tem exatamente 14 dígitos.
    // - Entrada: String representando um CNPJ apenas com caracteres numéricos
    // - Retorna: 'true' se possui 14 dígitos e 'false' caso contrário
    static private boolean cnpjTemQuatorzeDigitos(String numericCnpj) {
        if (numericCnpj.length() == 14) {
            return true;
        }

        return false;
    }

    // Verifica se todos os dígitos do CPF são iguais.
    // - Entrada: String representando um documento apenas com caracteres numéricos
    // - Retorna 'true' se todos os dígitos são iguais e 'false' caso contrário
    static private boolean docTemTodosDigitosIguais(String numericDoc) {
        char[] splittedCpf = numericDoc.toCharArray();
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
    static private boolean digitoVerificadorValidoCPF(String numericCpf) {
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

    // Verifica se os dígitos verificadores do CNPJ são válidos.
    // - Entrada: String representando um CNPJ apenas com caracteres numéricos
    // - Retorna: 'true' se os dígitos verificadores são válidos e 'false' caso contrário
    static private boolean digitoVerificadorValidoCNPJ(String numericCnpj) {
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
