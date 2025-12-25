//אנה סספורטה 337664932
//איוב 326305398

package Game;

public class SelfGame extends Game {
    public void startGame() {
        new SelfPlayer(this, Cell.X).start();
        new SelfPlayer(this, Cell.O).start();
    }
}