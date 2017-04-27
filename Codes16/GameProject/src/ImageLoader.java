import java.awt.Image;

import javax.swing.ImageIcon;

public interface ImageLoader {
	
	public static Image getBackGround(){
		Image image = new ImageIcon(ImageLoader.class.getResource("finalfloor.png")).getImage();
		return image;
	}
	public static Image getPlayer(int position){
		GameSprite sprite = new GameSprite("sprite.png");
		Image image = sprite.getSubImage(position);
		//Image image = new ImageIcon(ImageLoader.class.getResource("mario.gif")).getImage();
		return image;
	}
	public static Image getBird(){
		Image image = new ImageIcon(ImageLoader.class.getResource("dragon.gif")).getImage();
		return image;
	}

	public static Image getBirdDragon(){
		Image image = new ImageIcon(ImageLoader.class.getResource("bird.gif")).getImage();
		return image;
	}
}
