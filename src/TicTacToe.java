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

    static void printBoard(char[] ttt) {
        //int row = ;
        for (int x = 0; x < 3; x++) {
            System.out.printf("                 %c | %c | %c%n",
                    ttt[x * 3], ttt[x * 3 + 1], ttt[x * 3 + 2]);
            if (x < 2)
                System.out.println("                ---|---|---");
        }
    }

    static char takeTurn(char[] ttt, char player) {
        int p;
        while (true) {
            System.out.print("Player " + player + ", choose a position: ");
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
        ttt[p - 1] = player;
        return findWinner(ttt);
    }

    static char findWinner(char[] ttt) {
        // test for winner in row
        for (int r = 0; r < 3; r++) {
            int i = r * 3;
            if (ttt[i] != ' ' && ttt[i] == ttt[i + 1] && ttt[i + 1] == ttt[i + 2]) {
                return ttt[i];
            }
        }

        // test for winner in column
        for (int c = 0; c < 3; c++) {
            if (ttt[c] != ' ' && ttt[c] == ttt[c + 3] && ttt[c + 3] == ttt[c + 6]) {
                return ttt[c];
            }
        }

        // diagonals
        if (ttt[0] == ttt[4] && ttt[4] == ttt[8])
            return ttt[0];
        if (ttt[2] == ttt[4] && ttt[4] == ttt[6])
            return ttt[2];

        return ' ';
    }

    static void main() {
        char[] ttt = {
                ' ', ' ', ' ',
                ' ', ' ', ' ',
                ' ', ' ', ' '};
        char winner = ' ';

        printInstructions();

        int spaceRemaining = 9;
        while (spaceRemaining > 0) {
            // process player 1 turn
            printBoard(ttt);
            winner = takeTurn(ttt, 'X');
            spaceRemaining--;
            if (winner != ' ')
                break;

            // draw happens after player 1 turn.
            if (spaceRemaining == 0)
                break;

            // process player 2 turn
            printBoard(ttt);
            winner = takeTurn(ttt, 'O');
            spaceRemaining--;
            if (winner != ' ')
                break;
        }
        if (spaceRemaining > 0)
            System.out.println("\nCongratulations! '" + winner + "' has won!\n");
        else
            System.out.println("\nThe game was a draw!\n");
    }
}
