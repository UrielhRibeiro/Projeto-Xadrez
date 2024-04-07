package projeto.xadrez.classes.pecas;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import projeto.xadrez.Enum.*;
import projeto.xadrez.classes.*;

public class Pawn extends Piece {

    public Pawn(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public void MovePiece(Chessboard chessboard, int pieceX, int pieceY) {
        setFirstMoveToFalse();
    }

    public Piece transformTo(Epieces type) throws Exception, InstantiationException,
            IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        String path = "projeto.xadrez.classes.pecas.";
        if (type.equals(Epieces.Pawn) || type.equals(Epieces.King))
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
            if (!isFirstMove())
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

}
