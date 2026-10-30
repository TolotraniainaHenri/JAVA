import java.util.Scanner;

public class Hypotenuse{
     public static void main(String[]  args){

     // HYPOTHENUSE C = sqrt(a^2 + b^2)

       Scanner scanner = new Scanner(System.in);

         double a;
         double b;
         double c;
     
    	System.out.println("Enter the side a: ");
	a = scanner.nextDouble();
	System.out.println("Enter the side b: ");
       b = scanner.nextDouble();
       
       c = Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2) );
       System.out.println("The Hypotenuse (side c) :  "+ c); 
       
   }
}
