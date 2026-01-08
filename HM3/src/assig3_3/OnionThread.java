//אנה סספורטה 337664932
//איוב 326305398
package assig3_3;

public class OnionThread extends Thread {

    private SlicerMachine machine;

    public OnionThread(SlicerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        while (machine.getNumOfPreparedSalads() < machine.getMaxSalads()) {
            machine.addOneOnion();
            try {
                sleep(300);
            } catch (InterruptedException e) { return; }
        }
    }
}
