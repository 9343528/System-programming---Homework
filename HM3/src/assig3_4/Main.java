//אנה סספורטה 337664932
//איוב 326305398
package assig3_4;

public class Main {

    public static void main(String[] args) {

        SyncManager sm = new SyncManager();

        new T1(sm).start();
        new T2(sm).start();
        new T3(sm).start();
        new T4(sm).start();
    }
}

