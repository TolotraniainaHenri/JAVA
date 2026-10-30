import java.util.Scanner;

public class Application{

  public  static void main(String[] args){
    
   Scanner scanner = new Scanner(System.in);
    
    // Circumference = 2 * Math.PI * Math.pow(radius, 2);
    // Area = Math.PI *Math.pow(radius, 2);
    // Volume = (4/3) * Math.PI *Math.pow(radius, 3);
	double circumference;
	double area;
	double volume;
        double radius;
	int  choice;
     System.out.println(" =============== Menu ===============");
     System.out.println("1- Circumference ");
     System.out.println("2- Area ");
     System.out.println("3- Volume");
     System.out.println("Enter your choice : ");
     choise = scanner.nextInt();
     System.out.println("Enter the radius :");
     radius = scanner.nextDouble();
     boolean isTrue = true;
     while(isTrue){
       switch(choise){
            case 1 -> { circumference = 2 * Math.PI * Math.pow(radius, 2);
                        System.out.println("Circumference : " +  circumference);}
            case 2 -> { area =  Math.PI * Math.pow(radius, 2);
                       System.out.println("Area : "+ area);}
            case 3 -> { volume = (4/3) * Math.PI * Math.pow(radius, 3);
                      System.out.println("Volume: " + volume); }
            default -> System.out.println("You are wrong choice !");
           }
        System.out.println("press :true to continued , false to  stop");
        isTrue = scanner.nextBoolean();
     }                     
  }
}
