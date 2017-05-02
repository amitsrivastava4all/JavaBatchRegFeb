import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPasteDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final int EOF = -1;
		String sourcePath = "/Users/amit/Documents/testfs/E.mp3";
		String targetPath = "/Users/amit/Documents/testfs/ECopy.mp3";
		FileInputStream fs = new FileInputStream(sourcePath);
		BufferedInputStream bs = new BufferedInputStream(fs,20000);
		FileOutputStream fo = new FileOutputStream(targetPath);
		BufferedOutputStream bo = new BufferedOutputStream(fo,20000);
		long startTime = System.currentTimeMillis();
		int singleByte = bs.read();
		//System.out.println("Copy Start...");
		while(singleByte!=EOF){
			bo.write(singleByte);
			singleByte = bs.read();
		}
		long endTime = System.currentTimeMillis();
		bs.close();
		bo.close();
		fs.close();
		fo.close();
		System.out.println("Done... "+(endTime-startTime)+"ms");
		
	}

}
