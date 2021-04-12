package project1;

import project1.Bird;

public class penguingui extends Bird{
	
	public Penguin(){
		super();//parent's default constructor
		super.setCanFly(false);//make sure the special Penguin Bird cannot fly
	}
	
	public Penguin(double beakLength){
		super(false, beakLength);//cannot fly!!!! 
	}
	
	public Penguin(char gender, double weight, int age, boolean hasLegs, double beakLen){
		super(gender, weight, age, hasLegs, false, beakLen);//cannot fly!!!! 
	}
	
	@Override
	public void setCanFly(boolean canFlyOrNot){
		if(canFlyOrNot){
			System.out.println("Penguins don't fly come on!");
		}
	}
	
	public String toString(){
		return super.toString()+"\n\tThis Bird is a Penguin";
	}

}