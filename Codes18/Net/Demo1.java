import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.Timer;

public class Demo1 {
	static void printScore() throws Exception{
		String path = "/Users/amit/Documents/FileHandlingTestingCase/Sachin-Tendulkar.jpg";
		FileOutputStream fs = new FileOutputStream(path);
		BufferedOutputStream bs = new BufferedOutputStream(fs);
		URL url = new URL("http://4.bp.blogspot.com/-opQVfQRtsjY/UoOitVIbBuI/AAAAAAAAGi0/s-u702udusE/s1600/Sachin-Tendulkar-HD-Wallpapers-1.jpg");
		URLConnection con = url.openConnection();
		con.connect();
		InputStream is = con.getInputStream();
		int read = is.read();
		StringBuffer sb = new StringBuffer();
		while(read!=-1){
			//sb.append((char)read);
			bs.write(read);
			read = is.read();
		}
		System.out.println("Download Complete....");
		bs.close();
		fs.close();
		is.close();
		//String s = sb.toString();
		//s=s.substring(s.indexOf("England need"),s.indexOf("England need")+20);
		//System.out.println(s);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet.getHostName()+" "+inet.getHostAddress());
		
		//************************************************
//		System.out.println("Enter the Host Name");
//		String hostName = new Scanner(System.in).next();
//		InetAddress address[] = InetAddress.getAllByName(hostName);
//		for(InetAddress add : address){
//			System.out.println(add.getHostAddress());
//		}
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					printScore();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		timer.start();
		
		
		
		
		

	}

}
