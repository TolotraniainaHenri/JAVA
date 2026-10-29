import java.util.Random;

public class  Rand{
   public static void main(String[]  args){

     Random random = new Random();
    int number;

    number = random.nexrInt();

    System.out.println(number);
    random.close();
   }
}
