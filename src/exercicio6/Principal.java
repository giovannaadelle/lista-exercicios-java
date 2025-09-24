package exercicio6;

import java.math.BigDecimal;

public class Principal {
    public static void main(String[] args) {
        Produto p1 = new Produto("1", "Livro", new Dinheiro(new BigDecimal("50"), Moeda.BRL));
        Produto p2 = new Produto("2", "Mouse", new Dinheiro(new BigDecimal("120"), Moeda.BRL));

        Carrinho c1 = Carrinho.vazio()
                .adicionar(new ItemCarrinho(p1, 2))
                .adicionar(new ItemCarrinho(p2, 1));

        Carrinho c2 = c1.aplicarCupom(new BigDecimal("0.40")); // limitado a 30%

        System.out.println("Total sem cupom: " + c1.total());
        System.out.println("Total com cupom: " + c2.total());
    }
}
