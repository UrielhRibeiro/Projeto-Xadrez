package projeto.xadrez.classes;

public class Player {
    private static int countOfPlayer = 0;
    private final int id = countOfPlayer + 1;
    private String name;

    // === Construtor ===
    public Player(String name) {
        countOfPlayer++;
        this.name = name;
    }

    // === Métodos Encapsuladores ===
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
