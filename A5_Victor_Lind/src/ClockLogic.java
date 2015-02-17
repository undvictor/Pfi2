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
		realHour = hours;
		realMinute = minutes;
		System.out.println(alarmHour + " " + alarmMinute);
		System.out.println(realHour + " " + realMinute);
		if(alarmHour == realHour && alarmMinute == realMinute){
			System.out.println("inne i SetAlarm");
			clockGUI.alarm(true);
		}else{
			//DO NOTHING
		}
		
	}

}
