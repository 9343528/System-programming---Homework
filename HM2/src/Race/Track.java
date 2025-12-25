//אנה סספורטה 337664932
//איוב 326305398

package Race;

public class Track {
	private int finishedRacers = 0;
	
	public synchronized void increaseFinishedRacers () {
		finishedRacers ++;
	}
	
	public synchronized int getRank () {
		return finishedRacers;
	}
}
