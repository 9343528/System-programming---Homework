//אנה סספורטה 337664932
//איוב 326305398

package Game;

public abstract class Player extends Thread {
    protected Game game;
    protected Cell type;

    public Player(Game game, Cell type) {
        this.game = game;
        this.type = type;
    }
}
