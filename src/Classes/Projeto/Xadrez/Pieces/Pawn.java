package Classes.Projeto.Xadrez.Pieces;

import Classes.Projeto.Enum.*;
import Classes.Projeto.Event.Interface.EventHandler;
import Classes.Projeto.Pair.*;
import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Inteface.ICheck;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public final class Pawn extends Piece implements ICheck {

    public Pawn(Player player, int x, int y) {
        super(player, x, y);
    }

    @EventHandler(name = "onPawnTryToTransform", parametersType = Piece.class)
    private static void onPawnTryToTransform(Piece piece) throws Exception {
        // trigger quando movepiece
        // checa se no final
        // Peca a peça atraves da interface
        // transformTo()
        if(piece.getCord().v2 == 7){}
    }

    //quando o peao chega na ultima casa pode se transformar em outra peca
    public Piece transformTo(EPieces type, Player player) throws Exception, InstantiationException,
            IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        String path = "Classes.Projeto.Xadrez.Pieces.";
        if (type.equals(EPieces.Pawn) || type.equals(EPieces.King))
            throw new Exception(); // agente vai implementar depois
        Constructor<?> pieceConstructor = Class.forName(path + type).getConstructor(Player.class);
        return (Piece) pieceConstructor.newInstance(player);
    }

    @Override
    public ArrayList<Pair<Integer, Integer>> getAllPossibleMoves( Chessboard chessboard, Pair< Integer, Integer> Cordenadas) {

        ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();
        Pair<Integer, Integer> tempPair;

        // em frente ao peao
        if(!chessboard.getBoardSquares()[Cordenadas.v1 + 1][Cordenadas.v2].hasPiece()){
            tempPair = new Pair<Integer, Integer>(Cordenadas.v1 + 1, Cordenadas.v2);
            PossibleMoves.add(tempPair);
        }

        // diagonal direita superior do peao há alguma peça de outra cor
        if(chessboard.getBoardSquares()[Cordenadas.v1 + 1][Cordenadas.v2 + 1].hasPiece() &&
                chessboard.getBoardSquares()[Cordenadas.v1][Cordenadas.v2].getColor() !=
                            chessboard.getBoardSquares()[Cordenadas.v1 + 1][Cordenadas.v2 + 1].getColor()){
            tempPair = new Pair<Integer, Integer>(Cordenadas.v1 + 1, Cordenadas.v2 + 1);
            PossibleMoves.add(tempPair);
        }

        // diagonal esquerda superior do peao há alguma peça de outra cor
        if( chessboard.getBoardSquares()[Cordenadas.v1 - 1][Cordenadas.v2 + 1].hasPiece() &&
                ( chessboard.getBoardSquares()[Cordenadas.v1][Cordenadas.v2].getColor()
                        != chessboard.getBoardSquares()[Cordenadas.v1 - 1][Cordenadas.v2 + 1].getColor() ) ){
            tempPair = new Pair<Integer, Integer>(Cordenadas.v1 - 1, Cordenadas.v2 + 1);
            PossibleMoves.add(tempPair);
        }

        // Anda 2 casas para frente se for o 1° movimento
        if(!chessboard.getBoardSquares()[Cordenadas.v1 + 2][Cordenadas.v2].hasPiece() && this.isFirstMove() && !chessboard.getBoardSquares()[Cordenadas.v1 + 1][Cordenadas.v2].hasPiece()){
            tempPair = new Pair<Integer, Integer>(Cordenadas.v1 + 2, Cordenadas.v2);
            PossibleMoves.add(tempPair);
        }


        return PossibleMoves;
    }

    @Override
    public boolean isPieceDoingCheck(Piece piece) {
        //...implementar dps
        return false;
    }
}
