//אנה סספורטה 337664932
//איוב 326305398
package assig3_4;
public class T3 extends Thread {

    private SyncManager sm;

    public T3(SyncManager sm) {
        this.sm = sm;
    }

    public void run() {
        while (true) {
            synchronized (sm) {
                while (sm.turn != 3) {
                    try {
                        sm.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.print("C");
                sm.cCount++;

                if (sm.cCount == 2) {
                    sm.cCount = 0;
                    sm.turn = 4;   
                }
                sm.notifyAll();
            }
        }
    }
}

