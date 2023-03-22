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

    // MÉTODOS PRIVADOS
    private boolean validarCPF(String cpf) {
        String numericCpf = cpf.replaceAll("/\\D+/g", cpf);

        if (numericCpf.length() < 11) {
            return false;
        }

        

        return true;
    }
}
