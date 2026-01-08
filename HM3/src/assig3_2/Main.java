//אנה סספורטה 337664932
//איוב 326305398
package assig3_2;

public class Main {

    public static void main(String[] args) {

        GamePlay game = new GamePlay();

        Gamer player1 = new Gamer(game, "player 1");
        Gamer player2 = new Gamer(game, "player 2");

        Judge judge = new Judge(game);
  
        judge.start();
        player1.start();
        player2.start();

        try {
            player1.join();
            player2.join();
        } catch (InterruptedException e) {}
     
        judge.interrupt();
 
        if (player1.getScore() > player2.getScore()) {
            System.out.println("player 1 wins");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println("player 2 wins");
        } else {
            System.out.println("tie");
        }
    }
}
