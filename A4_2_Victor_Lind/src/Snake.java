public class Snake extends Animal {
	
	private boolean poisonus;
	
	public Snake(String latinName, boolean poisonus){
		super(latinName);
		this.poisonus = poisonus;
		
	}
	public boolean isPoisonus(){
		
	return this.poisonus;
	
	}
	@Override
	public String getInfo() {
		String poisonString = "";
		if(isPoisonus() == false){
			poisonString = "not ";
		} else
		{ poisonString = "";
		}
		String snakeString = " Latin name of snake is: " + getLatinName() + " And it is " + poisonString + " poisonus"; 
		return snakeString;
	}

}
