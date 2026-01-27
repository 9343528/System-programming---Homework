//אנה סספורטה 337664932
//איוב 326305398

public class Compounds {
    private boolean[] hasEaten;

    public Compounds(int n) {
        this.hasEaten = new boolean[n + 1];
    }

    public void eat(int id, SharedResources res) {
        int current = res.countHay.incrementAndGet();
        if (current > 5) {
            System.out.println("Error: Cow " + id + " entered Hay, but there are " + current + " cows there!");
        }
        System.out.println("Cow " + id + " is eating hay.");
        hasEaten[id] = true;
    }

    public void drink(int id, SharedResources res) {
        if (!hasEaten[id]) {
            System.out.println("Error: Cow " + id + " tried to drink before eating hay!");
        }
        int current = res.countWater.incrementAndGet();
        if (current > 3) {
            System.out.println("Error: Cow " + id + " entered Water, but there are " + current + " cows there!");
        }
        System.out.println("Cow " + id + " is drinking water.");
    }

    public void walk(int id) {
        System.out.println("Cow " + id + " is walking.");
    }

    public void leaveHay(SharedResources res) {
        res.countHay.decrementAndGet();
    }

    public void leaveWater(SharedResources res) {
        res.countWater.decrementAndGet();
    }
}