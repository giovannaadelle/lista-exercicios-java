package exercicio5;

class Pix extends FormaPagamento {
    private final String chave;

    public Pix(String chave) {
        this.chave = chave;
    }

    @Override
    public void validarPagamento() {
        if (chave == null || chave.isBlank())
            throw new PagamentoInvalidoException("Chave Pix vazia");
        boolean ok = chave.matches(".+@.+\\..+") //email
                    || chave.matches("\\+?\\d{10,14}") //telefone
                    || chave.matches("\\d{11}"); // CPF
        if (!ok) throw new PagamentoInvalidoException("Formato de chave Pix inválido");
    }

}