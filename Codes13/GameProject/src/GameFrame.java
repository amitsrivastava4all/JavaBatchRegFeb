import javax.swing.JFrame;

public class GameFrame extends JFrame implements GameConstants {
	Board board = new Board();
	public GameFrame(){
		setSize(GWIDTH,GHEIGHT);
		setTitle(GAME_TITLE);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		this.add(board);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame gameFrame = new GameFrame();

	}

}
