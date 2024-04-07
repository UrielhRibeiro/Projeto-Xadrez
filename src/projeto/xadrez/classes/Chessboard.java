package projeto.xadrez.classes;

import projeto.xadrez.classes.pecas.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Chessboard {
    private Player[] players;
    public final int size = 8;
    public Piece[][] pieces = new Piece[size][size];


    // === Construtor ===
    public Chessboard(Player p1, Player p2) {
       this.players = new Player[]{p1,p2};
    }

    // === Método para inicializar as peças ===
    public static void CreateAllPieces(Chessboard chessboard) throws Exception {
        Piece pawn = new Pawn(chessboard.players[0], 0, 0);
        chessboard.pieces[0][0] = pawn;
        System.out.println(chessboard.pieces[0][0].getClass().getName());
        Method m = chessboard.pieces[0][0].getClass().getMethod("getAllPossibleMoves", Chessboard.class);
        ArrayList<Pair<Integer, Integer>> vec = (ArrayList<Pair<Integer, Integer>>) m.invoke(chessboard.pieces[0][0], chessboard);
        for (var v : vec) {
            System.out.println(v.v1 + " | " + v.v2);
        }
    }

    // === Métodos Encapsuladores ===
    public Player[] getPlayers() {
        return players;
    }
}
