// Written by Tamojit Bera, bera0041 and Srinivas Preetham Addepalli, addep011

import java.lang.Math;
public class Board {

    // Instance variables
    private Piece[][] board;
    private int c;


    // Constructs an object of type Board using given arguments.
    public Board() {
        this.board = new Piece[8][8];
        c = 0;
    }

    // Accessor Methods


    // Returns the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }


    // Updates a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    // Game functionality methods


    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    // This method calls all necessary helper functions to determine if a move
    // is legal, and to execute the move if it is. Your Game class should not 
    // directly call any other method of this class.
    // Hint: this method should call isMoveLegal() on the starting piece. 
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        boolean isBlackValue;
        if (c % 2 == 0) {
            isBlackValue = false;
        } else {
            isBlackValue = true;
        }
        if (this.verifySourceAndDestination(startRow, startCol, endRow, endCol, isBlackValue)) {            // Checks if the source and destination of the move are valid for the piece of given color
            Piece currentPiece = this.getPiece(startRow, startCol);
            if (currentPiece.isMoveLegal(this, endRow, endCol)) {                                     // Checks if the move is valid for the particular piece (King, Queen, Rook, Bishop, Knight or Pawn)
                this.setPiece(endRow, endCol, currentPiece);                                                // If move is valid, changes the piece at. the destination square to the current piece
                currentPiece.setPosition(endRow, endCol);                                                   // Updates new location of the current piece to endRow and endCol
                this.setPiece(startRow, startCol, null);                                              // If move is valid, changes the piece at the destination square to null (empty square)
                c ++;
                if (this.getPiece(endRow, endCol).getCharacter() == '\u2659' || this.getPiece(endRow, endCol).getCharacter() == '\u265f') {
                    boolean promotion = this.getPiece(endRow, endCol).pawnPromotion();                     // If piece is a pawn checks if promotion is possible
                }
                return true;
            } else {
                System.out.println("Invalid Move. Try Again.");                                            // Re-prompt move if invalid
                return false;
            }
        } else {
            System.out.println("Invalid Move. Try Again");                                                 // Re-prompt move if invalid
            return false;
        }
    }


    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {

        // Loops through the entire chessboard and initiates game end if there is only one King on the board

        int chk = 0;                    // Counter for checking the number of Kings on the board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPiece(i, j) == null) {
                }
                else if (this.getPiece(i, j).getCharacter() == '\u265a' || this.getPiece(i, j).getCharacter() == '\u2654') {        // Checks if a piece is a King
                    chk++;          // Increases the counter if a piece is a King
                }
            }
            if (chk == 2) {
                return false;
            }
        }
        return  true;
    }


    // Constructs a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String retStr = "";
        retStr += " \u30000\u30001\u30002\u30003\u30004\u30005\u30006\u30007\u3000\n";
        for (int i = 0; i < 8; i++) {                                           // Loops through rows
            retStr += i + "|";
            for (int j = 0; j < 8; j++) {                                       // Loops through columns
                if (this.getPiece(i, j) != null) {                              // Piece character if square is occupied
                    retStr += this.getPiece(i, j).getCharacter() + "|";
                } else {                                                        // Empty space if square is unoccupied
                    retStr += "\u3000" + "|";
                }
            }
            retStr += "\n";
        }
        return retStr;
    }


    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.board[i][j] = null;
            }
        }
    }

    // Movement helper functions


    // Ensures that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow >= 0 && startRow < this.board.length && startCol >= 0 && startCol < this.board[1].length && endRow >= 0 && endRow < this.board.length && endCol >= 0 && endCol < this.board[1].length && this.getPiece(startRow, startCol) != null && this.getPiece(startRow, startCol).getIsBlack() == isBlack && (this.getPiece(endRow, endCol) == null || this.getPiece(endRow, endCol).getIsBlack() != isBlack)) {
            return  true;
        }
        return false;
    }


    // Checks whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow - startRow) < 2 && Math.abs(endCol - startCol) < 2) {
            return  true;
        }
        return false;
    }

    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.

    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {                                   // Checks if source and destination are Horizontal
            if (startCol < endCol) {                                // For moving horizontally right
                for (int i = startCol + 1; i < endCol; i++) {
                    if (this.getPiece(startRow, i) != null) {
                        return false;
                    }
                }
            } else if (startCol > endCol) {                         // For moving horizontally left
                for (int i = endCol + 1; i < startCol; i++) {
                    if (this.getPiece(startRow, i) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }


    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        if (startCol == endCol) {                                   // Checks if source and destination are Vertical
            if (startRow < endRow) {                                // For moving vertically down
                for (int i = startRow + 1; i < endRow; i++) {
                    if (this.getPiece(i, startCol ) != null) {
                        return false;
                    }
                }
            } else if (startRow > endRow) {                         // For moving vertically up
                for (int i = endRow + 1; i < startRow; i++) {
                    if (this.getPiece(i, startCol ) != null) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }


    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        if (Math.abs(endRow - startRow) == Math.abs(endCol - startCol)) {           // Checks if source and destination are diagonal

            // 4 conditions for 4 outward diagonals from a square

            if ((startRow < endRow) && (startCol < endCol)) {
                while ((startRow < endRow - 1) && (startCol < endCol - 1)) {
                    if (this.getPiece(++startRow, ++startCol) != null) {
                        return false;
                    }
                }
                return true;
            } else if ((startRow > endRow) && (startCol > endCol)) {
                while ((startRow > endRow + 1) && (startCol > endCol + 1)) {
                    if (this.getPiece(--startRow, --startCol) != null) {
                        return false;
                    }
                }
                return true;
            } else if ((startRow < endRow) && (startCol > endCol)) {
                while ((startRow < endRow - 1) && (startCol > endCol + 1)) {
                    if (this.getPiece(++startRow, --startCol) != null) {
                        return false;
                    }
                }
                return true;
            } else {
                while ((startRow > endRow + 1) && (startCol < endCol - 1)) {
                    if (this.getPiece(--startRow, ++startCol) != null) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
