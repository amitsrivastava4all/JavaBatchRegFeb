import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDemo {

	public static void main(String[] args) throws IOException {
		String path = "/Users/amit/Documents/Monday-Java/FilehandlingDemo/src/ReadDemo.java";
		File file = new File(path);
		if(file.exists()){
		FileInputStream fs = new FileInputStream(path);
		final int EOF = -1;
		int singleByte = fs.read();
		while(singleByte!=EOF){
			System.out.print((char)singleByte);
			singleByte = fs.read();
		}
		fs.close();
		}
		else{
			System.out.println("File Not Exist so Can't Read...");
		}
		
		
	}

}
