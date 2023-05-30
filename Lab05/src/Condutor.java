import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Condutor extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;

    // CONSTRUTOR
    public Condutor(String nome, String endereco, String telefone, String email, String cpf, Date dataNascimento,
            ArrayList<Sinistro> listaSinistros) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = listaSinistros;
    }

    // GETTERS
    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    // SETTERS
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    // MÉTODOS PÚBLICOS
    @Override
    public String toString() {
        String dataNascimentoFormadata = new SimpleDateFormat("dd/MM/yyyy").format(getDataNascimento());

        String listaSinistrosFormatada = "Vazio";
        if (!getListaSinistros().isEmpty()) {
            listaSinistrosFormatada = "";
            ArrayList<String> listaSinistroID = new ArrayList<String>();
            for (Sinistro sinistro : getListaSinistros()) {
                listaSinistroID.add(sinistro.getId().toString());
            }
            listaSinistrosFormatada = String.join(", ", listaSinistroID);
        }

        String descricao = "";
        descricao += "Nome: " + getNome() + " | ";
        descricao += "CPF: " + getCpf() + " | ";
        descricao += "Data de nascimento: " + dataNascimentoFormadata + " | ";
        descricao += "Endereço: " + getEndereco() + " | ";
        descricao += "Telefone: " + getTelefone() + " | ";
        descricao += "Email: " + getEmail() + " | ";
        descricao += "Lista de Sinistros: " + listaSinistrosFormatada + " | ";
        return descricao;
    }

    // Adiciona um novo sinitro ao condutor.
    // - Entrada: Objeto do sinistro a ser adicionado
    // - Retorna: 'true' se o sinistro foi adicionado com sucesso e 'false' caso
    // contrário
    public boolean adicionarSinistro(Sinistro sinistro) {
        return this.listaSinistros.add(sinistro);
    }
}