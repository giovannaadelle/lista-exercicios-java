package exercicio5;

class Boleto extends FormaPagamento {
    private final String linhaDigitavel;

    public Boleto(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    @Override
    public void validarPagamento() {
        if (linhaDigitavel == null
                || linhaDigitavel.length() < 40
                || linhaDigitavel.length() > 48
                || !soContemDigitos(linhaDigitavel)) {
            throw new PagamentoInvalidoException("Código do boleto é inválido");
        }
    }

    private boolean soContemDigitos(String x) {
        for(int i = 0; i < x.length(); i++) {
            if (!Character.isDigit(x.charAt(i))) {
                return false;
            }
        }
        return true;
        }


}
