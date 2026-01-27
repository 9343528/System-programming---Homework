//אנה סספורטה 337664932
//איוב 326305398

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedResources {
    // סמפורים לניהול כמות הפרות בכל מתחם [cite: 161]
    public final Semaphore haySema = new Semaphore(5);   // עד 5 בחציר
    public final Semaphore waterSema = new Semaphore(3); // עד 3 בשוקת
    
    // מונה כדי לוודא שכולן סיימו לפני הטיול [cite: 162]
    public final CountDownLatch finishedEatingAndDrinking;
    
    // מונים לצורך בדיקת תקינות במחלקת Compounds [cite: 172]
    public final AtomicInteger countHay = new AtomicInteger(0);
    public final AtomicInteger countWater = new AtomicInteger(0);

    public SharedResources(int n) {
        this.finishedEatingAndDrinking = new CountDownLatch(n);
    }
}