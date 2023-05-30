import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Seguro {
    private final Integer id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private Double valorMensal;

    // CONSTRUTOR
    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora, ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, Double valorMensal) {
        this.id = getRandomID();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = listaSinistros;
        this.listaCondutores = listaCondutores;
        this.valorMensal = valorMensal;
    }

    // GETTERS
    public Integer getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public Double getValorMensal() {
        return valorMensal;
    }

    // SETTERS
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public void setValorMensal(Double valorMensal) {
        this.valorMensal = valorMensal;
    }

    // MÉTODOS PÚBLICOS
    //public abstract boolean autorizarCondutor(Condutor condutor);
    //public abstract boolean desautorizarCondutor(Condutor condutor);
    public abstract boolean calcularValor();
    //public abstract boolean gerarSinistro(Sinistro sinistro);

    @Override
    public String toString() {
        String dataInicioFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getDataInicio());
        String dataFimFormatada = new SimpleDateFormat("dd/MM/yyyy").format(getDataFim());

        String listaSinistrosFormatada = "Vazio";
        if (!getListaSinistros().isEmpty()) {
            listaSinistrosFormatada = "";
            ArrayList<String> listaSinistroID = new ArrayList<String>();
            for (Sinistro sinistro : getListaSinistros()) {
                listaSinistroID.add(sinistro.getId().toString());
            }
            listaSinistrosFormatada = String.join(", ", listaSinistroID);
        }

        String listaCondutoresFormatada = "Vazio";
        if (!getListaCondutores().isEmpty()) {
            listaCondutoresFormatada = "";
            ArrayList<String> listaCondutores = new ArrayList<String>();
            for (Condutor condutor : getListaCondutores()) {
                listaCondutores.add(condutor.getNome());
            }
            listaCondutoresFormatada = String.join(", ", listaCondutores);
        }

        String descricao = "";
        descricao += "ID: " + getId() + " | ";
        descricao += "Data de início: " + dataInicioFormatada + " | ";
        descricao += "Data de fim: " + dataFimFormatada + " | ";
        descricao += "Seguradora: " + getSeguradora().getNome() + " | ";
        descricao += "Lista de sinistros: " + listaSinistrosFormatada + " | ";
        descricao += "Lista de Condutores: " + listaCondutoresFormatada + " | ";
        descricao += "Valor mensal: " + getValorMensal();
        return descricao;
    }

    // MÉTODOS PRIVADOS
    private Integer getRandomID() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}
