public class SudokuSolver {
    public static boolean solveSudoku(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        
        // Find the next empty cell to fill
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }
        
        // If there are no empty cells, the puzzle is solved
        if (isEmpty) {
            return true;
        }
        
        // Try filling the empty cell with numbers 1-9
        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                
                // Recursively try to fill the rest of the board
                if (solveSudoku(board)) {
                    return true;
                }
                
                // If the board can't be solved with the current number, reset the cell
                board[row][col] = 0;
            }
        }
        
        return false;
    }
    
    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        
        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // Check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] board = {
 	           {0,0,5,3,0,0,0,0,0},
 	           {8,0,0,0,0,0,0,2,0},
 	           {0,7,0,0,1,0,5,0,0},
 	           {4,0,0,0,0,5,3,0,0},
 	           {0,1,0,0,7,0,0,0,6},
 	           {0,0,3,2,0,0,0,8,0},
 	           {0,6,0,5,0,0,0,0,9},
 	           {0,0,4,0,0,0,0,3,0},
 	           {0,0,0,0,0,9,7,0,0}
        };
        boolean result = solveSudoku(board);
        if(result) {
        	System.out.println("solved!");
        	printBoard(board);
        }
        else {
        	System.out.println("not solved :(");
        }
        
    }
}