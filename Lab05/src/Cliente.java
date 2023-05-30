import java.util.List;

public abstract class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Veiculo> listaVeiculos;
    private double valorSeguro;

    // CONSTRUTOR
    public Cliente(String nome, String endereco, String telefone, List<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.listaVeiculos = listaVeiculos;
    }

    // GETTERS
    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public double calculaScore() {
        this.valorSeguro = CalcSeguro.VALOR_BASE.value;
        return this.valorSeguro;
    }
}