package exercicio6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        Objects.requireNonNull(valor);
        Objects.requireNonNull(moeda);

        if(valor.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Valor não pode ser negativo");

        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro somar(Dinheiro outro) {
        BigDecimal valor1 = this.valor;
        BigDecimal valor2 = outro.valor;

        validarMesmaMoeda(outro);
        return new Dinheiro(valor1.add(valor2), moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        BigDecimal valor1 = this.valor;
        BigDecimal valor2 = outro.valor;

        validarMesmaMoeda(outro);

        BigDecimal resultado = valor1.subtract(valor2);
        if(resultado.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Resultado não pode ser negativo");
        }
        return new Dinheiro(resultado, moeda);
    }

    public Dinheiro multiplicar(int quantidade) {
        BigDecimal valor1 = this.valor;
        BigDecimal resultado = valor1.multiply(BigDecimal.valueOf(quantidade));
        return new Dinheiro(resultado, moeda);
    }

    private void validarMesmaMoeda(Dinheiro outro) {
        if (this.moeda != outro.moeda) {
            throw new IllegalArgumentException("Moedas diferentes");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinheiro d)) return false;
        BigDecimal valor1 = this.valor;
        BigDecimal valor2 = d.valor;
        return valor1.compareTo(valor2) == 0 && moeda == d.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor.stripTrailingZeros(), moeda);
    }

    @Override
    public String toString() {
        return moeda + " " + valor;
    }
}

