import java.awt.Image;

import javax.swing.ImageIcon;

public interface ImageLoader {
	
	public static Image getBackGround(){
		Image image = new ImageIcon(ImageLoader.class.getResource("bg.jpg")).getImage();
		return image;
	}
	public static Image getPlayer(){
		GameSprite sprite = new GameSprite();
		Image image = sprite.getSubImage(1);
		//Image image = new ImageIcon(ImageLoader.class.getResource("mario.gif")).getImage();
		return image;
	}
	public static Image getBird(){
		Image image = new ImageIcon(ImageLoader.class.getResource("bird.gif")).getImage();
		return image;
	}

}
