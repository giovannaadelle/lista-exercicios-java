package exercicio5;

class CartaoCredito extends FormaPagamento {
    private final String numero;

    public CartaoCredito(String numero) {
        this.numero = numero;
    }

    @Override
    public void validarPagamento() {
        if (numero == null || numero.length() < 13 || numero.length() > 19 || !soContemDigitos(numero))
            throw new PagamentoInvalidoException("Número do cartão inválido");
    }

    private boolean soContemDigitos(String x) {
        for(int i = 0; i < x.length(); i++) {
            if(!Character.isDigit(x.charAt(i))){
                return false;
            }
        }
        return true;
    }


    }




