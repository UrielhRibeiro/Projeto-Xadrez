package Classes.Projeto.Xadrez.Pieces;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Inteface.ICheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class Knight extends Piece implements ICheck {

    public Knight(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard, Pair<Integer, Integer> Cordenadas) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

        // Lista de deslocamentos do cavalo
        List<Pair<Integer, Integer>> knightMoves = Arrays.asList(
                new Pair<>(2, 1), new Pair<>(2, -1), new Pair<>(-2, 1), new Pair<>(-2, -1),
                new Pair<>(1, 2), new Pair<>(1, -2), new Pair<>(-1, 2), new Pair<>(-1, -2)
        );

        int boardSize = 8;

        for (Pair<Integer, Integer> move : knightMoves) {
            int newV1 = Cordenadas.v1 + move.v1;
            int newV2 = Cordenadas.v2 + move.v2;

            // Verificação de limites
            if (newV1 >= 0 && newV1 < boardSize && newV2 >= 0 && newV2 < boardSize) {
                if (!chessboard.getBoardSquares()[newV1][newV2].hasPiece()) {
                    PossibleMoves.add(new Pair<>(newV1, newV2));
                } else if (chessboard.getBoardSquares()[Cordenadas.v1][Cordenadas.v2].getColor() != chessboard.getBoardSquares()[newV1][newV2].getColor()) {
                    PossibleMoves.add(new Pair<>(newV1, newV2));
                }
            }
        }

        return PossibleMoves;
    }


    @Override
    public boolean isPieceDoingCheck(Piece piece) {
        //...implementar dps
        return false;
    }
}
