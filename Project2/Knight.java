// Written by Tamojit Bera, bera0041 and Srinivas Preetham Addepalli, addep011

import java.lang.Math;
public class Knight {
    /**
     * Constructor.
     * @param row   The current row of the knight.
     * @param col   The current column of the knight.
     * @param isBlack   The color of the knight.
     */

    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Checks if a move to a destination square is legal.
     * @param board     The game board.
     * @param endRow    The row of the destination square.
     * @param endCol    The column of the destination square.
     * @return True if the move to the destination square is legal, false otherwise.
     */

    public boolean isMoveLegal(Board board, int endRow, int endCol) {

        /*
         - Checks if the movement of Knight is L-shaped

         - Other checks on the movement of a piece is performed
           in movePiece (Accessor method of Board class) using
           verifySourceAndDestination (Accessor method of Board class)
        */

        if ((Math.abs(this.row - endRow) == 2 && Math.abs(this.col - endCol) == 1) || (Math.abs(this.row - endRow) == 1 && Math.abs(this.col - endCol) == 2)) {         // Check for L-shaped movement.
            return true;
        }
        return false;
    }

    private int row;
    private int col;
    private boolean isBlack;
}
