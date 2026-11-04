import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Write{
	public static void main(String[] args){
		
		// How to write a file using Java(4 popular options)
                
               String path = "/home/henri/DocProjet/JAVA/base/writefile/test.txt";

		try(FileWriter writer = new FileWriter(path)){
			writer.write("I like Saosisy");
			System.out.println("File has been writen");
                }catch(FileNotFoundException e){
                        System.out.println("Could not lacate file");
                }
		catch(IOException e){
                        System.out.println("could not write file !");
                } 
	}
}
