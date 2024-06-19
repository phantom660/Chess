// Written by Tamojit Bera, bera0041 and Srinivas Preetham Addepalli, addep011

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Create a new instance of the Board class
        Board b = new Board();
        // Load the starting position of a chess game using FEN and set it to the board
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", b);
        Scanner myScanner = new Scanner(System.in);
        int c = 0;
        // Start a loop to play the game until it's over
        while (true) {
            System.out.println(b);
            // Check if the game is over
            if (b.isGameOver()) {
                // Print the result of the game based on the last player to move
                if (c % 2 == 0) {
                    System.out.println("Black has won the game!");
                } else {
                    System.out.println("White has won the game!");
                }
                // Exit the loop and end the game
                break;
            }
            // If the game is not over and it's currently white's turn to move
            else if (c % 2 == 0) {
                // Ask the user for their move in the specified format and read the input
                System.out.println("It is currently white's turn to play.\nWhat is your move? (format: [start row][start col][end row][end col])");
                int startRow = myScanner.nextInt();
                int startCol = myScanner.nextInt();
                int endRow = myScanner.nextInt();
                int endCol = myScanner.nextInt();
                // Move the piece on the board if the move is valid, and increment the move
                // counter if successful
                boolean move = b.movePiece(startRow, startCol, endRow, endCol);
                if (move == true) {
                    c++;
                }
            }
            // If the game is not over and it's currently black's turn to move
            else {
                System.out.println("It is currently black's turn to play.\nWhat is your move? (format: [start row][start col][end row][end col])");
                int startRow = myScanner.nextInt();
                int startCol = myScanner.nextInt();
                int endRow = myScanner.nextInt();
                int endCol = myScanner.nextInt();
                // Move the piece on the board if the move is valid, and increment the move
                // counter if successful
                boolean move = b.movePiece(startRow, startCol, endRow, endCol);
                if (move == true) {
                    c++;
                }
            }
        }
    }
}