//אנה סספורטה 337664932
//איוב 326305398

package Game;

import java.util.Scanner;

public class UserPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public UserPlayer(Game game, Cell type) {
        super(game, type);
    }

    @Override
    public void run() {
        while (!game.gameOver) {
            if (game.getTurn() == this.type) {
                System.out.println("Your turn (" + type + "). Enter row and col (0-4): ");
                int r = scanner.nextInt();
                int c = scanner.nextInt();

                if (r >= 0 && r < 5 && c >= 0 && c < 5 && game.placeMove(r, c, type)) {
                    game.printBoard();
                    game.nextTurn();
                } else {
                    System.out.println("Invalid move, try again.");
                }
            }
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }
    }
}