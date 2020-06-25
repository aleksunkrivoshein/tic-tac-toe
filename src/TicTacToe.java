import java.util.Scanner;

public class TicTacToe {
    public static boolean xWins(char[] array) {
        boolean xWins = false;
        if (array[0] == 'X' && array[1] == 'X' && array[2] == 'X') {
            xWins = true;
        }
        if (array[3] == 'X' && array[4] == 'X' && array[5] == 'X') {
            xWins = true;
        }
        if (array[6] == 'X' && array[7] == 'X' && array[8] == 'X') {
            xWins = true;
        }
        if (array[0] == 'X' && array[3] == 'X' && array[6] == 'X') {
            xWins = true;
        }
        if (array[1] == 'X' && array[4] == 'X' && array[7] == 'X') {
            xWins = true;
        }
        if (array[2] == 'X' && array[5] == 'X' && array[8] == 'X') {
            xWins = true;
        }
        if (array[0] == 'X' && array[4] == 'X' && array[8] == 'X') {
            xWins = true;
        }
        if (array[2] == 'X' && array[4] == 'X' && array[6] == 'X') {
            xWins = true;
        }
        return xWins;
    }

    public static boolean oWins(char[] array) {
        boolean xWins = false;
        if (array[0] == 'O' && array[1] == 'O' && array[2] == 'O') {
            xWins = true;
        }
        if (array[3] == 'O' && array[4] == 'O' && array[5] == 'O') {
            xWins = true;
        }
        if (array[6] == 'O' && array[7] == 'O' && array[8] == 'O') {
            xWins = true;
        }
        if (array[0] == 'O' && array[3] == 'O' && array[6] == 'O') {
            xWins = true;
        }
        if (array[1] == 'O' && array[4] == 'O' && array[7] == 'O') {
            xWins = true;
        }
        if (array[2] == 'O' && array[5] == 'O' && array[8] == 'O') {
            xWins = true;
        }
        if (array[0] == 'O' && array[4] == 'O' && array[8] == 'O') {
            xWins = true;
        }
        if (array[2] == 'O' && array[4] == 'O' && array[6] == 'O') {
            xWins = true;
        }
        return xWins;
    }

    public static void print(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
            if (i < 2) {
                System.out.println();
            }
        }
        System.out.println("---------");
        System.out.println();
    }

    public static int indexDefinition(int a, int b) {
        int index = 10;
        switch (a) {
            case 1:
                if (b == 1) {
                    index = 6;
                } else if (b == 2) {
                    index = 3;
                } else if (b == 3) {
                    index = 0;
                }
                break;
            case 2:
                if (b == 1) {
                    index = 7;
                } else if (b == 2) {
                    index = 4;
                } else if (b == 3) {
                    index = 1;
                }
                break;
            case 3:
                if (b == 1) {
                    index = 8;
                } else if (b == 2) {
                    index = 5;
                } else if (b == 3) {
                    index = 2;
                }
                break;
        }
        return index;
    }

    public static char[][] array33(char[] array) {
        char[][] array33 = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array33[i][j] = array[k];
                k++;
            }

        }
        return array33;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "_________";
        char[] array = line.toCharArray();
        char[][] array2 = array33(array);
        TicTacToe.print(array2);

        int k = 0;
        while (true) {
            k++;

            System.out.print("Enter the coordinates: ");

            String line1 = scanner.next();
            String line2 = scanner.next();
            int coord1 = 0;
            int coord2 = 0;
            try {
                coord1 = Integer.parseInt(line1);
                coord2 = Integer.parseInt(line2);
            } catch (NumberFormatException e) {
                k--;
                System.out.println("You should enter numbers!");
                continue;
            }
            int index = TicTacToe.indexDefinition(coord1, coord2);
            if (index > 8) {
                k--;
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (array[index] == '_') {
                if (k % 2 == 0) {
                    array[index] = 'O';
                } else {
                    array[index] = 'X';
                }
                char[][] array3 = array33(array);

                TicTacToe.print(array3);
                if (xWins(array) == true) {
                    System.out.println("X wins");
                    break;
                } else if (oWins(array) == true) {
                    System.out.println("O wins");
                    break;
                }
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                k--;

            }

        }

    }
}

