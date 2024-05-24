package Classes.Projeto.Xadrez.Pieces;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.Chessboard;
import Classes.Projeto.Xadrez.Inteface.ICheck;
import Classes.Projeto.Xadrez.Inteface.IMovesVerticalHorizontal;
import Classes.Projeto.Xadrez.Piece;
import Classes.Projeto.Xadrez.Player;

import java.util.ArrayList;

public final class Rook extends Piece implements IMovesVerticalHorizontal, ICheck {

    public Rook(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard, Pair<Integer, Integer> Cordenadas) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

        //Andar para Vertical
        getAllPossibleMovesHorizontalVertical(this, chessboard, true);

        //Andar para Horizontal
        getAllPossibleMovesHorizontalVertical(this, chessboard, false);

        //Roque direita

        //Verificar Cheque


        return PossibleMoves;
    }


    @Override
    public boolean isPieceDoingCheck(Piece piece) {
        //...implementar dps
        return false;
    }
}
