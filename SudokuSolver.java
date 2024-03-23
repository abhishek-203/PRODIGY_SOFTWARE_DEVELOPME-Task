public class SudokuSolver {

    public static void main(String[] args) {
        int[][] sudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(sudokuBoard)) {
            System.out.println("Sudoku solved successfully:");
            printSudokuBoard(sudokuBoard);
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveSudoku(int[][] board) {
        int[] emptyLocation = findEmptyLocation(board);

        // If there is no empty location, the Sudoku puzzle is solved
        if (emptyLocation == null) {
            return true;
        }

        int row = emptyLocation[0];
        int col = emptyLocation[1];

        // Try placing numbers from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                // Place the number if it's safe
                board[row][col] = num;

                // Recursively solve the rest of the puzzle
                if (solveSudoku(board)) {
                    return true;
                }

                // If placing 'num' leads to an invalid solution, backtrack
                board[row][col] = 0;
            }
        }

        // No valid number found, backtrack
        return false;
    }

    private static int[] findEmptyLocation(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check if 'num' is not present in the current row and column
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        // Check if 'num' is not present in the current 3x3 subgrid
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printSudokuBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
