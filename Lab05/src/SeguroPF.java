import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    // CONSTRUTOR
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros,
            ArrayList<Condutor> listaCondutores, Double valorMensal, Veiculo veiculo, ClientePF cliente) {
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

    @Override
    public boolean calcularValor() {
        Integer idade = cliente.calcularIdade();

        Double fatorIdade = CalcSeguro.FATOR_30_60.value;
        if (idade < 30) {
            fatorIdade = CalcSeguro.FATOR_18_30.value;
        } else if (idade > 60) {
            fatorIdade = CalcSeguro.FATOR_60_90.value;
        }

        Integer sinistrosCondutores = 0;
        for (Condutor condutor : getListaCondutores()) {
            sinistrosCondutores += condutor.getListaSinistros().size();
        }

        Double valor = CalcSeguro.VALOR_BASE.value * fatorIdade;
        valor *= (1 + 1 / cliente.getListaVeiculos().size() + 2);
        valor *= (2 + cliente.getListaSinistros().size() / 10);
        valor *= (5 + sinistrosCondutores / 10);

        this.setValorMensal(valor);
        return true;
    }
}
