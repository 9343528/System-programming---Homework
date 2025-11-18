אנה סספורטה 337664932
איוב 326305398
public class Item {

	private String name;
	private int value;
	private boolean isMagical;
	
	
	public Item () {
		name = "Unknown";
		value = 0;
		isMagical = false;
	}
	
	public Item (String name, int value, boolean isMagical) {
		this.name = name;
		this.value = (value < 0 ? 0 : value);
		this.isMagical = isMagical;
	}
	
	public String toString() {
		String toReturn = "Name : " + name + "\n Value: " + value;
		if (isMagical)
			toReturn = toReturn + "\n Magical item";
		else 
			toReturn = toReturn + "\n Not a magical item";
		
		return toReturn;
	}
	
	
	public int getValue () {
		return value;
	}
	
	public void setValue (int newValue) {
		value = (newValue < 0 ? 0 : newValue);
	}
	
	public boolean isMagical () {
		return isMagical;
	}
	
	public String getName() {
		return name;
	}
	
}
