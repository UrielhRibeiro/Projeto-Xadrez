package projeto.xadrez.classes;

public class Player {
    private String nome;
    private int idade;

    // === Construtor ===
    public Player(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // === Métodos Encapsuladores ===
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
