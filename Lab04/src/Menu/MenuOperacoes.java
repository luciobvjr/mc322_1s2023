package Menu;

public enum MenuOperacoes {
    SAIR(0),
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA(6);

    public final String operacao;

    private MenuOperacoes(Integer operacao) {
        this.operacao = operacao.toString();
    }
}