import java.util.List;

public class Cliente {
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;

    // CONSTRUTOR
    public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;
    }

    // GETTERS
    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    // SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
}
