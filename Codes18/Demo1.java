import java.util.Scanner;

class A2
{
	A2(){
		System.out.println("A2 Cons Call");
		
	}
	static{
		System.out.println("A2 Class Loaded..");
	}
}

class A1
{
	A1(){
		System.out.println("A1 Cons Call");
		
	}
	static{
		System.out.println("A1 Class Loaded..");
	}
}

public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Class Name");
		String className = scanner.next();
		Object object = Class.forName(className).newInstance();
		

	}

}
