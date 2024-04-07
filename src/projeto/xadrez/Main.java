package projeto.xadrez;

import java.util.Scanner;
import projeto.xadrez.Enum.*;
import projeto.xadrez.classes.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cadastro de Jogadores ====");
        System.out.println("Player 1, digite seu nome: ");
        Player p1 = new Player(sc.nextLine());
        System.out.println("\n Player 2, digite seu nome: ");
        Player p2 = new Player(sc.nextLine());

        Chessboard c = new Chessboard(p1, p2);

        // ==== MENU PARA VISUALIZAR =====
        boolean stop = false;
        while( !stop ){

            System.out.println("==== Bem vindo ao jogo XaXaDrez ==== ");
            System.out.println("=== Menu de Opções ===");

            System.out.println("Nome Do Jogador - [1]");
            System.out.println("Pecas - [2]");
            System.out.println("Outros - [3]");
            System.out.println("Finalizar o codigo - [4]");

            int choose = sc.nextInt();

            switch(choose) {
                case 1:
                    for (int i = 0; i < c.getPlayers().length; i++){
                        System.out.println("\nPlayer " + (i +1) + ": " + c.getPlayers()[i].getName());
                    }
                    break;

                case 2:
                    do{
                        try {
                            int i = 0;
                            while(i < Epieces.values().length) {
                                System.out.println("\n" + (i + 1) + " - " + Epieces.values()[i] );
                                i++;
                            }
                            System.out.println("\n\n" + (i +1) + " - Finalizar");

                            choose = sc.nextInt();
                            choose--;

                            if(choose == i)
                                break;

                            System.out.println("\n Caracteristicas de " + Epieces.values()[choose] + " : ");

                            String path = "projeto.xadrez.classes.pecas.";
                            Class<?> classe = Class.forName(path +Epieces.values()[choose]);

                            System.out.println("\n------ Atributos ------ \n");
                            for ( Field f : classe.getSuperclass().getDeclaredFields() ){
                                System.out.println("\n" + f);
                            }

                            System.out.println("\n------ Metodos ------\n");
                            for ( Method m : classe.getDeclaredMethods() ) {
                                System.out.println("\n" + m);
                            }
                            for ( Method m : classe.getSuperclass().getDeclaredMethods() ) {
                                System.out.println("\n" + m);
                            }

                        }catch(Exception e){}

                    }while(true);

                    break;

                case 3:
                    do{
                        try {
                            int i = 0;
                            while(i < Eoutros.values().length) {
                                System.out.println("\n" + (i + 1) + " - " + Eoutros.values()[i] );
                                i++;
                            }
                            System.out.println("\n\n" + (i +1) + " - Finalizar");

                            choose = sc.nextInt();
                            choose--;

                            if(choose == i)
                                break;

                            System.out.println("\n Caracteristicas de " + Eoutros.values()[choose] + " : ");

                            String path = "projeto.xadrez.classes.";
                            Class<?> classe = Class.forName(path +Eoutros.values()[choose]);

                            System.out.println("\n------ Atributos ------ \n");

                            for ( Field f : classe.getDeclaredFields() ){
                                System.out.println("\n" + f);
                            }

                            System.out.println("\n------ Metodos ------\n");
                            for ( Method m : classe.getDeclaredMethods() ) {
                                System.out.println("\n" + m);
                            }

                        }catch(Exception e){}

                    }while(true);

                    break;

                case 4:
                    stop = true;
                    break;

                default:
                    System.out.println("Opcão inválida \n");

            }

        }

        sc.close();

    }
}