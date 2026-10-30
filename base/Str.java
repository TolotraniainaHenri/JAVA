
public class Str{
  public static void main(String[] args){

      String name = "Henri Code";

     int length = name.length();
     char letter = name.charAt(0);
     int index = name.indexOf(" ");
     int lastIndex = name.lastIndexOf("o");

    // name = name.toUpperCase();
    // name = name.toLowerCase();
    // name = name.trim();
   
     name = name.replace('o', 'a');
    
     System.out.println(name);
   }


}
