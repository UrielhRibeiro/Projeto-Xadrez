package project.chess.classes.pieces;

import project.chess.classes.Chessboard;
import project.chess.classes.Pair;
import project.chess.classes.Piece;
import project.chess.classes.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Peon extends Piece {
    private boolean isFirstMove = true;

    public Peon(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public void MovePiece(Chessboard chessboard, int pieceX, int pieceY) {
        isFirstMove = false;
    }

    public Piece transformTo(String type) throws Exception, InstantiationException,
            IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        String path = "project.chess.classes.pieces.";
        if (type.equals("Peao") || type.equals("King"))
            throw new Exception();
        Constructor<?> pieceConstructor = Class.forName(path + type).getConstructor(Player.class, int.class, int.class);
        return (Piece) pieceConstructor.newInstance(this.piecePlayer, x, y);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard) {
        ArrayList<Pair<Integer, Integer>> vec = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            //vai verificar se nao tem alguma peca na frente do peao
            if (chessboard.pieces[x][y + i] != null)
                break;
            var e = new Pair<Integer, Integer>(x, y + i);
            vec.add(e);
            if (!isFirstMove)
                break;
        }
        if ((x + walkDirection <= chessboard.size && y + walkDirection >= chessboard.size)
                && (chessboard.pieces[x + walkDirection][y + walkDirection] != null)) {
            var e = new Pair<Integer, Integer>(x + walkDirection, y + walkDirection);
            vec.add(e);
        }
        if ((x - walkDirection >= 0 && y + walkDirection >= chessboard.size)
                && (chessboard.pieces[x - walkDirection][y + walkDirection] != null)) {
            var e = new Pair<Integer, Integer>(x - walkDirection, y + walkDirection);
            vec.add(e);
        }
        return vec;
    }

    public boolean getIfIsFirstMove() {
        return isFirstMove;
    }
}
