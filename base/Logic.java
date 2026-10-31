public class Logic{
    public static void main(String[] args){
          
	    // ||  =  OR
	    //  && = AND
	    //  ! = NOT
	    
          double temp = 40;
	  boolean isSunny = true;

	  if(temp <= 30 && temp >= 0 && isSunny){
	    System.out.println("The weather is good");
	    System.out.println("Its SUNNY outside ");
	  }else if(temp <= 30 && temp >= 0 && !isSunny){
	    System.out.println("The weather is good ");
	    System.out.println("It is CLOUDY outside ");
	  }else if (temp > 30 || temp < 0){
	    System.out.println("The weather is bad");
	  }
    }
}

