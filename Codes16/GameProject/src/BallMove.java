import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallMove extends JFrame {
	BallBoard board = new BallBoard();
	public static final int GWIDTH = 900;
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
	ArrayList<Ball> balls = new ArrayList<Ball>();
	//Ball ball = new Ball(300,300);
	MyRandom randomX = new MyRandom(BallMove.GWIDTH);
	MyRandom randomY = new MyRandom(BallMove.GHEIGHT);
	static MyRandom random = new MyRandom(10);
	static MyRandom randomColor = new MyRandom(50);
	
	
	public void prepareBalls(){
		for(int i = 1; i<=50 ; i++){
			System.out.println("Ball Prepare "+randomX.getRandom()+" "+randomY.getRandom());
			balls.add(new Ball(randomX.getRandom(),randomY.getRandom()));
		}
	}
	public void printBalls(Graphics2D twoD){
		for(Ball ball : balls){
			
			ball.drawBall(twoD);
			ball.moveBall();
			ball.changeDirection();
		}
	}
	
	BallBoard(){
		setBackground(Color.BLACK);
		setSize(BallMove.GWIDTH,BallMove.GHEIGHT);
		prepareBalls();
		timer = new Timer(50,(e)->repaint());
		timer.start();
	}
	public void paintComponent(Graphics g){
		Graphics2D twoD = (Graphics2D)g;
		
		printBalls(twoD);
//		ball.drawBall(twoD);
//		ball.moveBall();
//		ball.changeDirection();
		
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
	Ball(int x, int y){
		this.x = x;
		this.y = y;
		w = 50;
		h = 50;
		
	}
	void drawBall(Graphics2D twoD){
		//twoD.setBackground(Color.YELLOW);
		int color = BallBoard.randomColor.getRandom();
		twoD.setColor(new Color(color*2, color*3, color*5));
		//twoD.setBackground(new Color(color, color, color));
		twoD.fillOval(x, y, w, h);
		
	}
	
	void moveBall(){
		x = x +xSpeed;
		y = y + ySpeed;
		//System.out.println("Move "+x+" "+y+" "+xSpeed);
	}
	void changeDirection(){
		if(x>=BallMove.GWIDTH-50){
			xSpeed = -BallBoard.random.getRandom();
		}
		if(x<=0){
			xSpeed = BallBoard.random.getRandom();
		}
		if(y>=BallMove.GHEIGHT-50){
			ySpeed = -BallBoard.random.getRandom();
		}
		if(y<=0){
			ySpeed = BallBoard.random.getRandom();
		}
	//System.out.println("Change Direction "+xSpeed +" "+ySpeed+" x "+x+" Y "+y);
	}
	
	
}
class MyRandom
{
	Random random;
	int max;
	
	MyRandom(int max){
		this.max = max;
		random = new Random(max);
	}
	int getRandom(){
		
		int randomeNo=0;
		while(true){
			 randomeNo = random.nextInt(max);
			if(randomeNo<=0){
				continue;
			}
			else{
				break;
			}
		}
		//System.out.println(randomeNo);
		return randomeNo;
	}
}