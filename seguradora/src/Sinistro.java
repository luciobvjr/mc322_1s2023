import java.util.Random;

public class Sinistro {
    Integer id;
    String data;
    String endereco;

    // INITIALIZER
    public Sinistro(String data, String endereco) {
        Random random = new Random();
        this.id = random.nextInt();
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
}