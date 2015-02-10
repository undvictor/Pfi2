public abstract class Mammal extends Animal {
	
	private int gestationTime;
	
	
	public Mammal (String latinName){
	       super(latinName);
	
			
		}
	
	public Mammal (String latinName, int gestationTime){
       super(latinName);
       this.gestationTime = gestationTime;
		
	}

	public int getGestationTime(){
		
		String callMrClass = new Exception().getStackTrace()[1].getClassName();
		if(callMrClass == "Dog"){
		 System.out.println("Dog");
		 this.gestationTime = 3;
		}else{
			System.out.println("Cat");
			this.gestationTime = 2;
		}
		
		return this.gestationTime;
	}
}
