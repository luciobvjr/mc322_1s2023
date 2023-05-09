public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;

    // CONSTRUCTOR
    public Veiculo(String placa, String marca, String modelo, Integer anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // GETTERS
    public String getPlaca() {
        return this.placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    // SETTERS
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String descricao = "";
        descricao += "Placa: " + placa + " | ";
        descricao += "Marca: " + marca + " | ";
        descricao += "Modelo: " + modelo + " | ";
        descricao += "Ano de fabricação: " + anoFabricacao;
        return descricao;
    }
}
