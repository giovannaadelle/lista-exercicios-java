package exercicio7;

public class Funcionario implements Identificavel<String>{
    private final String id;
    private final String nome;
    private final String cargo;

    public Funcionario(String id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCargo() {
        return this.cargo;
    }



}
