import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import jaco.mp3.player.MP3Player;

public class GameSplashScreen extends JWindow {

	
	public static void main(String[] args) {
		UIManager.put("ProgressBar.selectionForeground", Color.ORANGE);
		
					GameSplashScreen frame = new GameSplashScreen();
					frame.setVisible(true);
					frame.playSong();
					
				
	}

	/**
	 * Create the frame.
	 */
	private Timer animationTimer;
	JLabel lblGame = new JLabel("Game-2017");
	private boolean isVisible = true;
	JProgressBar progressBar = new JProgressBar();
	int progressValue = 1;
	private void doProgress(){
		if(progressValue<=100){
			progressBar.setValue(progressValue);
			progressValue++;
		}
		else
		{
			if(mp3!=null){
				mp3.stop();
			}
			if(animationTimer!=null){
				animationTimer.stop();
			}
			this.setVisible(false);
			this.dispose();
			MainScreen mainScreen = new MainScreen();
			mainScreen.setVisible(true);
		}
	}
	private void animate(){
		lblGame.setVisible(isVisible);
		isVisible = !isVisible;
		doProgress();
	}
	MP3Player mp3;
	private void playSong(){
		mp3 = new MP3Player(GameSplashScreen.class.getResource("pop.mp3"));
		mp3.play();
	}
	
	public GameSplashScreen() {
		getContentPane().setBackground(Color.BLACK);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblGame.setBounds(177, 273, 308, 42);
		getContentPane().add(lblGame);
		Icon image = new ImageIcon(GameSplashScreen.class.getResource("intro.gif"));
		
		
		progressBar.setBorder(new LineBorder(Color.CYAN, 5, true));
		progressBar.setBackground(Color.GREEN);
		
		progressBar.setFont(new Font("Lucida Grande", Font.BOLD, 27));
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(28, 327, 646, 31);
		
		getContentPane().add(progressBar);
		
		JLabel introlbl = new JLabel("");
		introlbl.setHorizontalAlignment(SwingConstants.CENTER);
		introlbl.setIcon(image);
		introlbl.setBounds(18, 6, 676, 366);
		getContentPane().add(introlbl);
		animationTimer = new Timer(100,(e)->animate());
		animationTimer.start();
	
		
	}
}
