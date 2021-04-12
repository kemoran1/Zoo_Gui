package project1;

import project1.Animal;
//import project1.Behaviors;

public class Animal implements /*Behaviors,*/ Comparable <Animal>  {

	private static int animalCounter = 0;
	private int animalNumber;
	
	private char gender ;
	private double weight;
	private int age;
	private boolean hasLegs;
	
	public Animal(){
		animalCounter++;
		animalNumber = animalCounter;
		gender = 'U';
		weight = 0; 
		age = 0;
		hasLegs = true;
	}
	public Animal(boolean hasL){
		this();
		weight = 0;
		age = 0;
		hasLegs = true;	
		setHasLegs(hasL);
		}
	public Animal(double w){
		this();
		weight = w;
	}
	public Animal(char g, double w, int a, boolean hasL){
		animalCounter++;
		animalNumber = animalCounter;
		setGender(g);
		weight = w;
		age = a;
		hasLegs = hasL;
	}
	//getter methods
	public char getGender(){
		return gender;
	}
	public double getWeight(){
		return weight;
	}
	public int getAge(){
		return age;
	}
	public boolean getHasLegs(){
		return hasLegs;
	}
	
	public void setGender(char g){
		switch(g){
			case 'u':
			case 'f':
			case 'm':
			case 'U':
			case 'F':
			case 'M':
				gender = Character.toUpperCase(g); //this.gender = g;
				break;
			default:
				System.out.println("invalid gender char "+ g);
				gender = 'U';
		}
	}
	public void setWeight(double w){
		if(w < 0){
			System.out.println("tried to set weight to invalid value "+ w);
		}
		else{
			weight = w; 
		}
		
	}
	public void setAge(int a){
		if( a < 0){
			System.out.println("tried to set age to invalid value "+ a);
		}
		else{
			this.age = a;	
		}
	}
	
	public void setHasLegs(boolean hasLegs){
		this.hasLegs = hasLegs;
	}
	
	@Override
	public String toString(){
		String s =" Animal gender=" + gender + 
				", age=" + age +
				", weight=" + weight+
				", animal num="+animalNumber;
		
		if(hasLegs){
			s += " has legs";
		}
		else{
			s += " does not have legs";
		}
	
		return s;
	}

	@Override
	public boolean equals(Object o){
		
		if(o instanceof Animal){
			Animal otherAnimal = (Animal) o;
			if(this.gender == otherAnimal.gender){
				if(this.age == otherAnimal.age){
					if(this.weight == otherAnimal.weight){
						if(this.hasLegs == otherAnimal.hasLegs){
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static int getTotalAnimalCount(){//static ...no object needed to call the method
		return animalCounter;
	}
	
	public int getAnimalNumber(){//non-static .. belongs to individual object
		return animalNumber;
	}

	public void move() {
		if(hasLegs){
			System.out.println("I walk");
		}
		else{
			System.out.println("I have no legs...maybe I slither");
		}
	}

	public void eat() {
		System.out.println("YUM YUM");
	}

	public void speak() {
		System.out.println("Hi I am an Animal :-) ");
	}

	public void speak(int numTimes) {
		for(int i=numTimes; i>0; i--){
			speak();
		}
	}


	public int compareTo(Animal otherAnimal) {
		if(this.weight > otherAnimal.weight){
			return -1;
		}
	else if(this.weight == otherAnimal.weight){
			return 0;
		}
	else {
		return 1;
	}
		
	}
}
	