package com.tictactoe;

public class TicTacToeGame {

    TicTacToePlayer XPlayer;
    TicTacToePlayer OPlayer;
    Winner Result = Winner.None;

    public enum Winner { None, Tie, X, O };

    public TicTacToeGame ( TicTacToePlayer _XPlayer, TicTacToePlayer _OPlayer )
    {
        XPlayer = _XPlayer;
        OPlayer = _OPlayer;
    }

    public Winner Play ()
    {
        return Play (false );
    }

    public Winner Play ( boolean _printGame )
    {
        if ( _printGame ) System.out.println ( "----------------------------");

        TicTacToeBoard the_board = new TicTacToeBoard();
        while (true) {
            String boardBeforeMove = the_board.getBoard();
            if ( _printGame ) System.out.println ( "X Moves");
            TicTacToeBoard.moveResult XResult = XPlayer.play( the_board);
            if ( _printGame ) XPlayer.printPossibleMoves(boardBeforeMove);
            if ( _printGame ) the_board.printBoard();

            if (XResult == TicTacToeBoard.moveResult.Won) {
                if ( _printGame ) System.out.println ( "X won");
                Result = Winner.X;
                break;
            }
            if (XResult == TicTacToeBoard.moveResult.CatsGame) {
                if ( _printGame ) System.out.println ( "Cats game");
                Result = Winner.Tie;
                break;
            }

            boardBeforeMove = the_board.getBoard();
            if ( _printGame ) System.out.println ( "O Moves");
            TicTacToeBoard.moveResult OResult = OPlayer.play(the_board);
            if ( _printGame ) OPlayer.printPossibleMoves(boardBeforeMove);
            if ( _printGame ) the_board.printBoard();

            if (OResult == TicTacToeBoard.moveResult.Won) {
                if ( _printGame ) System.out.println ( "O won");
                Result = Winner.O;
                break;
            }
            if (OResult == TicTacToeBoard.moveResult.CatsGame) {
                if ( _printGame ) System.out.println ( "Cats game");
                Result = Winner.Tie;
                break;
            }
        }
        if ( _printGame ) System.out.println ( "----------------------------");

        return Result;
    }
}
