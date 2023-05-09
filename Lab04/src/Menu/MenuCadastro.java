package Menu;

public enum MenuCadastro {
    VOLTAR(0),
    CADASTRAR_CLIENTE_PF(1),
    CADASTRAR_CLIENTE_PJ(2),
    CADASTRAR_VEICULO(3),
    CADASTRAR_SEGURADORA(4);

    public final String operacao;

    private MenuCadastro(Integer operacao) {
        this.operacao = operacao.toString();
    }
}