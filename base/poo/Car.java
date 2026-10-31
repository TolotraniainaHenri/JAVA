public class Car{
	
	// static = Makes a variable or methode belong to the class
	//          rather than to any specific object.
	//          Commonly used for utility methods or shared resources.

        // Costructor = A specific method to initialize objets
	// 		You can pass argument to constructor
	//  		and set up intial values

	String make ;
	String model ;
	int year ;
	double price;
	boolean isRunning ;
	static int totalCar;
	Car(String make, String model, int year, double price){
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.isRunning = false;
		totalCar ++;

		
	}

	void start(){
	this.isRunning = true;
	System.out.println("You start the engine");
	}

	void stop(){
	this.isRunning = false;
        System.out.println("You stop the engine");
	}
	void drive(){
	System.out.println("You drive the " + this.model);
	}
	static void total(){
	System.out.println("Total of car : " + totalCar);
	}

}
