import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements GameConstants {
	
	Player player = new Player();
	Bird bird = new Bird(0);
	Bird bird2 = new Bird(300);
	private Timer timer ;
	public Board(){
		//setBackground(Color.BLACK);
		setSize(GWIDTH,GHEIGHT);
		gameLoop();
		setFocusable(true);
		this.addKeyListener(new KeyAdapter(){

			

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_SPACE){
					player.jump();
				}
				//System.out.println("Press "+e.getKeyCode()+ " "+e.getKeyChar());
			}

			
			
		});
		
	}
	
	private void gameLoop(){
//		ActionListener l = new ActionListener(){
//			@Override
//		public void actionPerformed(ActionEvent e){
//		repaint();	
//		}
//		};
//		timer = new Timer(DELAY,l);
		timer = new Timer(DELAY, (e)->repaint());
		
		
		timer.start();
		// repaint will call paintComponent
	}
	
	private void gameOver(Graphics2D twoD){
		twoD.setColor(Color.RED);
		twoD.setFont(new Font("Arial",Font.BOLD,32));
		twoD.drawString("Game Over", 500, 250);
		timer.stop();
	}
	private void checkGameStatus(Graphics2D twoD){
		if(checkCollision(player, bird)){
			gameOver(twoD);
		}
		if(checkCollision(player, bird2)){
			gameOver(twoD);
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D twoD = (Graphics2D)(g);
		
		drawBackGround(twoD);
		drawPlayer(twoD);
		drawBird(twoD);
		
		checkGameStatus(twoD);
		//System.out.println("Painting Going On...");
	}
	
	public void drawPlayer(Graphics2D g){
		
		g.drawImage(player.getImg()
				,player.getX() ,player.getY()
				,player.getWidth(),player.getHeight(),null);
		player.movement();
		player.fall();
	}
	
public void drawBird(Graphics2D g){
		
		g.drawImage(bird.getImage()
				,bird.getX() ,bird.getY()
				,bird.getW(),bird.getH(),null);
		bird2.setImage(ImageLoader.getBirdDragon());
		g.drawImage(bird2.getImage()
				,bird2.getX() ,bird2.getY()
				,bird2.getW(),bird2.getH(),null);
		bird.move();
		bird2.move();
	}
	
	public void drawBackGround(Graphics2D g){
		
		g.drawImage(ImageLoader.getBackGround(),
				0,0,GWIDTH,GHEIGHT,null);
	}
	
	public boolean checkCollision(Player player, Bird bird){
		int xDistance = Math.abs(player.getX() - bird.getX());
		int yDistance = Math.abs(player.getY()- bird.getY());
		System.out.println("X "+xDistance+" W "+(player.getWidth()-50));
		System.out.println("Y "+yDistance+ " H "+(player.getHeight()-50));
		return xDistance<=player.getWidth()-50 && yDistance<=player.getHeight()-30;
	}
}
