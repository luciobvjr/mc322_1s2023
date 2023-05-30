import java.util.ArrayList;

public class Frota {
    String code;
    ArrayList<Veiculo> listaVeiculos;

    // CONSTRUTOR
    public Frota(String code, ArrayList<Veiculo> listaVeiculos) {
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }

    // GETTERS
    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    // SETTERS
    public void setCode(String code) {
        this.code = code;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        ArrayList<String> placasVeiculos = new ArrayList<String>();
        for (Veiculo veiculo : getListaVeiculos()) {
            placasVeiculos.add(veiculo.getPlaca());
        }
        String placasVeiculosFormatada = String.join(", ", placasVeiculos);

        String descricao = "";
        descricao += "Código da frota: " + code + " | ";
        descricao += "Lista de veículos: " + placasVeiculosFormatada;
        return descricao;
    }
}
