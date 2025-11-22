//אנה סספורטה 337664932
//איוב 326305398

public class Player extends Character {

	private static final int SIZE = 5; // משתנה עזר
	private Item[] inventory;

	public Player(String name, int health, int level) {
		super(name, health, level);
		inventory = new Item[SIZE];
	}

	public Player(String name, int health, int level, Item[] inventory) {
		super(name, health, level);
		if (inventory == null || inventory.length == 0) {
			this.inventory = new Item[SIZE];
		} else {
			this.inventory = new Item[inventory.length];
			for (int i = 0; i < inventory.length; i++) {
				this.inventory[i] = inventory[i];
			}
		}
	}

	public void addItem(Item newItem) {
		if (newItem == null)
			return;
		int index = 0;
		while (index < inventory.length && inventory[index] != null) {
			index++;
		}
		if (index == inventory.length) {
			// grow inventory in fixed-size chunks to minimize reallocations
			Item[] temp = new Item[inventory.length + SIZE];
			for (int i = 0; i < inventory.length; i++) {
				temp[i] = inventory[i];
			}
			inventory = temp;
		}
		inventory[index] = newItem;
	}

	public int calculateInventoryValue() {
		int total = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null)
				// inventories are kept contiguous, so we can stop summing at first gap
				return total;
			total += inventory[i].getValue();
		}
		return total;
	}

	public boolean hasMagicalItem() {
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null)
				return false;
			if (inventory[i].isMagical())
				return true;
		}
		return false;
	}

	public String toString() {
		String info = super.toString();
		info += "\n Inventory : ";
		for (int i = 0; i < inventory.length && inventory[i] != null; i++) {
			if (i == 0)
				info += inventory[i].getName();
			else
				info += " | " + inventory[i].getName();
		}
		return info;
	}

	private int strongestItem() { // פונקציית עזר לפונקציה attack
		int strongest = 0;
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] == null)
				return strongest;
			if (inventory[i].getValue() > strongest)
				strongest = inventory[i].getValue();
		}
		return strongest;
	}

	public void attack(Enemy enemy) { // SimulateBattle פונקציית עזר לפונקציה 
		if (enemy == null)
			return;
		int damage = strongestItem(); // zero damage is valid if no valuable gear
		int newHealth = enemy.getHealth() - damage;
		if (newHealth < 0)
			newHealth = 0;
		enemy.setHealth(newHealth);
	}
}			