import java.awt.Image;

public class Bird {
	private int x;
	private int y;
	private int w;
	private int h;
	private Image image;
	private int speed = -2;
	public Bird(int distance){
		x = GameConstants.GWIDTH + distance;
		y = GameConstants.FLOOR - 50;
		w = h = 100;
		image = ImageLoader.getBird();
	}
	public void move(){
		x +=speed;
		if(x<=0){
			x = GameConstants.GWIDTH;
		}
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
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	

}
