import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallMove extends JFrame {
	BallBoard board = new BallBoard();
	public static final int GWIDTH = 600;
	public static final int GHEIGHT = 600;
	
public BallMove(){
	setSize(GWIDTH,GHEIGHT);
	setLocationRelativeTo(null);
	this.add(board);
	setVisible(true);
}
public static void main(String[] args) {
	BallMove move =new BallMove();
	
}
}
class BallBoard extends JPanel{
	Timer timer ;
	Ball ball = new Ball(300,300);
	BallBoard(){
		setBackground(Color.BLACK);
		setSize(BallMove.GWIDTH,BallMove.GHEIGHT);
		timer = new Timer(50,(e)->repaint());
		timer.start();
	}
	public void paintComponent(Graphics g){
		Graphics2D twoD = (Graphics2D)g;
		twoD.setColor(Color.YELLOW);
		ball.drawBall(twoD);
		ball.moveBall();
		ball.changeDirection();
		
	}
}
class Ball{
	private int x;
	private int y;
	private int w;
	private int h;
	private final int GAMESPEED = 5;
	private int xSpeed = GAMESPEED;
	private int ySpeed = GAMESPEED;
	Ball(int x, int y){
		w = 50;
		h = 50;
		
	}
	void drawBall(Graphics2D twoD){
		twoD.setBackground(Color.YELLOW);
		
		twoD.fillOval(x, y, w, h);
		
	}
	
	void moveBall(){
		x = x +xSpeed;
		y = y + ySpeed;
	}
	void changeDirection(){
		if(x>=BallMove.GWIDTH){
			xSpeed = -GAMESPEED;
		}
		if(x<=0){
			xSpeed = GAMESPEED;
		}
		if(y>=BallMove.GHEIGHT){
			ySpeed = -GAMESPEED;
		}
		if(y<=0){
			ySpeed = GAMESPEED;
		}
	}
}
