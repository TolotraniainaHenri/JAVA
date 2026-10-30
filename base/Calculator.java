import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){
    
   Scanner scanner = new Scanner(System.in);    

    char operator;
    double num1;
    double num2;
    double result;

    System.out.println("Enter the first number :");
    num1 = scanner.nextDouble();
    System.out.println("Enter the operator :");
    operator  = scanner.next().charAt(0);
    System.out.println("Enter the second number: ");
    num2 = scanner.nextDouble();

    switch(operator){
     case   '+' -> System.out.println( result = num1 + num2 );
     case   '-' -> System.out.println( result = num1 - num2 );
     case   '*' -> System.out.println(result = num1 * num2);
     case   '/' -> {
                if (num2 == 0 ){
                   System.out.println("Cannot divide by zero!");
                 }else{
                   System.out.println(result = num1 / num2);
                 }
        }  
     }
  }

}
