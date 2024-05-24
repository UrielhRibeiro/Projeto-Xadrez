package Classes.Projeto.Xadrez.Pieces;

import java.util.ArrayList;
import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.*;
import java.util.Arrays;
import java.util.List;

public final class King extends Piece {

    public King(Player player, int x, int y) {
        super(player, x, y);
    }

    private boolean isInCheck(){
        //...implementar dps
        return false;
    }

    private boolean isInCheckMate(){
        //..implementar dps
        return false;
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard, Pair<Integer, Integer> Coords) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

        //Lista de deslocamento do rei
        List<Pair<Integer, Integer>> kingMoves = Arrays.asList(
                new Pair<>(0, 1), new Pair<>(0, -1), new Pair<>(1, 1), new Pair<>(1, 0),
                new Pair<>(-1, -1), new Pair<>(-1, 0), new Pair<>(-1, 1), new Pair<>(1, -1)
        );

        for (Pair<Integer, Integer> move : kingMoves) {
            int newV1 = Coords.v1 + move.v1;
            int newV2 = Coords.v2 + move.v2;

            // Verificação de limites
            if (newV1 >= 0 && newV1 < chessboard.getBoardSize() && newV2 >= 0 && newV2 < chessboard.getBoardSize()) {
                if (!chessboard.getBoardSquares()[newV1][newV2].hasPiece()) {
                    PossibleMoves.add(new Pair<>(newV1, newV2));
                } else if (chessboard.getBoardSquares()[Coords.v1][Coords.v2].getColor() != chessboard.getBoardSquares()[newV1][newV2].getColor()) {
                    PossibleMoves.add(new Pair<>(newV1, newV2));
                }
            }
        }

        return PossibleMoves;
    }


}
