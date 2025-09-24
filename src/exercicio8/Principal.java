package exercicio8;

import java.math.BigDecimal;

class Principal {
    public static void main(String[] args) {
        CalculadoraFrete sedex = new FreteSedex();
        CalculadoraFrete pac   = new FretePac();
        CalculadoraFrete loja  = new RetiradaNaLoja();

        Pedido pedido = new Pedido("13083-852", new BigDecimal("3.4"), sedex);
        System.out.println("SEDEX: R$ " + pedido.calcularFrete());

        pedido.setEstrategia(pac);
        System.out.println("PAC: R$ " + pedido.calcularFrete());

        // Lambda promocional
        BigDecimal X = new BigDecimal("200.00");
        CalculadoraFrete promo = p -> {
            return p.getPesoKg().compareTo(new BigDecimal("1.00")) < 0 ? BigDecimal.ZERO : new BigDecimal("12.00");
        };
        pedido.setEstrategia(promo);
        System.out.println("Promo: R$ " + pedido.calcularFrete());

        pedido.setEstrategia(loja);
        System.out.println("Retirada na loja: R$ " + pedido.calcularFrete());
}}


