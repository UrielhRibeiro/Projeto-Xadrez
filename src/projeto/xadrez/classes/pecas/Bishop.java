package projeto.xadrez.classes.pecas;

import projeto.xadrez.classes.Chessboard;
import projeto.xadrez.classes.Pair;
import projeto.xadrez.classes.Piece;
import projeto.xadrez.classes.Player;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public void MovePiece(Chessboard chessboard, int pieceX, int pieceY) {
        setFirstMoveToFalse();
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard) {
        return null;
    }
}
