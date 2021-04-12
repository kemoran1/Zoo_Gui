package project1;

import project1.Animal;
import project1.Bird;

public class Bird extends Animal{
	
	private boolean canFly;
	private double beakLength;
	
	public Bird(){
		super();
		canFly = true;
		beakLength = 0;  //0.0
	}
	public Bird(boolean canFly, double beakLen){
		super();
		this.canFly = canFly;
		beakLength = beakLen;
	}
	public Bird(char gender, double weight, int age, boolean hasLegs, boolean canFly, double beakLen){
		super(gender,weight,age,hasLegs);
		this.canFly = canFly;
		beakLength = beakLen;
	}
	public void setCanFly(boolean canFlyOrNot){
		canFly = canFlyOrNot;
	}
	public void setBeakLenght(double beakLen){
		beakLength = beakLen;
	}
	public boolean getCanFly(){
		return canFly;
	}
	public double getBeakLength(){
		return beakLength;
	}
	public String toString(){
		String s = super.toString();
			s+= "\n\tBird: Beak Length="+beakLength;
			if(canFly){
				s +=" , can fly";
			}
			else{
				s += ", cannot fly";
			}
		return s;
	}
	public boolean equals(Object o){
		if(o instanceof Bird){
			Bird otherBird = (Bird)o;
			if(super.equals(otherBird)){
				if(this.canFly == otherBird.canFly){
					if(this.beakLength == otherBird.beakLength){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
