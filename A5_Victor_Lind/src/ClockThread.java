import java.util.Calendar;

public class ClockThread extends Thread {
	
	boolean isOn = true;
	private ClockInterface clockInterface;

	// Klockvariabler;
	int hours, minutes, seconds;

	public ClockThread(ClockInterface ci) {
	    this.clockInterface = ci;
	}

	public void run() {

		while (isOn){
			try {
				Thread.sleep(900);
			} catch (InterruptedException exp) {
				exp.printStackTrace();
			}
			
			Calendar calendar = Calendar.getInstance();
			this.hours = calendar.get(Calendar.HOUR_OF_DAY);
			this.minutes = calendar.get(Calendar.MINUTE);
			this.seconds = calendar.get(Calendar.SECOND);		
			this.clockInterface.update(hours, minutes, seconds);

		}
	}

}
