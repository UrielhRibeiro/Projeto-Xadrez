package projeto.xadrez.classes;

import projeto.xadrez.classes.pecas.*;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Chessboard {

    private Player[] players;
    public final int size = 8;
    public Piece[][] pieces = new Piece[size][size];

    // === Construtor ===
    public Chessboard(Player p1, Player p2) throws Exception {
       this.players = new Player[]{p1,p2};
       createAllPieces(this);
    }

    // === Método para inicializar as peças ===
    public static void createAllPieces(Chessboard chessboard)  {
        Piece peca;
        int y = 0, y2 = 1;
        for(int p = 0; p<2; p++ ){
            peca = new Tower( chessboard.getPlayers()[p], 0, y);
            chessboard.pieces[0][y] = peca;

            peca = new Horse( chessboard.getPlayers()[p], 1, y);
            chessboard.pieces[1][y] = peca;

            peca = new Bishop( chessboard.getPlayers()[p], 2, y);
            chessboard.pieces[2][y] = peca;

            peca = new Queen( chessboard.getPlayers()[p], 3, y);
            chessboard.pieces[3][y] = peca;

            peca = new King( chessboard.getPlayers()[p], 4, y);
            chessboard.pieces[4][y] = peca;

            peca = new Bishop( chessboard.getPlayers()[p], 5, y);
            chessboard.pieces[5][y] = peca;

            peca = new Horse( chessboard.getPlayers()[p], 6, y);
            chessboard.pieces[6][y] = peca;

            peca = new Tower( chessboard.getPlayers()[p], 7, y);
            chessboard.pieces[7][y] = peca;

            for(int i=0; i < chessboard.size; i++){
                peca = new Pawn( chessboard.getPlayers()[p], i, y2);
                chessboard.pieces[i][y2] = peca;
            }

            y += 7;
            y2 += 5;
        }
    }

    // === Métodos Encapsuladores ===
    public Player[] getPlayers() {
        return players;
    }
}
