package Menu;

public enum MenuListar {
    VOLTAR(0),
    LISTAR_CLIENTES_GERAL(1),
    LISTAR_CLIENTES_PF(2),
    LISTAR_CLIENTES_PJ(3),
    LISTAR_SINISTROS(4);

    public final String operacao;

    private MenuListar(Integer operacao) {
        this.operacao = operacao.toString();
    }
}