import java.util.Scanner;

public class Banking{

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args){	
		// JAVA BANKING PROGRAM FOR BEGINNERS
		double balance = 5000;
		boolean isRunning = true;
		int choice;
		
		System.out.println("****************************");
                System.out.println("====== BANKING PROGRAM ======");
		System.out.println("1. Show balance");
		System.out.println("2. Deposit");
		System.out.println("3- withdraw");
		System.out.println("4- EXIT");
		System.out.println("*****************************");

                System.out.println("Enter Your choice (1-4): \n");
		choice = scanner.nextInt();

		while(isRunning){
		  	switch(choice){
				case 1 -> showBalance(balance);
				case 2 -> balance += deposit();
				case 3 -> balance -= withdraw(balance);
				case 4 -> isRunning = false;
				default -> System.out.println("Invalid Choice");
       		  	}
		}

		// DECLARE VARIABLE 
		// DISPLAY MENU
		// GET AND PROCESS USER CHOICE
		// showBalance()
		// deposit()
		// withdraw()
		// EXIT Message
		System.out.println("Thank you! Have a Nice Day !");
		scanner.close();
	}
	static void showBalance(double balance){
	System.out.println("Ar" + balance);
	}
	static double deposit(){
		
		
		double amount;
		System.out.println("Enter an amount to be  deposited: ");
		amount = scanner.nextDouble();
		
		if (amount < 0){
			System.out.println("Amount can't be negative");
			return 0;
		}else{	return amount; }
	}
	static double withdraw(double balance){
		
		
		double amount;
		System.out.println("Enter amount to be withdraw : \n");
		amount = scanner.nextDouble();

		if(amount > balance ){
			System.out.println("INSUFFICIET FUNDS");
			return 0;
		}else if(amount < 0) {
			System.out.println("Amount can not be negative ");
			return 0;
		}else{ return amount;}
	}
}
