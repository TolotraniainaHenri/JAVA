
public class Methode{
	public static void main(String[] args){
        
	// methode = a block of reusable code that excecuted when called

	happyBirthday("Henri", 26);
	System.out.println(square(3));
	System.out.println(cube(2));
	}
	static void happyBirthday(String name, int age){
	System.out.println("Happy Birthday " + name + "! ,you are "+ age +"years old !");
	}
	static double square(double number){
	return number * number * number;
	}
	static double cube(double number){
	return number * number;
	}
}
