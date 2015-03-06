package se.mah.k3lara.skaneAPI.view;

import java.util.ArrayList;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class SearchThread extends Thread {
	
	private Parser parser;
	private GUI gui;
	public SearchThread(Parser p, GUI g) {
		this.parser = p;
		this.gui = g;
	}
	public void run() {
		// code for searching stations
		gui.textArea.setText(null);
		gui.textArea.setText("Loading...");
		ArrayList<Station> searchStations = new ArrayList<Station>();
		searchStations.addAll(Parser.getStationsFromURL(gui.textField.getText()));
		gui.textArea.setText(null);
		for (Station s : searchStations) {
			gui.textArea.append(s.getStationName() + " number:"
					+ s.getStationNbr() + "\n Latutide: "
					+ s.getLatitude() + " \nLongitude: "
					+ s.getLongitude() + "\n");
		}
	}
}