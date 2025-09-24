package exercicio1e2;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior ou igual a zero");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a zero");
        }
        this.quantidade = quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade: " + this.quantidade);
    }

    //metodo pra aplicar desconto
    public void aplicarDesconto(double porcentagem) {
        if(porcentagem < 0 || porcentagem > 50) {
            throw new DescontoInvalidoException("Porcentagem do desconto inválida");
        }

        double valorDesconto = preco * (porcentagem / 100);
        this.preco -= valorDesconto;
    }

    public static void main(String[] args) {
//        try {
//            Produto produto = new Produto("Beijinho", 2.50, 3);
//            Produto produto2 = new Produto("Brigadeiro", 3.50, 5);
//            produto.exibirInformacoes();
//            produto2.exibirInformacoes();
//        } catch (IllegalArgumentException ex) {
//            ex.printStackTrace();
//        }
//
//        try {   //validação
//            Produto produtoInvalido = new Produto("", 600, 1);
//        } catch (IllegalArgumentException ex) {
//            System.out.println(ex.getMessage());
//        }

        try {
            Produto produto3 = new Produto("Camafeu", 4.20, 7);
            System.out.println("Antes do desconto: ");
            produto3.exibirInformacoes();
            System.out.println("Depois do desconto: ");
            produto3.aplicarDesconto(30);
            produto3.exibirInformacoes();
        } catch (DescontoInvalidoException ex) {
            System.out.println(ex.getMessage());
        }
    }
}