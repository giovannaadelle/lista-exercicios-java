package exercicio5;

import java.math.BigDecimal;

public class Principal {
    public static void main (String[] args) {
        FormaPagamento cartao = new CartaoCredito("47287408384920");
        FormaPagamento boleto = new Boleto("00190500954014481606906809835031433737000001009");
        FormaPagamento pix = new Pix("15991813859");

        for (FormaPagamento f : new FormaPagamento[]{cartao, boleto, pix}) {
            try {
                String comprovante = f.processarPagamento(new BigDecimal("180.90"));
                System.out.println(comprovante);
            } catch (PagamentoInvalidoException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }
        }
    }
}
