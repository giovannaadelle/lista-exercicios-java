package exercicio8;

import java.math.BigDecimal;

class RetiradaNaLoja implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido p) {
        return BigDecimal.ZERO;
    }
}
