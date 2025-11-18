אנה סספורטה 337664932
איוב 326305398
public class Character {
	
	private String name;
	private int health;
	private int level;
	
	
	public Character () {
		name = "Unknown";
		health = 0;
		level = 0;
	}
	
	public Character (String name, int health, int level) {
		this.name = name;
		if (health >= 0 && health <=10)
			this.health = health;
		else 
			this.health = 0;
		if (level >=0 && level <= 5)
			this.level = level;
		else 
			this.level = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth () {
		return health;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void levelUp () {
		if (level < 5)
			level++;
	}
	
	public void heal (int amount) {
		if (amount <= 0)
			return;
		if ((this.health + amount) > 10)
			this.health = 10;
		else
			this.health += amount;
	}
	
	public String toString () {
		return ("Name : " + name + "\n Health: " + health + "\n Level: " + level);
	}
	
	public void setHealth(int newHealth) { // פונקצית עזר לפונקציה attack
		if (newHealth >= 0 && newHealth <= 10)
			health = newHealth;
	}
	
	

}