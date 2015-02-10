public class Human {
	private Dog myDog;
	private String name;
	
	public Human(String name) {
		this.name = name;

	}

	public String getName() {

		return this.name;
	}

	public void buyDog(Dog dog) {
		this.myDog = dog;

	}

	public String getInfo(){
		String info;
	if(myDog != null){
		info = getName() +  " äger en hund som heter " + myDog.getName() + ".";
		return info;
	} else{
		info = getName() + " " + " har ju ingen hund ";
		return info;
		
	}
	}
}
