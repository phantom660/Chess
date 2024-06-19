// Written by Tamojit Bera, bera0041 and Srinivas Preetham Addepalli, addep011

public class King {
    /**
     * Constructor.
     * @param row   The current row of the rook.
     * @param col   The current column of the rook.
     * @param isBlack   The color of the rook.
     */

    public King(int row, int col, boolean isBlack) {
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
         - Checks if the movement of King is to an adjacent square

         - Other checks on the movement of a piece is performed
           in movePiece (Accessor method of Board class) using
           verifySourceAndDestination (Accessor method of Board class)
        */

        if (board.verifyAdjacent(this.row, this.col, endRow, endCol)) {         // Check for movement to adjacent square.
            return true;
        }
        return false;
    }

    private int row;
    private int col;
    private boolean isBlack;
}
