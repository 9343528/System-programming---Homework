//אנה סספורטה 337664932
//איוב 326305398

//אנה סספורטה 337664932
//איוב 326305398
package assig3_3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        
        do {
        System.out.println("Please Type How Many Salads To Prepare:");
        n = sc.nextInt();
        if (n<=0)
        	System.out.println("Please insert a positive number");
        }while (n<=0);
        

        System.out.println("Preparing " + n + " Salads...");

        SlicerMachine machine = new SlicerMachine(n);

        Thread cuc = new CucumberThread(machine);
        Thread tom = new TomatoesThread(machine);
        Thread oni = new OnionThread(machine);
        Thread slicer = new SlicerThread(machine);

        cuc.start();
        tom.start();
        oni.start();
        slicer.start();

        try {
            cuc.join();
            tom.join();
            oni.join();
            slicer.join();
        } catch (InterruptedException e) {
        }

        System.out.println("Done");
        sc.close();
    }
}

