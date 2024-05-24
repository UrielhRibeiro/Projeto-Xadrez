package Classes.Projeto.Xadrez;

import Classes.Projeto.Pair.Pair;
import Classes.Projeto.Xadrez.Pieces.*;

import java.lang.reflect.Array;
import java.util.*;

public class Chessboard {

    private final int BoardSize = 8;
    private Square[][] BoardSquares = new Square[BoardSize][BoardSize];

    //Ordenados sempre em ordem crescente apartir do valor de y das pecas {

        private final Map<Integer, ArrayList<Piece>> mainDiagonalPieces = new HashMap<>();
        private final Map<Integer, ArrayList<Piece>> secondaryDiagonalPieces = new HashMap<>();
        private final ArrayList<ArrayList<Piece>> columnPieces = new ArrayList<>();
    //}

    //Ordenado sempre em ordem crescente apartir do valor de X das pecas
    private final ArrayList<ArrayList<Piece>> rowPieces = new ArrayList<>();


    //=============== BoardSize =================
    public int getBoardSize() {
        return BoardSize;
    }
    //================= Column ==================
    public ArrayList<ArrayList<Piece>> getColumnPieces() {
        return this.columnPieces;
    }
    public ArrayList<Piece> getColumnPiecesByIndex(int index) {
        return this.columnPieces.get(index);
    }

    //================== Row ====================
    public ArrayList<ArrayList<Piece>> getRowPieces() {
        return this.rowPieces;
    }
    public ArrayList<Piece> getRowPiecesByIndex(int index) {
        return this.rowPieces.get(index);
    }

    //============= Main Diagonal ==============
    public Map<Integer, ArrayList<Piece>> getMainDiagonalPieces(){
        return this.mainDiagonalPieces;
    }
    public ArrayList<Piece> getMainDiagonalPiecesByIndex(int index) {
        return this.mainDiagonalPieces.get(index);
    }

    //=========== Secondary Diagonal ===========
    public Map<Integer, ArrayList<Piece>> getSecondaryDiagonalPieces(){
        return this.secondaryDiagonalPieces;
    }
    public ArrayList<Piece> getSecondaryDiagonalPiecesByIndex(int index) {
        return this.secondaryDiagonalPieces.get(index);
    }

    //============ Board Squares =============
    public Square[][] getBoardSquares() {
       return this.BoardSquares;
    }
    public void setBoardSquares( Square[][] BoardSquares) {
        this.BoardSquares = BoardSquares;
    }
    //=========================================
    public static void createAllPieces(Chessboard chessboard , Player[] Players)  {

        // =========== Instanciando Diagonais ==============
        for(int i = 0; i < 15; i++){
            chessboard.mainDiagonalPieces.put(i, new ArrayList<Piece>());
            chessboard.secondaryDiagonalPieces.put(i-7, new ArrayList<Piece>());
        }

        // ====== Instanciando Horizontal e vertical =======
        for(int i = 0; i < 8; i++){
            chessboard.rowPieces.add(i, new ArrayList<>());
            chessboard.columnPieces.add(i, new ArrayList<>());
        }

        Piece tempPiece;
        Square tempSquare;
        
        // ============= Peoes do jogador 1 ================

        for(int i=0; i<8; i++){
            tempPiece = new Pawn( Players[0], i ,1);
            tempSquare = new Square( tempPiece, i, 1, Players[0].getcontroledPieceByColor());

            insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(1), tempPiece, false);
            insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(i), tempPiece, true);

            insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), i, 1, tempPiece, true);
            insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), i, 1, tempPiece,false);

            chessboard.BoardSquares[i][1] = tempSquare;
        }

        // ============ Torres do jogador 1 ================

        tempPiece = new Rook( Players[0] ,0, 0);
        tempSquare = new Square( tempPiece, 0, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(0), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 0, 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 0, 0, tempPiece,false);

        chessboard.BoardSquares[0][0] = tempSquare;

        tempPiece = new Rook( Players[0], 7, 0 );
        tempSquare = new Square( tempPiece, 7, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(7), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 7, 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 7, 0, tempPiece,false);

        chessboard.BoardSquares[7][0] = tempSquare;

        // ============ Bispos do jogador 1 ================

        tempPiece = new Bishop( Players[0] , 2, 0);
        tempSquare = new Square( tempPiece, 2, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(2), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(),2 , 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 2, 0, tempPiece,false);

        chessboard.BoardSquares[2][0] = tempSquare;

        tempPiece = new Bishop( Players[0] , 5, 0);
        tempSquare = new Square( tempPiece, 5, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(5), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 5, 0 ,tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 5, 0 ,tempPiece,false);

        chessboard.BoardSquares[5][0] = tempSquare;

        // ============  Cavalos do jogador 1  ==============

        tempPiece = new Knight( Players[0],  1, 0);
        tempSquare = new Square( tempPiece, 1, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(1), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 1, 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 1, 0, tempPiece,false);

        chessboard.BoardSquares[1][0] = tempSquare;

        tempPiece = new Knight( Players[0] ,6 ,0);
        tempSquare = new Square( tempPiece, 6, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(6), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 6, 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 6, 0, tempPiece,false);

        chessboard.BoardSquares[6][0] = tempSquare;

        // ==========  Rainha e Rei do Jogador 1  ===========

        tempPiece = new Queen( Players[0], 3, 0);
        tempSquare = new Square( tempPiece, 3, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(3), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 3,0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 3,0, tempPiece,false);

        chessboard.BoardSquares[3][0] = tempSquare;

        tempPiece = new King( Players[0],4,0);
        tempSquare = new Square( tempPiece, 4, 0, Players[0].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(0), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(4), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 4, 0, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 4, 0, tempPiece,false);

        chessboard.BoardSquares[4][0] = tempSquare;


        // =================================================


        // ============= Peoes do jogador 2 ================

        for(int i=0; i<7; i++){
            tempPiece = new Pawn( Players[1], i,6);
            tempSquare = new Square( tempPiece, i, 6, Players[1].getcontroledPieceByColor());

            insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(6), tempPiece, false);
            insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(i), tempPiece, true);

            insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), i, 6, tempPiece, true);
            insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), i, 6, tempPiece,false);
            chessboard.BoardSquares[i][6] = tempSquare;
        }

        // ============ Torres do jogador 2 ================

        tempPiece = new Rook( Players[1], 0, 7);
        tempSquare = new Square( tempPiece, 0, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(0), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 0, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 0, 7, tempPiece,false);

        chessboard.BoardSquares[0][7] = tempSquare;

        tempPiece = new Rook( Players[1] , 7, 7);
        tempSquare = new Square( tempPiece, 7, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(7), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 7, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 7, 7, tempPiece,false);

        chessboard.BoardSquares[7][7] = tempSquare;

        // ============ Bispos do jogador 2 ================

        tempPiece = new Bishop( Players[1],2,7);
        tempSquare = new Square( tempPiece, 2, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(2), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 2, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(),2, 7, tempPiece,false);

        chessboard.BoardSquares[2][7] = tempSquare;


        tempPiece = new Bishop( Players[1], 5,7);
        tempSquare = new Square( tempPiece, 5, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(5), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(),5 ,7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(),5, 7, tempPiece,false);

        chessboard.BoardSquares[5][7] = tempSquare;

        // ============  Cavalos do jogador 2  ==============

        tempPiece = new Knight( Players[1] ,1, 7);
        tempSquare = new Square( tempPiece, 1, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(1), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 1, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 1, 7, tempPiece,false);

        chessboard.BoardSquares[1][7] = tempSquare;


        tempPiece = new Knight( Players[1] ,6,7);
        tempSquare = new Square( tempPiece, 6, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(6), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 6, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 6, 7, tempPiece,false);

        chessboard.BoardSquares[6][7] = tempSquare;

        // ==========  Rainha e Rei do Jogador 2  ===========

        tempPiece = new Queen( Players[1] , 3, 7);
        tempSquare = new Square( tempPiece, 3, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(3), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(), 3, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(), 3, 7, tempPiece,false);

        chessboard.BoardSquares[3][7] = tempSquare;

        tempPiece = new King( Players[1], 4, 7);
        tempSquare = new Square( tempPiece, 4, 7, Players[1].getcontroledPieceByColor());

        insertPieceInRowOrColumn(chessboard.getColumnPiecesByIndex(7), tempPiece, false);
        insertPieceInRowOrColumn(chessboard.getRowPiecesByIndex(4), tempPiece, true);

        insertPieceInDiagonal(chessboard.getMainDiagonalPieces(),4, 7, tempPiece, true);
        insertPieceInDiagonal(chessboard.getSecondaryDiagonalPieces(),4, 7, tempPiece,false);

        chessboard.BoardSquares[4][7] = tempSquare;

        // =================================================

        // Posições vazias no meio do tabuleiro

        for(int i=0;i<=7;i++){
            for(int j=0; j<=3;j++) {
                tempSquare = new Square(null, i, 2 + j, null);
            }
        }

    }

    public static void insertPieceInRowOrColumn (ArrayList<Piece> collection, Piece piece, boolean isVertical){
        try {
            collection.addLast(piece);
            if(isVertical){
                //Vertical
                collection.sort((p1, p2) -> {return Integer.compare(p1.getCord().v2, p2.getCord().v2);});
                return;
            }
            //Horizontal
            collection.sort((p1, p2) -> {return Integer.compare(p1.getCord().v1, p2.getCord().v1);});
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static int getBIndex(int x, int y, boolean isMainDiagonal){
        if(isMainDiagonal)
            return y+x;
        return y-x;
    }
    private static int getBIndex(Pair<Integer,Integer> cds, boolean isMainDiagonal){
        return getBIndex(cds.v1,cds.v2,isMainDiagonal);
    }

    public static void insertPieceInDiagonal(Map<Integer, ArrayList<Piece>> collection, int x, int y, Piece piece, boolean isMainDiagonal){
        int b = getBIndex(x,y,isMainDiagonal);

        collection.get(b).addLast(piece);
        if(isMainDiagonal){
            //Diagonal principal: \
            collection.get(b).sort((p1, p2) -> {return p2.getCord().v1.compareTo(p1.getCord().v1);});
            return;
        }
        //Diagonal secundaria: /
        collection.get(b).sort((p1, p2) -> {return Integer.compare(p1.getCord().v1, p2.getCord().v1);});

    }

}


