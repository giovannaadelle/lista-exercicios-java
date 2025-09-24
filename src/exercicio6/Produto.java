package exercicio6;


    public final class Produto {
        private final String id;
        private final String nome;
        private final Dinheiro preco;

        public Produto(String id, String nome, Dinheiro preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }

        public String getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public Dinheiro getPreco() {
            return preco;
        }

    }







