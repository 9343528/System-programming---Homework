//אנה סספורטה 337664932
//איוב 326305398

package Game;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Game game;

        System.out.println("Welcome to X O!");
        System.out.println("Choose game mode:");
        System.out.println("1. Self Game");
        System.out.println("2. User Game");
        
        int choice = input.nextInt();

        // יצירת המשחק והשחקנים המתאימים בהתאם לבחירה
        if (choice == 1) {
            game = new SelfGame();
            System.out.println("Starting Self Game...");
            ((SelfGame) game).startGame();
        } else {
            game = new UserGame();
            System.out.println("Starting User Game...");
            ((UserGame) game).startGame();
        }

        // לולאה שממתינה לסיום המשחק כדי להדפיס את התוצאה הסופית
        while (!game.gameOver) {
            try {
                Thread.sleep(1000); // המתנה קצרה כדי לא להעמיס על המעבד
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // הדפסת המנצח בסיום
        System.out.println("\n*** GAME OVER ***");
        game.printBoard();
        if (game.winner != null) {
            System.out.println("The winner is: " + game.winner);
        } else {
            System.out.println("It's a draw! (Board is full)");
        }
        
        input.close();
    }
}