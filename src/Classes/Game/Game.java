package Classes.Game;

import Classes.Projeto.Event.Interface.EventHandler;
import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Pieces.*;

import javax.swing.*;
import java.awt.*;

public class Game {

    @EventHandler(name = "onStart")
    public static void onStart() throws Exception {
        Player player1 = new Player("Moovo", Color.white);
        Player player2 = new Player("fds", Color.black);
        Chessboard chessboard = new Chessboard();
        Chessboard.createAllPieces(chessboard, new Player[]{player1, player2});
        String str = "Classes.Projeto.Xadrez.Pieces.";
        System.out.println("\u2654");
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500,500);
        JLabel label = new JLabel();
        label.setText("\u2654");
        label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 50));
        label.setBounds(0,0,70,70);
        frame.add(label);

    }

    @EventHandler(name = "onTick")
    public static void onTick(){

    }
}
