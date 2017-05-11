import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class Calc
{
	private int add(int x, int y){
		return x + y;
	}
	public int subtract(int x, int y){
		return x - y;
	}
	public int multiply(int x, int y){
		return x * y;
	}
	public int divide(int x, int y){
		return x / y;
	}
	
}
class ScCalc
{
	public int power(int x, int y){
		return (int)Math.pow(x, y);
	}
	public int range(int x,int y){
		for(int i = x+1 ; i<=y-1; i++){
			System.out.println(i);
		}
		return 0;
	}
}
public class Demo2 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Class Name");
		String className = scanner.next();
		Object object = Class.forName(className).newInstance();
		System.out.println("Enter the Operation Name");
		String operationName = scanner.next();
		Method method = object.getClass().getDeclaredMethod(operationName, int.class,int.class);
		method.setAccessible(true);
		Object result = method.invoke(object, 1,5);
		System.out.println(result);
//		Object p = 1000;
//		System.out.println(p);
//		p="Hello";
//		System.out.println(p);
//		p =90.20;
//		p = true;
//		int pp = 1000;
//		Integer kk = 1000;
//		kk ="amit";
	}

}
