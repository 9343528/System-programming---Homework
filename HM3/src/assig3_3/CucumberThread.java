//אנה סספורטה 337664932
//איוב 326305398
package assig3_3;

	public class CucumberThread extends Thread {

	    private SlicerMachine machine;

	    public CucumberThread(SlicerMachine machine) {
	        this.machine = machine;
	    }

	    @Override
	    public void run() {
	        while (machine.getNumOfPreparedSalads() < machine.getMaxSalads()) {
	            machine.addOneCucumber();
	            try {
	                sleep(200);
	            } catch (InterruptedException e) { return;}
	      }
	   }
	}

 	

