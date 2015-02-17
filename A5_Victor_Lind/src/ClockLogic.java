public class ClockLogic implements ClockInterface {

	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	private int realHour;
	private int realMinute;
	
	
	public ClockLogic(DigitalClockGUI clockin) {
		this.clockGUI = clockin;
		Thread t = new ClockThread(this);
		t.start();
	}

	public void setAlarm(int hours, int minute) {
		alarmHour = hours;
		alarmMinute = minute;		

		if(alarmHour == realHour && alarmMinute == realMinute){
			System.out.println("inne i SetAlarm");
			clockGUI.alarm(true);
		}else{
			//DO NOTHING
		}
	
	}

	public void clearAlarm() {
		// allt som skulle kunna hamna här ligger i alarmfunktionen i gui-klassen istället.
		// Jag resonerar att använda så pass hård bindning mellan klasser vore värre än att föra in lite logik i gui-klassen
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
		

		
		String hourZero = ""; String minuteZero = ""; String secondZero = "";

		if (hours < 10) {
			hourZero = "0";
		}if (minutes < 10) {
			minuteZero = "0";
		}if (seconds < 10) {
			secondZero = "0";
		}
		
		//konvertera till String
		String hourString =   hourZero   + Integer.toString(hours);
		String minuteString = minuteZero + Integer.toString(minutes);
		String secondString = secondZero + Integer.toString(seconds);
		
		// packa in i en huvudString
		String masterString = hourString + " : " + minuteString + " : " + secondString;
		
		//Skicka in till GUI:t
		clockGUI.setTimeOnLabel(masterString);
		
		//variabler för larmchecken
		realHour = hours;
		realMinute = minutes;
		
		//om larmtiden och realtid matchar, kör alarmfunktionen i gui-klassen
		if(alarmHour == realHour && alarmMinute == realMinute){
			System.out.println("inne i SetAlarm");
			clockGUI.alarm(true);
		}else{
			//DO NOTHING
		}
		
	}

}
