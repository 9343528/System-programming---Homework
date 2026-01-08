//אנה סספורטה 337664932
//איוב 326305398
package assig3_4;
public class T1 extends Thread {

    private SyncManager sm;

    public T1(SyncManager sm) {
        this.sm = sm;
    }

    public void run() {
        while (true) {
            synchronized (sm) {
                while (sm.turn != 1) {
                    try {
                        sm.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.print("A");
                sm.aCount++;

                if (sm.aCount == 3) {
                    sm.turn = 2;   
                }

                sm.notifyAll();
            }
        }
    }
}
