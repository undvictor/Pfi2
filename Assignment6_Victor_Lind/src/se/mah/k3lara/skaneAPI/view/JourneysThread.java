package se.mah.k3lara.skaneAPI.view;


import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {
	private Parser parser;
	private GUI gui;
	public JourneysThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}
	public void run() {
		gui.textArea_1.setText(null);
		gui.textArea_1.setText("Loading...");
		// code for searching all data relating to a journey
		String searchURL = Constants.getURL(gui.textField_1.getText(),gui.textField_2.getText(), 1); //Malmo C = 80000, Lund C, 81216 Malmo Gatorg 80100, Hässleholm C 93070
		
		//Tar informationen den far fran getJourneys i Parser-klassen och skriver ut startstation, slutstation, nar det gar, om hur lange det ar och hur sen den ar
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			gui.textArea_1.setText(null);
			gui.textArea_1.append(journey.getStartStation()+" - " +journey.getEndStation() + " ");
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			gui.textArea_1.append(" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		}
	}
}