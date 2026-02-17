import java.util.Scanner;

public class TicTacToe {

    static Scanner kb = new Scanner(System.in);

    static void printInstructions() {
        System.out.println("""

In Tic-Tac-Toe you must get three in a row vertically,
horizontally, or diagonally. Players alternate
starting with player 1 as X and player 2 as O.

On your turn, choose a location not occupied by
selecting the position number. See board below.

                 1 | 2 | 3
                ---|---|---
                 4 | 5 | 6
                ---|---|---
                 7 | 8 | 9
                 
 Let's begin.
 """);
    }

    static void printBoard(char[] tttb) {
        //int row = ;
        for (int x = 0; x < 3; x++) {
            System.out.printf("                 %c | %c | %c%n",
                    tttb[x * 3 + 0], tttb[x * 3 + 1], tttb[x * 3 + 2]);
            if ( x < 2 )
                System.out.println("                ---|---|---");
            //System.out.printf(" %1d | %1d | %1d\n",
                    //x * 3 + 0, x * 3 + 1, x * 3 + 2);
        }
    }

    static void main() {
        char[] ttt = {
                ' ', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '};

        printInstructions();

        boolean haveWinner = false;

        while (! haveWinner) {
            // process player 1 turn
            printBoard(ttt);
            int p;
            while (true) {
                System.out.print("Player 1, choose a position: ");
                p = kb.nextInt();
                if (!(p >= 1 && p <= 9)) {
                    System.out.println("\nYou're selection must be in the range 1-9.\n");
                    continue;
                }
                if (!(ttt[p - 1] == ' ')) {
                    System.out.println("\nPosition " + p + " is occupied by " + ttt[p - 1] + ".\n");
                    continue;
                }
                break;
            }
            ttt[p - 1] = 'X';

            // test for winner in row
            char winner;
            for (int r = 0 ; r < 3; r++) {
                int i = r * 3;
                if (ttt[i + 0] == ttt[i + 1] && ttt[i + 1] == ttt[i + 2]) {
                    winner = ttt[i + 0];
                    break;
                }
            }

            // test for winner in column
            for (int c = 0; c < 3; c++) {
                if (ttt[c + 0] == ttt[c + 3] && ttt[c + 3] == ttt[c + 6]) {
                    winner = ttt[c + 0];
                    break;
                }
            }

            // process player 2 turn
            printBoard(ttt);
            while (true) {
                System.out.print("Player 2, choose a position: ");
                p = kb.nextInt();
                if (!(p >= 1 && p <= 9)) {
                    System.out.println("\nYou're selection must be in the range 1-9.\n");
                    continue;
                }
                if (!(ttt[p - 1] == ' ')) {
                    System.out.println("\nPosition " + p + " is occupied by " + ttt[p - 1] + ".\n");
                    continue;
                }
                break;
            }
            ttt[p - 1] = 'O';
        }
    }
}
