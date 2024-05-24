package Classes.Projeto.Xadrez;

import Classes.Projeto.Event.Interface.EventHandler;

import java.awt.Color;

public class Player {

	private String name;
	private Color controledPieceByColor;

	public Player(String name, Color color) {
		this.name = name;
		this.controledPieceByColor = color;
	}

	@EventHandler(name = "onMovePiece", parametersType = { Player.class, Piece.class, int.class, int.class })
	private static void onMovePiece(Player player, Piece piece, int x, int y) {
		//...Implementar a funcao q vai mover a peca
	}

	public String getName() {
		return name;
	}

	public Color getcontroledPieceByColor() {
		return controledPieceByColor;
	}

	public void setControlerPieceByColor(Color pieceColorControler) {
		this.controledPieceByColor = pieceColorControler;
	}

}
