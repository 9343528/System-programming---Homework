//אנה סספורטה 337664932
//איוב 326305398
package assig3_2;


public class Gamer extends Thread {

    private int goodFlipsCounter = 0;
    private GamePlay game;

    public Gamer(GamePlay game, String name) {
        super(name);
        this.game = game;
    }

    public void play() {
        while (!isInterrupted() && game.getNumOfRounds() < 10) {
            int rec= game.flipCoin();
            if (rec == 1) {
                goodFlipsCounter++;
            }

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }

    public int getScore() {
        return goodFlipsCounter;
    }

    @Override
    public void run() {
        play();
    }
}

	 
	 

