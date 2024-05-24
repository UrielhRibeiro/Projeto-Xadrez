package Classes.Projeto.Xadrez.Pieces;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.Chessboard;
import Classes.Projeto.Xadrez.Inteface.ICheck;
import Classes.Projeto.Xadrez.Inteface.IMoveDiagonal;
import Classes.Projeto.Xadrez.Inteface.IMovesVerticalHorizontal;
import Classes.Projeto.Xadrez.Piece;
import Classes.Projeto.Xadrez.Player;

import java.util.ArrayList;

public final class Queen extends Piece implements IMovesVerticalHorizontal, IMoveDiagonal, ICheck {

    public Queen(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard, Pair<Integer, Integer> Cordenadas) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

        //Andar para Vertical: |
        PossibleMoves.addAll(getAllPossibleMovesHorizontalVertical(this, chessboard, true));
        //Andar para Horizontal:  __
        PossibleMoves.addAll(getAllPossibleMovesHorizontalVertical(this,chessboard, false));

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
