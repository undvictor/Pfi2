package se.mah.k3lara.skaneAPI.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

//nödvändiga imports:
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JScrollBar;

public class GUI extends JFrame {

	JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();

	// deklarera klasser
	private Parser p = new Parser();
	GUI g = this;

//	Thread tJ = new JourneysThread(p, this);
	//Thread tS = new StationsThread(p, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 942, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 468, 285);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 76, 105, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("S\u00F6k");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread tS = new SearchThread (p, g);
				tS.start();
			}
		});
		btnNewButton.setBounds(141, 75, 57, 23);
		panel.add(btnNewButton);
		textArea.setEditable(false);

		textArea.setBounds(10, 107, 448, 167);
		panel.add(textArea);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(524, 11, 358, 285);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setBounds(10, 33, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(119, 33, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		//använd 81116 & 65008
		JButton btnSk = new JButton("S\u00F6k");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread tJ = new JourneysThread (p, g);
				tJ.start();
			}
		});
		btnSk.setBounds(53, 76, 89, 23);
		panel_1.add(btnSk);

		JLabel lblFrn = new JLabel("Fr\u00E5n");
		lblFrn.setBounds(10, 11, 46, 14);
		panel_1.add(lblFrn);

		JLabel lblTill = new JLabel("Till");
		lblTill.setBounds(119, 11, 46, 14);
		panel_1.add(lblTill);
		textArea_1.setEditable(false);

		textArea_1.setBounds(10, 108, 338, 166);
		panel_1.add(textArea_1);

		JLabel label = new JLabel("4.1");
		label.setBounds(20, 317, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("4.2");
		label_1.setBounds(550, 317, 46, 14);
		contentPane.add(label_1);
	}
}
