import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read {
	public static void main (String[] args){
		
		// How ro read a file using Java (3 popular options)
		// BuffedReader +  FileReader : Best for reading text files line-by-line
		// FileInputStream : Best for binary files (e.g, image, audio, audio files)
		// RandomAccessFile: Best for read/ write specific portions of a large file

		String path = "/home/henri/DocProjet/JAVA/base/writefile/test.txt";
		String line;

		try(BufferedReader reader = new BufferedReader( new FileReader(path))){

			while((line = reader.readLine()) != null ){
				System.out.println(line);
			}

		}catch(FileNotFoundException e){
			System.out.println("Could not lacate file");
		}catch(IOException e){
			System.out.println("Something went wrong");
		}

	}
}
