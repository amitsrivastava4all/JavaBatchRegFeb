// Thread , Runnable
class Job implements Runnable
{
	int tt;
	@Override
	public synchronized void run(){
		for(int i = 1; i<=5; i++,tt++){
			
			// DB Logic
			System.out.println("TT "+tt+"I is "+i+" Thread Name "+Thread.currentThread().getName());
		}
	}
}
public class ThreadDemo {

	public static void main(String[] args) {
		Job job  = new Job(); 
		Thread worker = new Thread(job, "ram");
		//Job job2 = new Job();
		Thread worker2 = new Thread(job,"shyam");
		worker.start();
		worker2.start();
//		System.out.println("Main Thread ");
//		for(int j = 1; j<=5; j++){
//			System.out.println("Thread Current "+Thread.currentThread().getName());
//		}
				

	}

}
