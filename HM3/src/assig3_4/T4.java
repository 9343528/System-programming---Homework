//אנה סספורטה 337664932
//איוב 326305398
package assig3_4;
public class T4 extends Thread {

    private SyncManager sm;

    public T4(SyncManager sm) {
        this.sm = sm;
    }

    public void run() {
        while (true) {
            synchronized (sm) {
                while (sm.turn != 4) {
                    try {
                        sm.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.print("D");
         
                sm.turn = 2;
                sm.notifyAll();
            }
        }
    }
}

