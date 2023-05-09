import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sinistro {
    private Integer id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    // CONSTRUCTOR
    public Sinistro(Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = getRandomID();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
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

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
    public Cliente getCliente() {
        return cliente;
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

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataSinistroFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getData());

        String descricao = "";
        descricao += "Id: " + id + " | ";
        descricao += "Data: " + dataSinistroFormatada + " | ";
        descricao += "Endereço: " + endereco + " | ";
        descricao += "Seguradora: " + seguradora.getNome() + " | ";
        descricao += "Veículo: " + veiculo.getMarca() + " " + veiculo.getModelo() + ", Placa: " + veiculo.getPlaca() + " | ";
        descricao += "Cliente: " + cliente.getNome(); 
        return descricao;
    }

    // MÉTODOS PRIVADOS
    private Integer getRandomID() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}