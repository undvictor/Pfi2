import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private ArrayList<Human> humanList = new ArrayList<Human>();
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	static Human human;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
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
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHumansAndDogs.setBounds(158, 11, 143, 31);
		contentPane.add(lblHumansAndDogs);
		
		textField = new JTextField();
		textField.setBounds(30, 65, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 111, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() < 3){
					textArea_1.setText("Give human name that is more than three letters");
					
				}else{
					emptyError();
				human = new Human(textField.getText());
				}
			}
		});
		btnNewHuman.setBounds(164, 64, 118, 23);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().length() < 1){
					textArea_1.setText("Name your dog!");
				}else if(textField.getText().length() < 3){
					textArea_1.setText("The dog needs an owner");
					
				}else{
					emptyError();
					human.buyDog(new Dog(textField_1.getText()));
					
				}
			}
		});
		btnBuyDog.setBounds(164, 110, 118, 23);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(human.getName().toString().isEmpty()){
				System.out.println("swag swag wolfgang");
				}else{
					textArea_1.setText(human.getInfo());
					
				}
			}
		});
		btnPrintInfo.setBounds(164, 172, 118, 23);
		contentPane.add(btnPrintInfo);
		

		textArea.setEditable(false);
		textArea.setBounds(47, 225, 338, 39);
		contentPane.add(textArea);
		
		
		textArea_1.setEditable(false);
		textArea_1.setBounds(47, 288, 338, 39);
		contentPane.add(textArea_1);
		
		
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(47, 200, 46, 14);
		contentPane.add(lblInfo);
		
		JLabel lblErrors = new JLabel("Errors");
		lblErrors.setBounds(47, 275, 46, 14);
		contentPane.add(lblErrors);
	}
	private void emptyError(){
		textArea_1.setText("");
		
	}
}
