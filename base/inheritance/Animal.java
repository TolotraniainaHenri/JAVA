public class Animal {
	
	String name;
	
	Animal(String name){
		this.name = name;
	}

	void eat(){
		System.out.println("The animal "+ this.name + " is eating");
	}
        void speak(){
                System.out.println("The animal "+ this.name + " speak !");
        }

}
