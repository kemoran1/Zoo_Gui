package project1;

import java.awt.Color;// bc i use color for my background 

import java.awt.GridLayout; //bc i use a grid layout for how i want the btns set up
import java.awt.event.ActionEvent; //bc i want to have a btn but need both action event and listener so one can do an action and the other waits to be pressed
import java.awt.event.ActionListener;

import javax.swing.JButton;// bc we're using a button
import javax.swing.JLabel; //bc we're using a label
import javax.swing.JPanel;// the panel is the screen of it to see where everything goes 
import javax.swing.JTextField;// i want the user to give inputs

import project1.Animal; //im going to use items from the Animal class 
import sun.audio.*;
import java.io.*;
//import javax.swing.*;

public class guipanel extends JPanel { //public bc i want the other clases to use the code and guipanel is what my class is called and the extends Jpanel so that it can create a panel
	
	private JPanel jp1,jp2,jp3;//establishing the 3 panels
	private JLabel jltitle; //establishing a title
	private Animal [] animals =new Animal[10]; //creating my array
	int nextint = 0; //to help store the information in the array
	
	public guipanel(){
		setLayout(new GridLayout(4,3));//format
		
		jp1 = new JPanel();
		jltitle = new JLabel("Welcome to our zoo ");
		jp1.add(jltitle);//adding it into the panel 
		jp2 = new NumPanel();//ditto
		jp3 = new BtnPanel();
		add(jp1);//adding it into the panels
		add(jp2);
		add(jp3);
	}
	
	
	public class NumPanel extends JPanel{//create a new class for the text field and all the inputs
		private JLabel jl1,jl2,jl3,jl4,jl5;//all the labels
		private JTextField tf1,tf2,tf3,tf4,tf5;//all the text field
		public NumPanel() {
			setLayout(new GridLayout(5,2));//layout of all panel
			jl1 = new JLabel("Animal: ");//what i want each label to say next to all the text boxes
			tf1 = new JTextField(" ");
			jl2 = new JLabel("Weight");
			tf2 = new JTextField(" ");
			jl3 = new JLabel("Gender");
			tf3 = new JTextField(" ");
			jl4 = new JLabel("Age");
			tf4 = new JTextField(" ");
			jl5 = new JLabel("HasLegs");
			tf5 = new JTextField("");

			add(jl1); //adding all of them in the gui 
			add(tf1);
			add(jl2);
			add(tf2);
			add(jl3);
			add(tf3);
			add(jl4);
			add(tf4);
			add(jl5);
			add(tf5);

		
		}

	public int getIntFromTextField1() { //these are all methods soon going to be called into so that all the text field is going to be used in the program and calculated for the array
		int age=0;
		String ageAsStr =((NumPanel)jp2).tf4.getText().trim(); //maybe
		if (ageAsStr.length() !=0 ) {
			age=Integer.parseInt(ageAsStr);
		}
//		(((NumPanel)jp2).tf4.getText());
		return age ;
	}		
	public int getIntFromTextField2() {
		int weight=0;
		String weightAsStr = ((NumPanel)jp2).tf2.getText().trim();
		if(weightAsStr.length() != 0) {
			weight=Integer.parseInt(weightAsStr);	
		}
		//weight=Integer.parseInt(((NumPanel)jp2).tf2.getText().trim());	
		return weight;	
	}
	public char getCharFromTextField1() { 
		char gender;
		String genderAsStr = tf3.getText();
			gender =  ((NumPanel)jp2).tf3.getText().trim().charAt(0);
			return gender;
		
		
			
	}
		
	
		
	public boolean getbooFromTextField1() {
		boolean hasLegs;
		String s1= ((NumPanel)jp2).tf5.getText().trim();
		if(s1.equalsIgnoreCase("Y")) {
			return true;
		}
		else {
			return false;
		}// methods end
	}
	}

		private class BtnPanel extends JPanel implements ActionListener{ //creating the last panel for the buttons
			
			private String [] btn = {"Create","Display","Update","Delete"}; //created a string array of the 4 buttons 
			private JButton[] buttons;
			private Object music;  
			
			public BtnPanel() { // creates another class and layouts where the buttons are and makes a simpler way to use an array for the buttons
				setLayout(new GridLayout (1,btn.length));
				buttons = new JButton[btn.length];
				populatePanelWithButtons(); //creates a method and gets called
			}
			private void populatePanelWithButtons() { //for loop for the array
				for(int i = 0; i<buttons.length; i++) {
					buttons[i] = new JButton(btn[i]);
					buttons[i].addActionListener(this);
					add(buttons[i]);
					
				}
			}
		
		public void music() {
	AudioPlayer MGP = AudioPlayer.player;
	AudioStream BGM;
	AudioData MD;
	//ContinuousAudioDataStream loop = null;
	try {
		BGM = new AudioStream(new FileInputStream("jungle5.wav"));
		MD = BGM.getData();
		//loop =new ContinuousAudioDataStream(MD);
	}catch(IOException error) {}
	MGP.start(BGM); 
	
		
		
		
		}
		
		
		
		
	
	@Override
	public void actionPerformed(ActionEvent e) { //for action listener 
		
		JButton btnClicked= (JButton)e.getSource(); //to know when the buttons get pushed 
		char gen= ((NumPanel) jp2).getCharFromTextField1(); //the methods to get all the ints and chars from the textfeild
		int a= ((NumPanel)jp2).getIntFromTextField1();
		int weight=((NumPanel)jp2).getIntFromTextField2();
		boolean hasL=((NumPanel)jp2).getbooFromTextField1();
		//String cmdStr =e.getActionCommand();
	
		if(btnClicked.equals(buttons[0])) { //when the user inputs some things and press the create the program will store all the info 
			String animalType = ((NumPanel)jp2).tf1.getText();
			jltitle.setText("you just pressed create right? " +animalType);
			animals[nextint] = new Animal(gen);
			animals[nextint] = new Animal(a);
			animals[nextint] = new Animal(weight);
			animals[nextint] = new Animal(hasL);
			//get values from textfield
			//pass values to constructor
			//add Animal object to next available index in the array
			animals[nextint] = new Animal();
			nextint++;		
			jltitle.setVisible(true);
		}
		else if (btnClicked.equals(buttons[1])) {// clicked on display will be seen all the data collected
				
			String animalType= ((NumPanel)jp2).tf1.getText();
			jltitle.setText("Zoo Total " + animalType +", "+ gen+ ", "+ a+ ", "+weight+", "+ hasL );
			jltitle.setVisible(true);
			music();
		}	
			
		
		else if (btnClicked.equals(buttons[2])) { //press update will change  what they put in 
			//jl1.setText("im pressing update button");
			jltitle.setText("Animal: "+gen+" , "+a+" , "+weight+" , "+hasL);
			
		}
		
		else if (btnClicked.equals(buttons[3])) { //make the first label invisible
			jltitle.setText("you said  to remove");
			jltitle.setVisible(false);
			
		}
		else {
		jltitle.setText("I dont care");//anything else will do nothing and the user i dont care 
		}
			
	
		}
		
	}
}

