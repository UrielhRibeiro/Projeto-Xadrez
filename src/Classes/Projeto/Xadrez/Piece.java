package Classes.Projeto.Xadrez;

import Classes.Projeto.Pair.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Piece extends JLabel{

	private boolean isFirstMove = true;
	private Color color;
	private Pair<Integer, Integer> cord;
	private ArrayList<Pair<Integer, Integer>> PossibleMoves = new ArrayList<>();

	public Pair<Integer, Integer> getCord(){
		return this.cord;
	};

	public void setCord(Pair<Integer, Integer> cord){
		this.cord = cord;
	}

	public Piece(Player player, int x, int y) {
		this.color = player.getcontroledPieceByColor();
		this.cord = new Pair<>(x, y);
	}

	public boolean isFirstMove() {
		return isFirstMove;
	}

	public void setFirstMoveToFalse() {
		this.isFirstMove = false;
		this.setIcon(getDisabledIcon());
	}

	public Color getColor() {
		return color;
	}

	public abstract ArrayList<Pair<Integer, Integer>> getAllPossibleMoves(Chessboard chessboard, Pair <Integer, Integer> coords);

}
