package Menu;

public enum MenuExcluir {
    VOLTAR(0),
    EXCLUIR_CLIENTE(1),
    EXCLUIR_VEICULO(1),
    EXCLUIR_SINISTRO(2);

    public final String operacao;

    private MenuExcluir(Integer operacao) {
        this.operacao = operacao.toString();
    }
}
