import java.awt.Image;

public class Player {
	private int x;
	private int y;
	private int width;
	private int height;
	private Image img;
	private int gravity;
	private int force;
	public Player(){
		gravity = 1;
		x = 100;
		y =GameConstants.FLOOR;
		width = height = 100;
		img = ImageLoader.getPlayer();
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
		force = -15;
		y = y + force;
	}
	
	public void fall(){
		if(y<=GameConstants.FLOOR){
			force+=gravity;
			y +=force;
		}
	}

}
