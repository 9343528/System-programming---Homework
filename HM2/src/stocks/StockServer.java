//אנה סספורטה 337664932
//איוב 326305398

package stocks;

import java.security.InvalidParameterException;

public class StockServer extends Thread {
	
	private int microsoftValue = 220;
	private int appleValue = 110;
	private int googleValue = 1512;
	
	public enum Stock {
		MICROSOFT,
		APPLE,
		GOOGLE
	}	
	
	public synchronized int GetStock(Stock stock) {
		switch(stock) {
		case MICROSOFT:
			return microsoftValue;
		case APPLE:
			return appleValue;
		case GOOGLE:
			return googleValue;
		default:
			throw new InvalidParameterException("no such stock type");
		}
	}
	
	
	public synchronized void UpdateStock (Stock stock, int value) {
		switch(stock) {
		case MICROSOFT:
			microsoftValue = value;
			break;
		case APPLE:
			appleValue = value;
			break;
		case GOOGLE:
			googleValue = value;
			break;
		default:
			throw new InvalidParameterException("no such stock type");
	}
	}
	
	public void run() {
	    int value = 0;
	    try {
	        for (int i = 0; i < 10; i++) {
	            value = (int) (Math.random() * 401) + 100;
	            UpdateStock(Stock.MICROSOFT, value);
	            value = (int) (Math.random() * 401) + 100;
	            UpdateStock(Stock.APPLE, value);
	            value = (int) (Math.random() * 401) + 100;
	            UpdateStock(Stock.GOOGLE, value);
	            Thread.sleep(1000); 
	        }
	    } catch (Exception e) {
	        System.out.println("Server Thread Error: " + e);
	    }
	}
}

