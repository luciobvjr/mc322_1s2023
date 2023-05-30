import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sinistro {
    private Integer id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    // CONSTRUCTOR
    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
        this.id = getRandomID();
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;
    }

    // GETTERS
    public Integer getId() {
        return this.id;
    }

    public Date getData() {
        return this.data;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataSinistroFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getData());

        String descricao = "";
        descricao += "Id: " + id + " | ";
        descricao += "Data: " + dataSinistroFormatada + " | ";
        descricao += "Endereço: " + endereco + " | ";
        descricao += "Condutor: " + condutor.getNome() + " | ";
        descricao += "Seguro: " + seguro.getId();
        return descricao;
    }

    // MÉTODOS PRIVADOS
    private Integer getRandomID() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}