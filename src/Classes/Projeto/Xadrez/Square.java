package Classes.Projeto.Xadrez;

import java.awt.*;

public class Square {

	//temporario
	private int x, y;
	private Color color;

	private Piece piece;
	private boolean hasPiece = false;

	public Color getColor() {
		return color;
	}

	public Square( Piece piece, int x, int y, Color color) {

		if(piece != null){
			addPiece(piece);
		}

		this.x = x;
		this.y = y;
		this.color = color;

	}

	public boolean hasPiece() {
		return hasPiece;
	}

	public void addPiece(Piece piece) {
		hasPiece = true;
		this.piece = piece;
	}

}
