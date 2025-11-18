אנה סספורטה 337664932
איוב 326305398

public class Game {
	
	public static void simulateBattle(Player player1, Enemy enemy1){
		System.out.println(player1.getName() + " - level:" + player1.getLevel() + " VS " + enemy1.getName() + " - level:" + enemy1.getLevel());
		while (player1.getHealth() > 0 && enemy1.getHealth() > 0) {
			// each round both sides act, starting with the player
			player1.attack(enemy1);
			if (enemy1.getHealth > 0)
				enemy1.attack(player1);
		}
		if (player1.getHealth() > 0) {
			System.out.println(player1.getName() + " wins!");
			player1.levelUp();
		} else {
			System.out.println(enemy1.getName() + " wins!");
			enemy1.levelUp();
		}

	}


	public static void main(String[] args) {
		Item item1 = new Item("Sword", 10, true);
		Item item2 = new Item("Shield", 5, false);
		Item item3 = new Item("Axe", 3, false);
		Item item4 = new Item("Potion", 2, false);

		Player player1 = new Player("John", 10, 1);
		Player player2 = new Player("Jane", 8, 1);
		Player player3 = new Player("Jim", 6, 1);

		player1.addItem(item1);
		player1.addItem(item2);
		player1.addItem(item3);

		player2.addItem(item1);
		player2.addItem(item4);

		player3.addItem(item2);

		Enemy enemy1 = new Enemy("Orc", 8, 2, 2);
		
		Player[] players = new Player [] {player1, player2};
		Enemy [] enemies = new Enemy [] {enemy1};

		GameWorld world = new GameWorld("World of Warcraft", 1, players, enemies);
		world.addPlayer(player3);

		world.printAllPlayers();
		

		System.out.println ("Player 1: " + player1.getName() + " has " + player1.calculateInventoryValue() + " value in inventory");
		System.out.println ("Player 2: " + player2.getName() + " has " + player2.calculateInventoryValue() + " value in inventory");
		System.out.println ("Player 3: " + player3.getName() + " has " + player3.calculateInventoryValue() + " value in inventory");


		simulateBattle(player1, enemy1);
	
	
	}

}



