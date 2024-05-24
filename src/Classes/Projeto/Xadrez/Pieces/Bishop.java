package Classes.Projeto.Xadrez.Pieces;

import Classes.Projeto.Event.Interface.EventHandler;
import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Inteface.ICheck;
import Classes.Projeto.Xadrez.Inteface.IMoveDiagonal;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public final class Bishop extends Piece implements IMoveDiagonal, ICheck {

    public Bishop(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves( Chessboard chessboard, Pair< Integer, Integer> Cordenadas) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

        //Andar para diagonal com coeficiente angular > 0 : \
        PossibleMoves.addAll(getAllPossibleMovesDiagonal(this,chessboard, false));

        //Andar para diagonal com coeficiente angular < 0 : /
        PossibleMoves.addAll(getAllPossibleMovesDiagonal(this,chessboard, true));


        return PossibleMoves;
    }

    @Override
    public boolean isPieceDoingCheck(Piece piece) {
        //...implementar dps
        return false;
    }
}
