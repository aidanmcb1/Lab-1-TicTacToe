package edu.cscc;

public class Main {

    public static void main(String[] args) {
        final byte[] EMPTY_BOARD = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        final byte[] XWINS1 = {1, 1, 1, -1, -1, 0, -1, 0, 0};
        final byte[] XWINS2 = {1, -1, -1, 1, 0, -1, 1, 0, 0};
        final byte[] XWINS3 = {1, -1, -1, 0, 1, 0, -1, 0, 1};
        final byte[] XWINS4 = {-1, -1, 1, 0, 1, 0, 1, 0, -1};
        final byte[] OWINS1 = {1, 1, -1, 1, 0, -1, 0, 0, -1};
        final byte[] TIE = {1, 1, -1, -1, -1, 1, 1, -1, 1};
        final byte[][] samples = {EMPTY_BOARD, XWINS1, XWINS2, XWINS3, XWINS4, OWINS1, TIE};

        TicTacToe ttt;

        for (byte[] arr : samples) {
            try {
                ttt = new TicTacToe(arr);
                ttt.displayBoard();
                ttt.findWinner(arr);
                System.out.println();
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        }
    }
}
