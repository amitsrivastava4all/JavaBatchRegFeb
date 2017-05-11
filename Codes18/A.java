
public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		B obj = new B();
		I obj = Factory.getObject();
		obj.show();
	}

}
