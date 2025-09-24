package exercicio1e2;

// classe customizada para o desconto
class DescontoInvalidoException extends IllegalArgumentException {
    public DescontoInvalidoException (String mensagem) {
        super(mensagem);
    }
}

