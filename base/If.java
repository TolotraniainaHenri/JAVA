
import java.util.Scanner;

public class If{
	public static void main (String[] args){

    // perfoms a blocks of code if its condition is true 
       
       
     Scanner scanner = new Scanner(System.in);
     
     System.out.println("Enter your name !");
     String name = scanner.nextLine();
     System.out.println("Enter your age! ");
     int age = scanner.nextInt();
    //-----------------------------------------------------
     if(name.isEmpty()){
      System.out.println("You did not enter your name!");
      }else{
      System.out.println("Hello " + name !);
      }

     //----------------------------------------------------
    if(age >= 18 ){
      System.out.println("You are an adult!"); 
    }else if( age == 0){
      System.out.println("You have not been born yet!");
    }else if( age >= 65 ){
      System.out.println("You are a senior!");
    }else{
      System.out.println("You are a child!");
     }
 }
}
