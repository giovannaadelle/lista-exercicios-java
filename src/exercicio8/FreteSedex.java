package exercicio8;

import java.math.BigDecimal;

class FreteSedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido p) {
        int regiao = Character.getNumericValue(p.getCepDestino().charAt(0));
        BigDecimal base = new BigDecimal("18.90");
        BigDecimal fatorRegiao = BigDecimal.valueOf(1 + (regiao * 0.05));
        BigDecimal fatorPeso = p.getPesoKg().multiply(new BigDecimal("2.50"));
        return base.multiply(fatorRegiao).add(fatorPeso);
    }
}
