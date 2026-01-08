//אנה סספורטה 337664932
//איוב 326305398
package assig3_3;

public class SlicerThread extends Thread {

    private SlicerMachine machine;

    public SlicerThread(SlicerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        while (machine.getNumOfPreparedSalads() < machine.getMaxSalads()) {
            machine.sliceVegetables();
            try {
                sleep(100);
            } catch (InterruptedException e) { return;}
        }
    }
}

