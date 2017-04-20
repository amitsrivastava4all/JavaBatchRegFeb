import java.awt.Image;

import javax.swing.ImageIcon;

public interface ImageLoader {
	
	public static Image getBackGround(){
		Image image = new ImageIcon(ImageLoader.class.getResource("bg.jpg")).getImage();
		return image;
	}
	public static Image getPlayer(){
		Image image = new ImageIcon(ImageLoader.class.getResource("mario.gif")).getImage();
		return image;
	}

}
