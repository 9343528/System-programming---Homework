import java.util.Random;

//אנה סספורטה 337664932
//איוב 326305398

public class CowThread extends Thread {
    private final int id;
    private final SharedResources res;
    private final Compounds comp;
    private final Random rand = new Random();

    public CowThread(int id, SharedResources res, Compounds comp) {
        this.id = id;
        this.res = res;
        this.comp = comp;
    }

    @Override
    public void run() {
        try {

            res.haySema.acquire(); //חציר
            comp.eat(id, res);
            Thread.sleep((rand.nextInt(9) + 2) * 1000); // 2-10 שניות [cite: 163]
            comp.leaveHay(res);
            res.haySema.release();


            res.waterSema.acquire();//מים
            comp.drink(id, res);
            Thread.sleep((rand.nextInt(9) + 2) * 1000);
            comp.leaveWater(res);
            res.waterSema.release();


            res.finishedEatingAndDrinking.countDown(); //המתנה לכולם
            res.finishedEatingAndDrinking.await();


            comp.walk(id); //טיול
            Thread.sleep((rand.nextInt(9) + 2) * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}