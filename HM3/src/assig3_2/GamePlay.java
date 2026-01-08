//אנה סספורטה 337664932
//איוב 326305398
package  assig3_2;

public class GamePlay {

    private boolean coin_available_ = true;
    private int rounds_counter_ = 0;

    public synchronized void makeCoinAvail(boolean val) {
    	coin_available_ = val;
        if (val) {
            notifyAll();
        }
    }

    public synchronized int flipCoin() {
        while (!coin_available_) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for coin");
                wait();
            } catch (InterruptedException e) {
            	Thread.currentThread().interrupt();
                return -1;
            }
        }

        System.out.println(Thread.currentThread().getName() + " is flipping coin");
        coin_available_ = false;

        rounds_counter_++;

        int result = (int)(Math.random() * 2);

        makeCoinAvail(true);

        return result;
    }

    public synchronized int getNumOfRounds() {
        return rounds_counter_;
    }
}

