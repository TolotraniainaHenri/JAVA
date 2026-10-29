import java.util.Scanner;

public class LibsGame{
	public static void main(String[] args){

    // MAD LIBS GAME

     	Scanner scanner = new Scanner(System.in);

	String adjective1;
	String noun1;
	String adjective2;
	String verb1;
	String adjective3;
	
	System.out.println("Enter an adjective (description): ");
	adjective1 = scanner.nextLine();
	System.out.println("Enter a noun (animal ar person): ");
	noun1 = scanner.nextLine();
	System.out.println("Enter an adjective (description): ");
	adjective2 = scanner.nextLine();
	System.out.println("Enter a verb and with -ing (action): ");
	verb1 = scanner.nextLine();
	System.out.println("Enter an adjective (decription): ");
	adjective3 = scanner.nextLine();

        System.out.println("Today ,I went to a " + adjective1 + " zoo.");
	System.out.println("In an exhibit, I saw a " + noun1 + ".");
	System.out.println(noun1 + " was " + " and " + verb1);
	System.out.println("I was " + adjective3 + "!");

 }

}
