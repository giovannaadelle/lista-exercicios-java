package exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal cupom; //

    private Carrinho(List<ItemCarrinho> itens, BigDecimal cupom) {
        this.itens = List.copyOf(itens);
        this.cupom = cupom;
    }

    public static Carrinho vazio() {
        return new Carrinho(List.of(), BigDecimal.ZERO);
    }

    public Carrinho adicionar(ItemCarrinho item) {
        List<ItemCarrinho> nova = new ArrayList<>(itens);
        nova.add(item);
        return new Carrinho(nova, cupom);
    }

    public Carrinho remover(String idProduto) {
        List<ItemCarrinho> nova = new ArrayList<>(itens);
        if (!nova.removeIf(i -> i.produto().getId().equals(idProduto)))
            throw new NoSuchElementException("Produto não encontrado");
        return new Carrinho(nova, cupom);
    }

    public Carrinho aplicarCupom(BigDecimal percentual) {
        if (percentual.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Cupom inválido");
        BigDecimal limite = new BigDecimal("0.30");
        BigDecimal aplicado = percentual.min(limite).setScale(2, RoundingMode.HALF_EVEN);
        return new Carrinho(itens, aplicado);
    }

    public Dinheiro total() {
        if (itens.isEmpty()) return new Dinheiro(BigDecimal.ZERO, Moeda.BRL);

        Moeda moeda = itens.get(0).produto().getPreco().getMoeda();
        Dinheiro soma = new Dinheiro(BigDecimal.ZERO, moeda);
        for (ItemCarrinho i : itens) soma = soma.somar(i.subtotal());

        if (cupom.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal fator = BigDecimal.ONE.subtract(cupom);
            return new Dinheiro(soma.getValor().multiply(fator), moeda);
        }
        return soma;
    }
}

