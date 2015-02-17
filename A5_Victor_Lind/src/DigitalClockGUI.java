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
	JPanel panel = new JPanel();
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	JSpinner spinner = new JSpinner();
	JSpinner spinner_1 = new JSpinner();
	final JCheckBox chckbxActive = new JCheckBox("Active");
	
	public DigitalClockGUI() {
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblAlarm = new JLabel("ALARM");
		lblAlarm.setFont(new Font("Tunga", Font.PLAIN, 99));
		lblAlarm.setBounds(84, 22, 325, 144);
	
		clockLogic = new ClockLogic(this);
		
		
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
		chckbxActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
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
	
	public void setTimeOnLabel(String time){
		textArea.setText(time);
		
	}
	
	public boolean alarm(boolean activate){
		if(beep){
			System.out.println("ring ring");
			JOptionPane.showMessageDialog(null, "ALARM SET FOR THIS TIME", "ALARM", JOptionPane.PLAIN_MESSAGE);
		}else{
			System.out.println("Larmet är tyst igen");
		}
		System.out.println("I alarm");
		System.out.println("ring ring");
	    
		beep = false;
		panel.setBackground(Color.gray);
		chckbxActive.setSelected(false);
		
	
		return activate;
	}
}

