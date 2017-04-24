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
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D twoD = (Graphics2D)(g);
		
		drawBackGround(twoD);
		drawPlayer(twoD);
		drawBird(twoD);
		//System.out.println("Painting Going On...");
	}
	
	public void drawPlayer(Graphics2D g){
		
		g.drawImage(ImageLoader.getPlayer()
				,player.getX() ,player.getY()
				,player.getWidth(),player.getHeight(),null);
		player.fall();
	}
	
public void drawBird(Graphics2D g){
		
		g.drawImage(bird.getImage()
				,bird.getX() ,bird.getY()
				,bird.getW(),bird.getH(),null);
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
}
