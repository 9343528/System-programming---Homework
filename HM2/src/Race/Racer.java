//אנה סספורטה 337664932
//איוב 326305398

package Race;

public class Racer implements Runnable {
	private static int globalId = 1;
	private int id;
	private int speed;
	private Track track;
	
	private static final Object printLock = new Object(); // מנעול נוסף להדפסה לנונה של הודעת 100 מטר ואז ישר לאחר מכן הודעת סיום מרוץ

	public Racer (int speed, Track track) {
		id = globalId;
		globalId++; //קידום משנתה גלובלי
		if (speed < 1 || speed > 10) { //בדיקת תקינות הקלט
	        System.out.println("Error: speed must be between 1 - 10");
	        this.speed = 1;
	    } else {
	        this.speed = speed;
	    }
		this.track = track;
	}
	
	
	public void go () {
		Thread.currentThread().setPriority(speed);
		for (int i = 1; i <= 100; i++) {
		    if (i < 100) 
		    	synchronized (printLock) {
		        System.out.println("Runner " + this.id + " ran " + i + " meters"); }
		    
		    else 
		    	updateRank(); //סדפסת 100 מטר והודעת סיום מרוץ + הדכון באובייקט של TRACK
		        
		try {   						//הוספתי SLEEP להדפסה מגוונת יותר וחילוף של תהליכונים
            Thread.sleep(100/speed);  //ללא SLEEP כל תהליכון רץ הרבה זמן ולא רואים באמת את החילוף מספיק
        } catch (InterruptedException e) {}

		}
	}
	
	public synchronized void updateRank () { //משתמש באותו מנעול שמשומש להדפסה על מנת להבטיח שלא יהיה תהליכון נוסף שמדפיס תוך כדי והדפסה של 100 מטר וסיום מרוץ קוראת שורה אחרי שורה
		synchronized (printLock) { //מנעול זה נדרש בשביל להבטיח שלא יהיה תהליכון נוסף שמעדכן סיום מרוץ באותו זמן
		synchronized (track) {
			System.out.println("Runner " + this.id + " ran " + 100 + " meters");
	        track.increaseFinishedRacers(); 
			int rank = track.getRank();
	        System.out.println("Runner " + this.id + " finished " + rank + getSuffix(rank));
		}
	    	
	}
}
	

	
	private String getSuffix(int rank) { // הדפסת סיומת אחרונה
	    if (rank == 1) return "st";
	    if (rank == 2) return "nd";
	    if (rank == 3) return "rd";
	    return "th";
	}
	
	public void run() {
		go();
	}
	
}
