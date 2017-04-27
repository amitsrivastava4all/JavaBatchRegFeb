import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainScreen extends JFrame {

	
	

	
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("GAME-2017 - Welcome Screen");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu gameMenu = new JMenu("Choose Your Game ");
		menuBar.add(gameMenu);
		JMenuItem ballGame = new JMenuItem("Ball Game");
		ballGame.addActionListener((e)->loadBallGame());
		JMenuItem marioGame = new JMenuItem("Mario Game");
		marioGame.addActionListener((e)->loadMarioGame());
		gameMenu.add(ballGame);
		gameMenu.add(marioGame);
		gameMenu.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener((e)->exitGame());
		gameMenu.add(exit);
		
		
		
		
	}
	private void loadBallGame(){
		BallMove ballMove = new BallMove();
	}
	
	private void loadMarioGame(){
		GameFrame gameFrame = new GameFrame();
	}
	private void exitGame(){
		this.setVisible(false);
		this.dispose();
	}

}
