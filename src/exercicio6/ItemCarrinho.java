package exercicio6;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (quantidade <= 0)
            throw new IllegalArgumentException("Quantidade deve ser > 0");
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto produto() { return produto; }
    public int quantidade() { return quantidade; }

    public Dinheiro subtotal() {
        return produto.getPreco().multiplicar(quantidade);
    }
}
