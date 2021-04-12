package project1;


	import java.util.Arrays;

	public class Doggui extends Animal{
		
		private boolean hasTail;
		private String faveFood;
		private String[] tricks;
		private int totalNumOfTricks=5;
		
		public void Dog(){
			super();
			tricks = new String[totalNumOfTricks];
			hasTail = true;
			faveFood = "bones";
		}

		public void Dog(boolean hasT, String faveF){
			super();
			tricks = new String[totalNumOfTricks];
			hasTail = hasT;
			faveFood = faveF;
		}
		
		public void Dog(char gender, double weight, int age, boolean hasL, boolean hasT, String faveF, String[]theTricks){
			super(gender,weight,age,hasL);//call the parent's overloaded constructor
			hasTail = hasT;
			faveFood = faveF;
			tricks=theTricks;
			totalNumOfTricks=theTricks.length;
		}
		public String getTricksAsString() {
			String s="";
			int i=0;
			while(i<tricks.length && tricks[i] !=null) {
				s+= tricks[i] + " , ";
			}
			if (tricks [tricks.length-1] != null) {
				s+= tricks[i] ;
			}
			return s;
		}

		@Override
		public String toString(){
			String s = super.toString();
			s += "\n\tDog: favorite food="+faveFood;
			//s += Arrays.toString(tricks); get the tricks array as a string and append in to the array
			if(hasTail){
				s+=", has a tail";
			}
			else{
				s +=", does not have a tail";
			}
			s += Arrays.toString(tricks);
			return s;
		}
		
		@Override
		public boolean equals(Object o){
			if(o instanceof Dog){
				Dog otherDog = (Dog)o;
				if(super.equals(otherDog)){
					if(this.hasTail == otherDog.hasTail){
						if(this.faveFood.equalsIgnoreCase(otherDog.faveFood)){
							return true;
						}
					}
				}
			}
			return false;
		}
		@Override
		public void speak(){
			System.out.println("WOOF WOOF");
		}
		
		@Override
		public void eat(){
			super.eat();
			System.out.println("Slirp Slirp ");
		}
		
		
		
		
		
	}