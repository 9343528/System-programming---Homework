//אנה סספורטה 337664932
//איוב 326305398
package assig3_2;

public class Judge extends Thread {

    private GamePlay game;

    public Judge(GamePlay game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {       
                game.makeCoinAvail(false);
                sleep(1000);
          
                game.makeCoinAvail(true);
                sleep(500);
            } catch (InterruptedException e) {
                interrupt();
        }
      }
   }
}

	
	
	
	

