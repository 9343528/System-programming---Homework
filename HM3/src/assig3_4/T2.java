//אנה סספורטה 337664932
//איוב 326305398
package assig3_4;
public class T2 extends Thread {

    private SyncManager sm;

    public T2(SyncManager sm) {
        this.sm = sm;
    }

    public void run() {
        while (true) {
            synchronized (sm) {
                while (sm.turn != 2) {
                    try {
                        sm.wait();
                    } catch (InterruptedException e) {}
                }

                System.out.print("B");
       
                sm.turn = 3;
                sm.notifyAll();
            }
        }
    }
}

