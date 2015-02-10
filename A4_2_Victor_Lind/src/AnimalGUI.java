import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class AnimalGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<Animal> animalList = new ArrayList<Animal>();
	JTextArea textArea = new JTextArea();	
	

			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();
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
	public AnimalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		textArea.setEditable(false);
		textArea.setBounds(10, 11, 814, 337);
		textArea.setText("Assignment 4: \n");
		contentPane.add(textArea);
		
		animalList.add(new Dog("sven", "Perro del mar", true));
		animalList.add(new Cat("katty", 8, 2));		
		animalList.add(new Snake("stenorm", false));
		animalList.add(new Snake("stenorm", true));
		animalList.add(new Dog("Woffy the dog", "Perro del mar", false));
		animalList.add(new Cat("Caty Fireheart", 8, 2));	
		
		for(int i = 0; i<animalList.size(); i++){
			String animalString = animalList.get(i).getInfo() + "\n";
			textArea.append(animalString);
		}
	}
}
