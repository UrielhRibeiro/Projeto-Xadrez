package project.chess.*;

import project.chess.classes.Chessboard;
import project.chess.classes.Player;

public class Main {
    public static void main(String[] args) throws Exception {
        Player p = new Player("teste");
        Player p2 = new Player("teste2");
        Chessboard c = new Chessboard(p, p2);
    }
}
