package project1;

import project1.Animalframe;

public class Showanimal {
	
	public static void main(String[] args) {
javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				Animalframe my_gui = new Animalframe();
			}	
});	
	}
}
