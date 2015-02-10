public class Cat extends Mammal {

	private int numberOfLives;
	
	public Cat(String latinName, int numberOfLives, int gestationTime) {
		super(latinName, gestationTime);
		this.numberOfLives = numberOfLives;
		
	}
	
	public int getNumberOfLives(){
		
		return this.numberOfLives;
	}
	
	public void setNumberOfLives(int i){
		this.numberOfLives = i;
		
	}

	@Override
	public String getInfo() {
		String catString = " Latin name of cat is: " + getLatinName()  + " & has the gestation time of " 
				+ String.valueOf(getGestationTime()) + " months. Number of lives left on this cat : " + getNumberOfLives(); 
		return catString;
	}

}
