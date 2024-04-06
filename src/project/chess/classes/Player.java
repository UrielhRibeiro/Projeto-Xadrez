package project.chess.classes.*;

public class Player {
    private static int countOfPlayer = 1;
    private final int id = countOfPlayer;
    private String name;

    public Player(String name) {
        countOfPlayer++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
