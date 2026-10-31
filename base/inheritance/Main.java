public class Main{
	public static void main(String[] args){
		
		// Inheritance = one class inherits the attributes and methodes
		//              from another class
		//              child <- Parent

		//Animal a = new Animal("Animal");
		Cat cat = new Cat("Minou");
		Dog dog = new Dog("Rex");
		//cat.speak();
		//dog.speak();
                //a.speak();

		//cat.eat();
		
		// *************** Polymorphisme ******************
		Animal[]  animals = {cat , dog};
		for (Animal x : animals){
			x.speak();  
		}
		System.out.println("****** End ********");

	}
}
