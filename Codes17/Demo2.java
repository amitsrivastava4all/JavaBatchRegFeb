import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) throws IOException {
		// Write Data in a File
		String path = "/Users/amit/Documents/testfs/test.txt";
		
		FileOutputStream fs = new FileOutputStream(path);
		System.out.println("Enter the Data to write in a file");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		byte arr[] = data.getBytes();
		fs.write(arr);
		fs.close();
		System.out.println("Done...");
		

	}

	
}
