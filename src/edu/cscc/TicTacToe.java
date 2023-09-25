package edu.cscc;

/**
 * TicTacToe board
 * @author Aidan McBride
 */
public class TicTacToe {
    private byte[][] board;

    /**
     * Create a Tic-tac-toe board
     *
     * @param input nine values representing the board (0 - empty, 1 - 'X', -1 - 'O')
     * @throws IllegalArgumentException throw exception if input is invalid
     */
    public TicTacToe(byte[] input) throws IllegalArgumentException {
        if (input.length != 9) {
            throw new IllegalArgumentException("TicTacToe board input must have nine elements");
        }
        board = new byte[3][3];

        int index = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                board[i][j] = input[index++];
            }
        }
    }

    /**
     * Output the board
     */
    public void displayBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                char c = board[i][j] == 0 ? '-' : (board[i][j] == 1 ? 'X' : 'O');
                System.out.printf("%c", c);
            }
            System.out.println();
        }
    }

    /**
     * Display elements of board for debugging purposes
     */
    public void debugBoard() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.printf("board[" + i + "][" + j + "] = " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Determine who won the game (if anyone)
     * Print "X wins", "O wins" or "No one wins"
     */
    public void findWinner(byte[] input) {

        // create variables based on the rows, columns, and diagonals of the board
        int row1 = input[0] + input[1] + input[2];
        int row2 = input[3] + input[4] + input[5];
        int row3 = input[6] + input[7] + input[8];
        int col1 = input[0] + input[3] + input[6];
        int col2 = input[1] + input[4] + input[7];
        int col3 = input[2] + input[5] + input[8];
        int diag1 = input[0] + input[4] + input[8];
        int diag2 = input[2] + input[4] + input[6];

        // combine variables into array for loop
        int[] variables = {row1, row2, row3, col1, col2, col3, diag1, diag2};
        int win = 0;

        // loop to check for if any variable equals 3 or -3
        for (int i = 0; i < input.length - 1; i++) {
            if (variables[i] == 3) {
                win = 1;
                break;
            } else if (variables[i] == -3) {
                win = 2;
                break;
            } else {
                win = 3;
            }
        }
        // print statement
        if (win == 1) {
            System.out.println("X Wins");
        } else if (win == 2) {
            System.out.println("O Wins");
        } else {
            System.out.println("No Winner");
        }
    }
}
