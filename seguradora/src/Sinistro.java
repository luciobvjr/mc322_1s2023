import java.util.Random;

public class Sinistro {
    private Integer id;
    private String data;
    private String endereco;

    // CONSTRUCTOR
    public Sinistro(String data, String endereco) {
        this.id = getRandomID();
        this.data = data;
        this.endereco = endereco;
    }

    // GETTERS
    public Integer getId() {
        return this.id;
    }

    public String getData() {
        return this.data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // MÉTODOS PRIVADOS
    private Integer getRandomID() {
        Random random = new Random();
        return random.nextInt();
    }
}