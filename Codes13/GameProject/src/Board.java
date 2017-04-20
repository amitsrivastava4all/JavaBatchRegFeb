import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	
	Player player = new Player();
	private Timer timer ;
	public Board(){
		//setBackground(Color.BLACK);
		setSize(GWIDTH,GHEIGHT);
		gameLoop();
		
	}
	
	private void gameLoop(){
		timer = new Timer(DELAY,(e)->repaint());
		timer.start();
		// repaint will call paintComponent
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D twoD = (Graphics2D)(g);
		
		drawBackGround(twoD);
		drawPlayer(twoD);
		System.out.println("Painting Going On...");
	}
	
	public void drawPlayer(Graphics2D g){
		
		g.drawImage(ImageLoader.getPlayer()
				,player.getX() ,player.getY()
				,player.getWidth(),player.getHeight(),null);
	}
	
	public void drawBackGround(Graphics2D g){
		
		g.drawImage(ImageLoader.getBackGround(),
				0,0,GWIDTH,GHEIGHT,null);
	}
}
