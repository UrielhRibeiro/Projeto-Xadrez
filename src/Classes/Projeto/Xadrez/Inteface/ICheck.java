package Classes.Projeto.Xadrez.Inteface;

import Classes.Projeto.Xadrez.*;
import Classes.Projeto.Xadrez.Pieces.*;

public sealed interface ICheck permits Queen, Rook, Knight, Bishop, Pawn
{
    boolean isPieceDoingCheck(Piece piece);
}
