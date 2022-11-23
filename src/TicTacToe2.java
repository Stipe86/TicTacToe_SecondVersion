import java.util.Scanner;

public class TicTacToe2 {
    static Scanner scan = new Scanner (System.in);

    public static void main(String[] args) {

        System.out.println("\nLet's play tic tac toe");

        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
    };

        printBoard(board);

        for (int i = 0; i < 9; i++) {
            if (i%2==0) {
                System.out.println("Turn: X");
               int [] spot = askUser(board);
               int row = spot[0];
               int column = spot[1];
               board [row] [column] = 'X';
            }
            else {
                System.out.println("Turn: O");
                int [] spot = askUser(board);
                int row = spot[0];
                int column = spot[1];
                board [row] [column] = 'O';
            }
            printBoard(board);

        int count = checkWin(board);

        if (count==3) {
            System.out.println("X wins!");
            break;
        }
        else if (count==-3) {
            System.out.println("O wins!");
            break;
        }

            if (i==8 && count<3 && count>-3) {
                System.out.println("It's a tie");
            }

        }

        scan.close();

    }
    /**
     * Function name - printBoard()
     * @param board (char[][])
     *
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines.
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */

    public static void printBoard(char[][] board) {
        System.out.print("\n");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("\t");
                System.out.print(board[i][j]+" ");
            }
            System.out.print("\n");
            System.out.print("\n");
        }
    }

    /**
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     *
     * Inside the function
     *   1. Asks the user: - pick a row and column number:
     *   2. Change numbers of rows and columns for user to pick to be 1-3 instead of 0-2
     *   3. Check if the number input is appropriate ( not lower than 1 or higher than 3 )
     *   4. Check if the spot is taken. If so, let the user choose again.
     *   5. Return the row and column in an int[] array.
     *
     */

    public static int[] askUser (char[][] board) {
        System.out.print("- pick a row and column number (from 1 1 to 3 3): ");
        int row = scan.nextInt();
        int column = scan.nextInt();

        while (row < 1 || row > 3 || column < 1 || column > 3) {

            System.out.print("Please input number from 1 to 3, try again: ");
            row = scan.nextInt();
            column = scan.nextInt();
        }

        switch (row) {
            case 1 : row = 0; break;
            case 2 : row = 1; break;
            case 3 : row = 2; break;
            default : row = 404;
        }
        switch (column) {
            case 1 : column = 0; break;
            case 2 : column = 1; break;
            case 3 : column = 2; break;
            default: column = 404;
        }


                while ( board[row][column] != '_') {
                    System.out.print("Spot taken, try again: ");
                    row = scan.nextInt();
                    column = scan.nextInt();

                    while (row < 1 || row > 3 || column < 1 || column > 3) {

                        System.out.print("Please input number from 1 to 3, try again: ");
                        row = scan.nextInt();
                        column = scan.nextInt();
                    }



                    switch (row) {
                        case 1 : row = 0; break;
                        case 2 : row = 1; break;
                        case 3 : row = 2; break;
                        default : row = 404;
                    }
                    switch (column) {
                        case 1 : column = 0; break;
                        case 2 : column = 1; break;
                        case 3 : column = 2; break;
                        default: column = 404;
                    }

                }

        return new int[] {row, column};

    }


    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin
     * @param board (char[][])
     * @return count (int)
     *
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */

    public static int checkWin (char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='X'){
                    count++;
                }
              else if(board[i][j]=='O'){
                    count--;
                }
            }
            if (count==3 || count == -3){
                return count;
            }
            else {
                count = 0;
            }

          }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i]=='X') {
                    count++;
                }
                else if (board[j][i]=='O') {
                    count--;
                }
            }
                if (count==3 || count==-3) {
                    return count;
                }
                else {
                    count=0;
                }

        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][i]=='X') {
                count++;
            }
            else if (board[i][i]=='O') {
                count--;
            }
        }
            if (count == 3 || count == -3) {
                return count;
            }
            else {
                count=0;
            }


        for (int i = 0; i < board.length; i++) {
            if (board[i][board.length-1-i]=='X') {
                count++;
            }
            else if (board[i][board.length-1-i]=='O') {
                count--;
            }
        }
            if (count==3 || count==-3) {
                return count;
            }
            else {
                count=0;
            }


        return count;


    }



}
