package projeto.xadrez.classes.pecas;

import projeto.xadrez.classes.*;

import java.util.ArrayList;

public class Horse extends Piece {

    public int x = 10;

    public Horse(Player player, int x, int y) {
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
