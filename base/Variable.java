
public class  Variable {
	public static void main(String[] args) {

	// variable = reusable cotainer for a value 
	// 		a variable behave as if it was the value it contains

	//Primitive = simple value stored directly in memory (stack)
	// Refence = memory address (stack) that point to the (heep)

	// Primitive vs Reference 
	//-----------    --------
	//int     		string
	//double 		array
	//char 			object
	//boolean   

	// Steps to creating a variable 
       //-------------------------------
	//1.Declaration
	//2.Assigment

		int age = 26;
		int year = 2026;
		
		double price = 199999.99;
		double gpa = 3.5;
		double temperature= -12.5;

		boolean isStudent = true;
		boolean forSale = false;
		boolean isOnline = true;
		
		String name = "Henri Code";
		String food = "Saosisy";
		String email = "fake123@gmail.com";
		String car = "Mustang";
		String color = "red";

		char grade = 'A';
		char symbole = '!';
		char currency = '$';

    System.out.println("Hello " + name);
    System.out.println("You are " + age + " years old");
	System.out.println("Your gpa is : " + gpa);
    System.out.println("Your average letter grade is: " +grade);
	System.out.println("email:  "+ email);

	if (isStudent){
	System.out.println("You are a student!");
 }
else{
	System.out.println("You are NOT a student!");
       }
    }
 }
