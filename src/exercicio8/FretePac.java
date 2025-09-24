package exercicio8;

import java.math.BigDecimal;

class FretePac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido p) {
        BigDecimal base = new BigDecimal("9.90");
        BigDecimal fatorPeso = p.getPesoKg().multiply(new BigDecimal("1.20"));
        return base.add(fatorPeso);
    }
}
