package com.tictactoe;

public class TicTacToeBoard {
    String the_board;

    public enum moveResult { Valid, CatsGame, Won, Invalid };

    public TicTacToeBoard () {
        newGame();
    }

    public void newGame()
    {
        the_board = ".........";
    }

    private boolean check_winner ( int _index1, int _index2, int _index3, char _player) {
        if ( the_board.charAt (_index1) == _player &&
                the_board.charAt (_index2) == _player &&
                the_board.charAt (_index3) == _player )
            return true;
        return false;
    }
    private moveResult play ( int _position, String _player ) {
        // if there is already a piece at the position, return InvalidMove
        if ( the_board.charAt(_position) != '.')
            return moveResult.Invalid;

        StringBuilder sb = new StringBuilder(the_board);
        sb.replace(_position, _position+1, _player);
        the_board = sb.toString();

        // check horizontals
        if ( check_winner ( 0, 1, 2, _player.charAt ( 0 ) ) ||
             check_winner ( 3, 4, 5, _player.charAt ( 0 ) ) ||
             check_winner ( 6, 7, 8, _player.charAt ( 0 ) ) )
            return moveResult.Won;

        // check verticals
        if ( check_winner ( 0, 3, 6, _player.charAt ( 0 ) ) ||
                check_winner ( 1, 4, 7, _player.charAt ( 0 ) ) ||
                check_winner ( 2, 5, 8, _player.charAt ( 0 ) ) )
            return moveResult.Won;

        // check diagonals
        if ( check_winner ( 0, 4, 8, _player.charAt ( 0 ) ) ||
                check_winner ( 2, 4, 6, _player.charAt ( 0 ) ) )
            return moveResult.Won;

        // finally check cats game
        if ( !the_board.contains ("."))
            return moveResult.CatsGame;

        return moveResult.Valid;

    }

    // returns true if game over
    public moveResult playX ( int _position ) {
        return play ( _position, "X");
    }

    public moveResult playO ( int _position ) {
        return play ( _position, "O");
    }

    public String getBoard () {
        return the_board;
    }

    public void printBoard () {
        StringBuilder output = new StringBuilder();
        for ( int row = 0; row < 3; row++ ) {
            for ( int column = 0; column < 3; column++ ) {
                output.append ( the_board.charAt ( row*3 + column ) );
            }
            output.append ( "\n" );
        }

        System.out.println ( output );
    }

}
