package  project1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animalframe extends JFrame{

	public Animalframe(){
		JPanel mainJP = new JPanel();
		mainJP.setLayout(new BorderLayout());
		guipanel zooJP = new guipanel();
		
		mainJP.add(zooJP);
		add(mainJP);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}