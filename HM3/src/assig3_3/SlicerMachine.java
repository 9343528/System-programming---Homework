//אנה סספורטה 337664932
//איוב 326305398
package assig3_3;

public class SlicerMachine {

    private int cucumbers = 0;
    private int tomatoes = 0;
    private int onions = 0;

    private int preparedSalads = 0;
    private int maxSalads;

    public SlicerMachine(int maxSalads) {
        this.maxSalads = maxSalads;
    }

    public synchronized void addOneCucumber() {
        while (cucumbers == 5 && preparedSalads < maxSalads) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        if (preparedSalads >= maxSalads) return;

        cucumbers++;
        System.out.println("adding one cucumber to the machine");
        notifyAll();
    }

    public synchronized void addOneTomato() {
        while (tomatoes == 3 && preparedSalads < maxSalads) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        if (preparedSalads >= maxSalads) return;

        tomatoes++;
        System.out.println("adding one tomato to the machine");
        notifyAll();
    }

    public synchronized void addOneOnion() {
        while (onions == 1 && preparedSalads < maxSalads) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }

        if (preparedSalads >= maxSalads) return;

        onions++;
        System.out.println("adding one onion to the machine");
        notifyAll();
    }

    public synchronized void sliceVegetables() {
        while (!(onions == 1 && cucumbers == 5 && tomatoes == 3)
                && preparedSalads < maxSalads) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        
        preparedSalads++;
        if (preparedSalads >= maxSalads) return;
        
        System.out.println("== preparing one more salad ==");
        

        cucumbers = 0;
        tomatoes = 0;
        onions = 0;

        notifyAll();
    }

    public synchronized int getNumOfPreparedSalads() {
        return preparedSalads;
    }

    public int getMaxSalads() {
        return maxSalads;
    }
}

