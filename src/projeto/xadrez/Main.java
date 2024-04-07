package projeto.xadrez;

import java.util.Scanner;

import projeto.xadrez.Enum.Epieces;
import projeto.xadrez.classes.*;
import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) throws Exception {

        //System.out.println("Início do projeto!");


        Player p1 = new Player("teste");
        Player p2 = new Player("teste2");
        Scanner sc = new Scanner(System.in);

        Chessboard c = new Chessboard(p1, p2);

        // ==== MENU PARA VISUALIZAR =====
        boolean stop = false;
        while( !stop ){
            System.out.println("Bem vindo ao XaXaDrez, o que deseja visualizar? \n");

            System.out.println("1 - Jogadores \n");
            System.out.println("2 - Caracteristicas Das Pecas \n");
            System.out.println("3 - Finalizar o codigo \n");

            int choose = sc.nextInt();

            switch(choose) {
                case 1:
                    for (int i = 0; i < c.getPlayers().length; i++){
                        System.out.println("Player " + (i +1) + ": " + c.getPlayers()[i].getName());
                    }
                    break;

                case 2:
                    for(int i = 0; i < Epieces.values().length; i++) {
                        System.out.println(Epieces.values()[i]);
                    }
                    break;

                case 3:
                    stop = true;
                    break;

                default:
                    System.out.println("Opcão inválida \n");

            }

        }

        sc.close();

    }
}