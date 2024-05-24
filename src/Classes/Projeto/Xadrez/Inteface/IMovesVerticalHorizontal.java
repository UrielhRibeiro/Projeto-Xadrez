package Classes.Projeto.Xadrez.Inteface;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.Chessboard;
import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Pieces.*;

import java.util.ArrayList;

//essa inteface vai bloquear que outras classes como peao tenham acesso a uma coleta de posicao indevida
public sealed interface IMovesVerticalHorizontal permits Queen, Rook {

    default ArrayList<Pair<Integer, Integer>> getAllPossibleMovesHorizontalVertical(Piece piece,Chessboard chessboard, boolean isVertical) {
        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();
        if(isVertical){
            var column = chessboard.getColumnPiecesByIndex(piece.getCord().v2);

            //pega a peca q esta a direita do parametro piece, e adiciona as localizacoes de onde piece pode se mover
            try{

                for(int y = piece.getCord().v2; y < column.get(column.indexOf(piece) +1).getCord().v2 ; y++) {
                    PossibleMoves.add(new Pair<>(piece.getCord().v1, y));
                }


            }catch(Exception ignored){}

            //pega a peca q esta a esquerda do parametro piece, e adiciona as localizacoes de onde piece pode se mover
            try{

                for(int y = piece.getCord().v2; y > column.get(column.indexOf(piece) -1).getCord().v2; y--){
                    PossibleMoves.add(new Pair<>(piece.getCord().v1, y));
                }


            }catch(Exception ignored){}

            return PossibleMoves;
        }
        var rowPieces = chessboard.getRowPiecesByIndex(piece.getCord().v1);

        //pega a peca q esta a direita do parametro piece, e adiciona as localizacoes de onde piece pode se mover
        try {

            for (int x = piece.getCord().v1; x < rowPieces.get(rowPieces.indexOf(piece) + 1).getCord().v1; x++) {
                PossibleMoves.add(new Pair<>(x, piece.getCord().v2));
            }


        }catch(Exception ignored){};

        //pega a peca q esta a direita do parametro piece, e adiciona as localizacoes de onde piece pode se mover
        try {

            for (int x = piece.getCord().v1; x > rowPieces.get(rowPieces.indexOf(piece) - 1).getCord().v1; x--) {
                PossibleMoves.add(new Pair<>(x, piece.getCord().v2));
            }


        }catch(Exception ignored){};

        return PossibleMoves;
    }

}
