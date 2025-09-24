package exercicio5;

import java.math.BigDecimal;
import java.util.Objects;

abstract class FormaPagamento {
    public abstract void validarPagamento();
    public  String processarPagamento(BigDecimal valor) {
        Objects.requireNonNull(valor, "valor não pode ser nulo");
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagamentoInvalidoException("Valor deve ser maior que zero");
        }
        validarPagamento();
        return "Pagamento aprovado no valor de R$ " + valor;
    }
}
