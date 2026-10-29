import java.util.Scanner;

public class Area{
	public static void main(String[]  args){
	
	//Calculate area of  rectagle 

	double width = 0;
	double height = 0;
	double area = 0;
	
	Scanner scanner = new  Scanner(System.in);

	System.out.println("Enter the width ");
	width = scanner.nextDouble();

	System.out.println("Enter the height ");
	height = scanner.nextDouble();

        area = width * height;
	
	System.out.println("The Area is  "+ area);
   }

}
