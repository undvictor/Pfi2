public class Dog extends Mammal {

	private boolean stupid;
	
	
	public Dog(String latinName, boolean stupid) {
		
		super(latinName);
		this.stupid = stupid;
	
	}
	public Dog(String friendlyName, String latinName, boolean stupid){
		super(latinName);
		this.friendly = friendlyName;
		this.stupid = stupid;
	}
	
	public boolean isStupid(){
		
		return this.stupid;
	}
	
	@Override
	public String getInfo() {
		String stupidString;
		if(isStupid()){
		 stupidString = "Yes";
		}else{
			stupidString = "No";			
		}
		String dogString = "A dog named " + getFriendlyName() + ". Latin name: " + getLatinName() +", Time of pregnancy: " 
		+ String.valueOf(getGestationTime()) + " Months. Is it stupid? : " + stupidString; 		
		return dogString;
	}
	
}
