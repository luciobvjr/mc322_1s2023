import java.util.ArrayList;
import java.util.Date;

public class SeguroPJ extends Seguro {
    Frota frota;
    ClientePJ cliente;

    // CONSTRUTOR
    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, 
                    ArrayList<Condutor> listaCondutores, Double valorMensal, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    // GETTERS
    public Frota getFrota() {
        return frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    // SETTERS
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    
    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String descricao = super.toString();
        descricao += " | ";
        descricao += "Código da frota: " + frota.getCode() + " | ";
        descricao += "CNPJ do Cliente: " + cliente.getCnpj() + " | ";
        return descricao;
    }

    @Override
    public boolean calcularValor() {
        Integer idade = cliente.calcularIdade();

        Integer sinistrosCondutores = 0;
        for (Condutor condutor : getListaCondutores()) {
            sinistrosCondutores += condutor.getListaSinistros().size();
        }

        Double valor = CalcSeguro.VALOR_BASE.value;
        valor *= (10 + cliente.getQtdeFuncionarios() / 10);
        // TODO: BASEADO NA QUANTIDADE DE VEÍCULOS
        valor *= (1 + 1/(idade + 2));
        valor *= (2 + (cliente.getListaSinistros().size() / 10));
        valor *= (5 + (sinistrosCondutores / 10));
        return false;
    }
}
