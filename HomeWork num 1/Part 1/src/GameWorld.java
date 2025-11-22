//אנה סספורטה 337664932
//איוב 326305398

public class GameWorld {
	private String name;
	Player[] players;
	Enemy[] enemies;
	int difficulty;
	
	private static int SIZE = 5;
	
	public GameWorld () {
		name = "Crystalpath";
		difficulty = 1;
		players = new Player [SIZE];
		enemies = new Enemy [SIZE];
	}

    public GameWorld (String name, int difficulty, Player[] players, Enemy[] enemies) {
		this.name = name;
		this.difficulty = difficulty;
		this.players = players;
		this.enemies = enemies;
	}
    
    public void addPlayer (Player player) {
        if (player != null) {
        int count;
            for (count = 0; count < players.length; count++) {
                if (players[count] == null) {
                    players[count] = player;
                    break;
                }
            }
            if (count == players.length){ //הגדלת מערך שחקנים
                // allocate a larger array and keep existing order intact
                Player [] temp = new Player [players.length + SIZE];
                for (int i=0; i<players.length; i++) {
                    temp[i] = players[i];
                }
                temp [players.length] = player;
                players = temp;
            }
            
        }
    }

    public void printAllPlayers () {
        int count = 1;
        for (int i = 0; i < players.length && players[i] != null; i++) {
            System.out.println(" ------Player " + count + "------");
            System.out.println(players[i].toString());
            count++;
        }
    }
    
    public int getTotalValueOfWorld() {
        int total = 0;
        for (int i = 0; i < players.length && players[i] != null; i++) {
            total += players[i].calculateInventoryValue();
        }
        return total;
    }

    public String toString () {
        String info = "Game World: " + name + "\nDifficulty: " + difficulty + "\n";
        int count = 0;
        for (int i = 0; i < players.length && players[i] != null; i++) {
            count++;
        }
        info += "Number of players: " + count + "\n";
        return info;
    }

    


}
