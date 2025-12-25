//אנה סספורטה 337664932
//איוב 326305398

package Game;

import java.util.List;
import java.util.Random;

public class SelfPlayer extends Player {
    private Random rand = new Random();

    public SelfPlayer(Game game, Cell type) {
        super(game, type);
    }

    @Override
    public void run() {
        while (!game.gameOver) {
            if (game.getTurn() == this.type) {
                List<int[]> freeCells = game.getFreeCells();
                if (!freeCells.isEmpty()) {
                    int[] move = freeCells.get(rand.nextInt(freeCells.size()));
                    if (game.placeMove(move[0], move[1], type)) {
                        game.printBoard();
                        game.nextTurn();
                    }
                }
            }
            if (game.isBoardFull() && !game.gameOver) {
                System.out.println("Board is full");
                game.gameOver = true;
            }
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }
}