import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    // CONSTRUTOR
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, 
                    ArrayList<Condutor> listaCondutores, Integer valorMensal, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    // GETTERS
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    // SETTERS
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String descricao = super.toString();
        descricao += " | ";
        descricao += "Veículo: " + veiculo.getPlaca() + " | ";
        descricao += "CPF do Cliente: " + cliente.getCpf() + " | ";
        return descricao;
    }
}
