public abstract class Animal {
	private String latinName;
	 String friendly ;

	public Animal(String latinName) {
		this.latinName= latinName;
		
	}

	public abstract String getInfo();

	public void setFriendlyName(String name) {
		this.friendly = name;
	}

	public String getFriendlyName() {

		return friendly;
	}
	
	public String getLatinName(){
		
		return latinName;
	}
}
