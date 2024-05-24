package Classes.Projeto.Xadrez.Inteface;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.Pieces.*;
import Classes.Projeto.Xadrez.*;

import java.awt.*;
import java.util.ArrayList;

//essa inteface vai bloquear que outras classes como peao tenham acesso a uma coleta de posicao indevida
public sealed interface IMoveDiagonal permits Bishop, Queen {

    default ArrayList<Pair<Integer, Integer>> getAllPossibleMovesDiagonal(Piece piece, Chessboard chessboard, boolean isMainDiagonal) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();
        Pair<Integer, Integer> pos = piece.getCord();
        Piece piece2;
        Color color;
        int x2;

        // caso a linha diagonal seja: \
        if(isMainDiagonal){

            int b = pos.v2 + pos.v1; // f(x) = ax +b, b = f(x) -ax, como a = -1 => b = f(x) +x
            var MainDiagonal = chessboard.getMainDiagonalPiecesByIndex(b);

            try {

                //pega a peca q esta a direita do parametro piece, e adiciona as localizacoes de onde piece pode se mover
                //y da direita maior que o y de piece
                piece2 = MainDiagonal.get(MainDiagonal.indexOf(piece) + 1);//pega a peca ao lado direito de piece
                color = piece2.getColor();

                //verifica se as cores forem diferente para atribuir a posicao da peca diferente como possivel
                //traduzindo: se pode comer a peca
                if(!color.equals(piece.getColor())){

                    PossibleMoves.add(new Pair<>(piece2.getCord().v1, piece2.getCord().v2));
                }
                /*
                    Lembrando: ArrayList ordenado nos valores de Y crescente
                    pecas com o coeficiente angular < 0, existe uma inversao dos maiores valores
                    x1 > x2 => f(x1) < f(x2), logo no ArrayList<Peca>
                    (  Peca(x1), Peca(x2) )
                 */
                x2 = piece2.getCord().v1;
                for(int x1 = pos.v1; x1 > x2; x1--){

                    PossibleMoves.add(new Pair<>(x1, -x1 +b));// f(x) = -x +b

                }
            }catch (Exception ignored){}

            try {

                //pega a peca q esta a esquerda do parametro piece, e adiciona as localizacoes de onde piece pode se mover
                //y da esquerda menor que o y de piece
                piece2 = MainDiagonal.get(MainDiagonal.indexOf(piece) - 1);//pega a peca ao lado esquerdo de piece
                color = piece2.getColor();

                //verifica se as cores forem diferente para atribuir a posicao da peca diferente como possivel
                //traduzindo: se pode comer a peca
                if(!color.equals(piece.getColor())){

                    PossibleMoves.add(new Pair<>(piece2.getCord().v1, piece2.getCord().v2));
                }

                /*
                    Lembrando: ArrayList ordenado nos valores de Y crescente
                    pecas com o coeficiente angular < 0, existe uma inversao dos maiores valores
                    x1 < x2 => f(x1) > f(x2), logo no ArrayList<Peca>
                    (  Peca(x2), Peca(x1) )
                 */

                x2 = piece2.getCord().v1;
                for(int x1 = pos.v1; x1 < x2; x1++){

                    PossibleMoves.add(new Pair<>(x1, -x1 +b)); // f(x) = -x +b

                }
            }catch (Exception ignored){}
            return PossibleMoves;
        }

        // caso a linha diagonal seja: /

        int b = pos.v1 - pos.v2 ; // f(x) = ax +b, b = f(x) -ax, como a = 1 => b = f(x) -x
        var SecondaryDiagonal = chessboard.getSecondaryDiagonalPiecesByIndex(b);

        try {

            //pega a peca q esta a direita do parametro piece, e adiciona as localizacoes de onde piece pode se mover
            //y da direita maior que o y de piece
            piece2 = SecondaryDiagonal.get(SecondaryDiagonal.indexOf(piece) + 1);//pega a peca ao lado direito de piece

            color = piece2.getColor();
            //verifica se as cores forem diferentes pode comer a peca
            x2 = piece2.getCord().v1;
            if(!color.equals(piece.getColor())){
                PossibleMoves.add(new Pair<>(x2, piece2.getCord().v2));
            }
            /*
                Lembrando: ArrayList<Peca> ordenado nos valores de Y crescente
                pecas com o coeficiente angular < 0, mantem os maiores valores
                x1 < x2 => f(x1) < f(x2), logo no ArrayList<Peca>
                (  Peca(x1), Peca(x2) )
             */
            for (int x1 = pos.v1; x1 < x2; x1++) {

                PossibleMoves.add(new Pair<>(x1, x1 +b));// f(x) = x +b

            }
        }catch (Exception ignored){}

        try{

            //pega a peca q esta a esquerda do parametro piece, e adiciona as localizacoes de onde piece pode se mover
            //y da esquerda menor que o y de piece
            piece2 = SecondaryDiagonal.get(SecondaryDiagonal.indexOf(piece) - 1);//pega a peca ao lado esquerdo de piece
            color = piece2.getColor();

            //verifica se as cores forem diferente para atribuir a posicao da peca diferente como possivel
            //traduzindo: se pode comer a peca
            if(!color.equals(piece.getColor())){
                PossibleMoves.add(new Pair<>(piece2.getCord().v1, piece2.getCord().v2));
            }

            /*
                Lembrando: ArrayList<Peca> ordenado nos valores de Y crescente
                pecas com o coeficiente angular < 0, mantem os maiores valores
                x1 > x2 => f(x1) > f(x2), logo no ArrayList<Peca>
                (  Peca(x2), Peca(x1) )
             */

            x2 = piece2.getCord().v1;
            for(int x1 = pos.v1; x1 > x2; x1--){

                PossibleMoves.add(new Pair<>(x1, x1 +b));// f(x) = x +b

            }
        }catch (Exception ignored){}

        return PossibleMoves;
    }
}
