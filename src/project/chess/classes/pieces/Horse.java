package project.chess.classes.pieces;

import project.chess.classes.Chessboard;
import project.chess.classes.Pair;
import project.chess.classes.Piece;
import project.chess.classes.Player;

import java.util.ArrayList;

public class Horse extends Piece {

    public Horse(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public void MovePiece(Chessboard chessboard, int pieceX, int pieceY) {

    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard) {
        return null;
    }
}
