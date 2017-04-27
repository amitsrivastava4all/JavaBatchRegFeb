import java.util.Random;

public class RandomNumberGenerate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Random random = new Random(10);
		while(true){
		System.out.println(random.nextInt(10));
		Thread.sleep(1000);
		}
	}

}
