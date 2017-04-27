import java.awt.Image;

public class Player {
	private int x;
	private int y;
	private int width;
	private int height;
	private Image img;
	private int gravity;
	private int force;
	private boolean isJump ;
	public Player(){
		gravity = 1;
		x = 100;
		y =GameConstants.FLOOR;
		width = height = 100;
		img = ImageLoader.getPlayer(1);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Image getImg() {
		return img;
	}
	public void setImg(Image img) {
		this.img = img;
	}
	public void jump(){
		if(!isJump){
		force = -20;
		y = y + force;
		isJump = true;
		}
	}
	
	public void fall(){
		if(y<=GameConstants.FLOOR){
			force+=gravity;
			y +=force;
		}
		if(y>=GameConstants.FLOOR){
			isJump = false;
		}
	}
	int counter = 0;
	
	public void movement(){
		counter++;
		//System.out.println("Movement "+counter);
		switch(counter){
		case 1:
			img = ImageLoader.getPlayer(1);
			break;
		case 2:
			img = ImageLoader.getPlayer(2);
			break;
		case 3:
			img = ImageLoader.getPlayer(3);
			break;
		case 4:
			img = ImageLoader.getPlayer(4);
			break;
		case 5:
			img = ImageLoader.getPlayer(5);
			break;	
		}
		if(counter>=5){
			counter = 0;
		}
		
	}

}
