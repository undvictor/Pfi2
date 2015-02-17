import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

import java.util.Random;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;



public class DigitalClockGUI extends JFrame {
	
	private JPanel contentPane;
	ClockLogic clockLogic;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}/**
	 * Create the frame.
	 */
	
	
	// boolean som kollar om vi vill ha ett larm
	public boolean beep = false;
	
	//boolean som kollor om användaren satt ett alarm
	private boolean alarmSet = false;
	
	//panel som jag har alla mina komponenter på
	JPanel panel = new JPanel();
	
	//textArea för tid
	JTextArea textArea = new JTextArea();
	
	//textarea för larm
	JTextArea textArea_1 = new JTextArea();
	//spinner för timmar - larm
	JSpinner spinner = new JSpinner();
	//spinner för minuter - larm
	JSpinner spinner_1 = new JSpinner();
	//använder en checkbox för att sätta på larmet istället. tycker det vore kul att använda nya komponenter
	final JCheckBox chckbxActive = new JCheckBox("Active");
	
	public DigitalClockGUI() {
		//INITIERAR clockLogic-klassen
		clockLogic = new ClockLogic(this);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblAlarm = new JLabel("ALARM");
		lblAlarm.setFont(new Font("Tunga", Font.PLAIN, 99));
		lblAlarm.setBounds(84, 22, 325, 144);
		
		
		panel.setBounds(0, 0, 434, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		textArea.setBounds(13, 5, 407, 93);
		panel.add(textArea);
		panel.setBackground(Color.gray);
		
		
		textArea.setFont(new Font("Chaparral Pro", Font.PLAIN, 89));
		textArea.setEditable(false);
		
		
		JButton btnSetAlarm = new JButton("Set alarm");
		btnSetAlarm.setBounds(208, 112, 102, 23);
		panel.add(btnSetAlarm);
		
		
		chckbxActive.setBounds(316, 112, 77, 23);
		panel.add(chckbxActive);
		textArea_1.setBounds(113, 176, 119, 35);
		panel.add(textArea_1);
		
		textArea_1.setFont(new Font("Chaparral Pro", Font.PLAIN, 30));
		textArea_1.setEditable(false);
		textArea_1.setText(null);
		
		JLabel lblAlarmAt = new JLabel("Alarm time:");
		lblAlarmAt.setBounds(23, 176, 80, 14);
		panel.add(lblAlarmAt);
		spinner.setBounds(60, 113, 43, 20);
		panel.add(spinner);
		spinner_1.setBounds(147, 113, 51, 20);
		panel.add(spinner_1);
		
		JLabel lblH = new JLabel("H");
		lblH.setBounds(43, 116, 19, 14);
		panel.add(lblH);
		
		JLabel lblM = new JLabel("M");
		lblM.setBounds(129, 116, 19, 14);
		panel.add(lblM);
		
		//Regler för checkboxen
		chckbxActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(alarmSet){
				if(chckbxActive.isSelected()){
					beep = true;
					
				}else{
					beep = false;
				}
				if(beep && alarmSet){
					panel.setBackground(Color.RED);
				}else{
					
					panel.setBackground(Color.gray);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Set alarm-time first", "Wrong", JOptionPane.PLAIN_MESSAGE);
				chckbxActive.setSelected(false);
			}
			}
		});
		
		// Här sätter du larmet mha en knapp
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String alarmString ="";
				String hourZero = "";
				String minuteZero = "";
				
				if ((int)spinner.getValue() < 0 ||(int)spinner.getValue() > 23 ||(int) spinner_1.getValue() < 0  ||(int) spinner_1.getValue() > 59 ) {
					  JOptionPane.showMessageDialog(null, "Sorry, it seems that the time you have set does not exist.\n Please try again!", "Wrong AlarmTime", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					
				if ((int)spinner.getValue() < 10){
					hourZero = "0";
				}if((int)spinner_1.getValue() < 10 ){
					minuteZero = "0";
				}
				clockLogic.setAlarm((int)spinner.getValue(), (int)spinner_1.getValue());
				textArea_1.setText(hourZero + (int)spinner.getValue() +" : " + minuteZero + (int)spinner_1.getValue());
				alarmSet = true;
				}
			
				
			}
		});
		
	}
	
	//funktion som hämtar realtid och sätter in det i textarea
	public void setTimeOnLabel(String time){
		textArea.setText(time);
		
	}
	
	
	//alarmmetoden som absolut inte är optimal, men funkar.
	public boolean alarm(boolean activate){
		//om du checkat i att du vill ha ett larm
		if(beep){
			JOptionPane.showMessageDialog(null, "ALARM SET FOR THIS TIME", "ALARM", JOptionPane.PLAIN_MESSAGE);
		}
	    
		//när du tryckt på felmeddelandet, återställ allt
		beep = false;
		panel.setBackground(Color.gray);
		chckbxActive.setSelected(false);
		return activate;
	}
}

