//אנה סספורטה 337664932
//איוב 326305398

package stocks;

public class Person implements Runnable {
	private String name;
	private StockServer stock;
	
	public Person (String name, StockServer Stock) {
		this.name = name;
		this.stock = Stock;
	}
	

	
	public void run () {
		int time =(int) (Math.random() * 3) + 1;
		int stockType = (int) (Math.random() * 3);
		int i=0;
		int stockValue;
		do {
			
			switch (stockType) {
			case 0 :
				stockValue = stock.GetStock(StockServer.Stock.MICROSOFT);
				System.out.println("Name: " + name + ", Microsoft stock : " + stockValue + " USD");
				break;
			case 1: 
				stockValue = stock.GetStock(StockServer.Stock.APPLE);
				System.out.println("Name: " + name + ", Apple stock : " + stockValue + " USD");
				break;
			case 2:
				stockValue = stock.GetStock(StockServer.Stock.GOOGLE);
				System.out.println("Name: " + name + ", Google stock : " + stockValue + " USD");
				break;
			}
		try {
			Thread.sleep(time*1000);
		}	
		catch (Exception e) {
			System.out.println(e);
		}
		
		time =(int) (Math.random() * 3) + 1;
		stockType = (int) (Math.random() * 3);
		i++;
		}while (i<10);
		
		
		
	}
}
