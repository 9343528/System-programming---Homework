אנה סספורטה 337664932
איוב 326305398

public class Enemy extends Character {
	private int damage;
	
	public Enemy (String name, int health, int level, int damage) {
		super(name, health, level);
		if (damage >= 1 && damage <= 5)
			this.damage = damage;
		else 
			this.damage = 1;
	}

	public int getDamage() {
		return damage;
	}
	

	public String toString() {
		String info = super.toString();
		info += "\n Damage: " + damage;
		return info;
	}

	public void attack(Player player) { // SimulateBattle פונקציית עזר לפונקציה 
		if ((player.getHealth() - damage) <= 0 )
			// clamp to zero so health never becomes negative
			player.setHealth(0);
		else
			player.setHealth(player.getHealth() - damage);
	}

}
