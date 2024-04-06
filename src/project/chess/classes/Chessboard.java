package project.chess.classes;

import project.chess.classes.pieces.Peon;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Chessboard {
    public final int size = 8;
    private Player[] players;
    public Piece[][] pieces = new Piece[8][8];

    public Chessboard(Player p1, Player p2) throws Exception {
        players = new Player[]{p1, p2};
        CreateAllPieces(this);
    }

    //vai iniciar criando todas as pecas em sua posicao de origem
    public static void CreateAllPieces(Chessboard obj) throws Exception {
        Peon peao = new Peon(obj.players[0], 0, 0);
        obj.pieces[0][0] = peao;
        System.out.println(obj.pieces[0][0].getClass().getName());
        Method m = obj.pieces[0][0].getClass().getMethod("getAllPossibleMoves", Chessboard.class);
        ArrayList<Pair<Integer, Integer>> vec = (ArrayList<Pair<Integer, Integer>>) m.invoke(obj.pieces[0][0], obj);
        for (var v : vec) {
            System.out.println(v.v1 + " | " + v.v2);
        }
        //implentar a acao proposta pelo metodo
    }
}
