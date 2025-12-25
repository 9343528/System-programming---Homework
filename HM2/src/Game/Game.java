//אנה סספורטה 337664932
//איוב 326305398

package Game;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    protected Cell[][] gameBoard = new Cell[5][5];
    protected volatile boolean gameOver = false;
    protected Cell winner = null;
    protected Cell currentTurn = Cell.X; // X תמיד מתחיל

    public Game() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameBoard[i][j] = Cell.EMPTY;
            }
        }
    }

    // החזרת סוג השחקן שתורו לשחק
    public Cell getTurn() {
        return this.currentTurn;
    }

    // מעבר לתור הבא
    public synchronized void nextTurn() {
        if (this.currentTurn == Cell.X) {
            this.currentTurn = Cell.O;
        } else {
            this.currentTurn = Cell.X;
        }
    }

    // החזרת כל התאים הפנויים בלוח
    public synchronized List<int[]> getFreeCells() {
        List<int[]> free = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == Cell.EMPTY) {
                    free.add(new int[]{i, j});
                }
            }
        }
        return free;
    }

    public synchronized boolean placeMove(int row, int col, Cell type) {
        if (!gameOver && gameBoard[row][col] == Cell.EMPTY) {
            gameBoard[row][col] = type;
            checkWinner(type);
            return true;
        }
        return false;
    }

    public synchronized boolean isBoardFull() {
        return getFreeCells().isEmpty();
    }

    public synchronized void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] == Cell.EMPTY ? ". " : gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
        
    }

    protected synchronized void checkWinner(Cell type) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // בדיקת 4 ברצף: אופקי, אנכי, אלכסון יורד, אלכסון עולה
                if (j <= 1 && checkLine(i, j, 0, 1, type)) return; 
                if (i <= 1 && checkLine(i, j, 1, 0, type)) return; 
                if (i <= 1 && j <= 1 && checkLine(i, j, 1, 1, type)) return; 
                if (i >= 3 && j <= 1 && checkLine(i, j, -1, 1, type)) return; 
            }
        }
    }

    private boolean checkLine(int r, int c, int dr, int dc, Cell type) {
        if (gameBoard[r][c] == type &&
            gameBoard[r + dr][c + dc] == type &&
            gameBoard[r + 2 * dr][c + 2 * dc] == type &&
            gameBoard[r + 3 * dr][c + 3 * dc] == type) {
            gameOver = true;
            winner = type;
            return true;
        }
        return false;
    }
}