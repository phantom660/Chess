
Group members names:
    - Tamojit Bera, bera0041
    - Srinivas Preetham Addepalli, addep011


How to Complile and run our program:
    - Extract the Project2.zip file
    - Open the Project package in IntelliJ
    - Navigate to Game.java and run the java file using the green "play" button to start a game
    - Every move displays the chessboard in its most current state and prompts a player (Black or White) for next move
    - Game ends when either of the Kings is captured

    NOTE: Game does not work without Pawn.java and Fen.java, which are not included in submission.
    NOTE: Piece classes don't call verifySourceAndDestination(). movePiece() checks if movement to
          square is valid (using verifySourceAndDestination()) and if piece movement is valid
          (using isMoveLegal()).



Contributions of each partner:

    - Tamojit Bera:
          - Rook.java, Knight.java, Bishop.java
          - verifySourceAndDestination(), verifyAdjacent()
          - Game.java
          - Comments
          - README.txt

    - Srinivas Preetham Addepalli:
          - Queen.java, King.java
          - verifyHorizontal(), verifyVertical(), verifyDiagonal()
          - pawnPromotion()
          - Comments
          - README.txt



Assumptions:

    - User enters 'Q', 'R', 'B', 'K' as prompted during pawn promotion. Entering full name of the piece is considered invalid and leads to re-prompt.
    - Movement to same square counts as invalid move and leads to re-prompt.


    
"I certify that the information contained in this README
file is complete and accurate. I have both read and followed the course policies
in the ‘Academic Integrity - Course Policy’ section of the course syllabus."

Tamojit Bera, bera0041
Srinivas Preetham Addepalli, addep011

