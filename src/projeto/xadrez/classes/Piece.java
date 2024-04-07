package projeto.xadrez.classes;

import java.util.ArrayList;
import static java.lang.Math.pow;

public abstract class Piece {

    private boolean isFirstMove = true;// lembrar de definir no MovePiece se mover ser defindo pra falso
    public int x, y;
    protected Player piecePlayer;
    protected final int walkDirection; //Direção onde a peça (branca ou preta) irá se mover.

    // === Método Construtor ===
    public Piece(Player player, int x, int y) {
        walkDirection = (int) pow(-1, player.getId() - 1);
        piecePlayer = player;
        this.x = x;
        this.y = y;
    }

    // === Método abstrato para mover a peça ===
    public abstract void MovePiece(Chessboard chessboard, int pieceX, int pieceY);

    // === Método que retorna as posições de uma peça pode se mover ===
    public void MovePiece(Chessboard chessboard, Pair<Integer, Integer> piecePos) {
        MovePiece(chessboard, piecePos.v1, piecePos.v2); // === Utilizando o Pair para verificar as possibilidade movimento em x e y ===
    }

    // === Método que retorna um ArrayList das posições que uma peça pode se mover ===
    public abstract ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard);

    // === Métodos Encapsuladores ===
    public Player getPiecePlayer() {
        return piecePlayer;
    }

    public int getWalkDirection() {
        return walkDirection;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    protected void setFirstMoveToFalse() {
        isFirstMove = false;
    }

}
