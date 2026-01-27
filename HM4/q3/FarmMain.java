//אנה סספורטה 337664932
//איוב 326305398

import java.util.Scanner;

public class FarmMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cows (N): ");
        int n = sc.nextInt();

        SharedResources res = new SharedResources(n);
        Compounds comp = new Compounds(n);

        for (int i = 1; i <= n; i++) {
            new CowThread(i, res, comp).start();
        }
        
        sc.close();
    }
}