package project.chess.classes;// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import static java.lang.Math.pow;

import java.util.ArrayList;

public abstract class Piece {
    public int x, y;
    protected Player piecePlayer;
    //direcao da peca de quem e a vez de jogar(branco, ou preto)
    protected final int walkDirection;

    public Piece(Player player, int x, int y) {
        walkDirection = (int) pow(-1, player.getId() - 1);
        piecePlayer = player;
        this.x = x;
        this.y = y;
    }

    //Vai mover a peça
    public abstract void MovePiece(Chessboard chessboard, int pieceX, int pieceY);

    public void MovePiece(Chessboard chessboard, Pair<Integer, Integer> piecePos) {
        MovePiece(chessboard, piecePos.v1, piecePos.v2);
    }

    // retorna um arraylist contendo os valores de x e y que a peca pode se mover
    public abstract ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard);

}