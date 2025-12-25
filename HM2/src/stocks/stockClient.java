//אנה סספורטה 337664932
//איוב 326305398

package stocks;

public class stockClient {

	public static void main(String[] args) {
		StockServer s = new StockServer();
		Person p1 = new Person ("Tami Tan", s);
		Person p2 = new Person ("Tim Sruli", s);
		Person p3 = new Person ("Sima Didas", s);
		Thread thP1 = new Thread (p1);
		Thread thP2 = new Thread (p2);
		Thread thP3 = new Thread (p3);

		thP1.start();
		thP2.start();
		thP3.start();
		
		s.start();
		
		try {
		thP1.join();
		thP2.join();
		thP3.join();
		s.join();
		}
	catch (InterruptedException e) {
		e.printStackTrace();
	}


		
	}

}
