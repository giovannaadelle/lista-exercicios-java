package exercicio8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

final class Pedido {
    private final String cepDestino; // formato 00000-000 ou 00000000
    private final BigDecimal pesoKg; // >= 0
    private CalculadoraFrete estrategia;

    public Pedido(String cepDestino, BigDecimal pesoKg, CalculadoraFrete estrategia) {
        if (cepDestino == null || !cepDestino.matches("\\d{5}-?\\d{3}"))
            throw new CepInvalidoException("CEP inválido");
        if (pesoKg == null || pesoKg.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("peso inválido");
        this.cepDestino = cepDestino.replace("-", "");
        this.pesoKg = pesoKg.setScale(2, RoundingMode.HALF_EVEN);
        this.estrategia = Objects.requireNonNull(estrategia);
    }

    public String getCepDestino() { return cepDestino; }
    public BigDecimal getPesoKg() { return pesoKg; }
    public void setEstrategia(CalculadoraFrete estrategia) { this.estrategia = Objects.requireNonNull(estrategia); }

    public BigDecimal calcularFrete() {
        return estrategia.calcular(this).setScale(2, RoundingMode.HALF_EVEN);
    }
}