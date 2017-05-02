import java.io.File;
import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// c:\\xyz\\eee\\rr.txt
		String path = "/Users/amit/Documents/testfs/sample.txt";
		//String dirPath = "/Users/amit/Documents/testfs/pp/ww/rr/tt";
		File file = new File(path);
		if(file.exists()){
			file.delete();
			System.out.println("File Deleted...");
		}
		else{
			boolean result = file.createNewFile();
			System.out.println("File Created...");
		}
		//file.mkdirs();
		//System.out.println("Dir Created...");
//		boolean result = file.createNewFile();
//		if(result){
//			System.out.println("File Created...");
//		}
//		else
//		{
//			System.out.println("Unable to create...");
//		}
		

	}

}
