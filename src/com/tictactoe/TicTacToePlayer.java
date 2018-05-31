package com.tictactoe;

import com.probabilisticlearner.*;
import java.util.*;

public class TicTacToePlayer {
    String piece;
    ILearner MyBrain;
    List<String> BoardWhenMoveMade;
    List<Integer> MovesMade;
    TicTacToeBoard.moveResult LastMoveResult;

    public TicTacToePlayer ( String _piece) {
        piece = _piece;
        MyBrain = new SingletOutputProbabilisticLearner(9);
        BoardWhenMoveMade = new ArrayList<String>();
        MovesMade = new ArrayList<Integer>();
        TicTacToeBoard.moveResult LastMoveResult = TicTacToeBoard.moveResult.Invalid;
    }

    public TicTacToeBoard.moveResult play( TicTacToeBoard the_board )
    {
        // get the board
        String board = the_board.getBoard();
        BoardWhenMoveMade.add ( board );
/*
        board = board.replace ( piece, "1" );

        // convert to my perspective
        if ( piece.equals ("X"))
            board = board.replace ( "O", "0");
        else
            board = board.replace ( "X", "0");
*/
        // get my move
        LastMoveResult = TicTacToeBoard.moveResult.Invalid;
        int moveMade = 0;
        while ( LastMoveResult == TicTacToeBoard.moveResult.Invalid ) {
            String Output = MyBrain.evaluate(board);

            moveMade = Output.indexOf("1");

            if ( moveMade == -1 )
            {
                System.out.println ( "X");
            }

            // play my move
            if (piece.equals("X"))
                LastMoveResult = the_board.playX(moveMade);
            else
                LastMoveResult = the_board.playO(moveMade);

        }

        MovesMade.add ( moveMade );

        return LastMoveResult;
    }

    public void learn ( boolean _withPunishment )
    {
        for ( int move = 0; move < MovesMade.size(); move++ ) {
            // convert move made to string
            StringBuilder sb = new StringBuilder();
            for ( int loop = 0; loop < MovesMade.get(move); loop++)
                sb.append ( "0");
            sb.append( "1" );
            while ( sb.length() < 9)
                sb.append ( "0");

            String moveMade = sb.toString();
            String board = BoardWhenMoveMade.get(move);

            if (LastMoveResult == TicTacToeBoard.moveResult.CatsGame) {
                // add some to moves because opponent didn't win
                MyBrain.reward( board, moveMade );
            } else if (LastMoveResult == TicTacToeBoard.moveResult.Won) {
                // add more to moves made because I won
                MyBrain.reward( board, moveMade );
            } else {
                if (_withPunishment )
                // subtract from moves made because I lost?
                MyBrain.punish( board, moveMade );
            }
        }
        BoardWhenMoveMade = new ArrayList<String>();
        MovesMade = new ArrayList<Integer>();

    }

    public void printPossibleMoves ( String _input )
    {
        int[] chances = MyBrain.getChances ( _input );
        System.out.print ( chances[0] );
        System.out.print ( ", ");
        System.out.print ( chances[1] );
        System.out.print ( ", ");
        System.out.print ( chances[2] );
        System.out.print ( ", ");
        System.out.print ( chances[3] );
        System.out.print ( ", ");
        System.out.print ( chances[4] );
        System.out.print ( ", ");
        System.out.print ( chances[5] );
        System.out.print ( ", ");
        System.out.print ( chances[6] );
        System.out.print ( ", ");
        System.out.print ( chances[7] );
        System.out.print ( ", ");
        System.out.println ( chances[8] );
    }
}
