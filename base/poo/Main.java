public class Main{
	public static void main(String[] args){
		//object = An antity that holds data (attributes)
		//	and can perform action (methods)
		//	Its is a reference data type

       		 Car car1 = new Car("Ford", "Mustang", 2025, 50000);
		 Car car2 = new Car("Mazda", "Corvet", 2026, 60000);
		car1.start();
		System.out.println(car1.isRunning);
       		car1.stop();
		System.out.println(car2.isRunning);

		Car[] cars = {car1, car2};
		
		for (Car car : cars){
			car.drive();
		}
		
		Car.total();
	}
}
