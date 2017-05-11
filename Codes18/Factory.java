import java.util.ResourceBundle;

public class Factory {
public static I getObject(){
	ResourceBundle rb = ResourceBundle.getBundle("config");
	Object object = null;
	try{
	object = Class.forName(rb.getString("classname")).newInstance();
	}
	catch(Exception e){
		System.out.println(e);
	}
	return (I)object;
}
}
