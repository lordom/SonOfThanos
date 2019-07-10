package views;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controls.GameControl;
import models.Constants;
import models.FileUpload;
import models.Player;

public class GameOverWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private GameOverPanel gameOverPanel;
	
	public GameOverWindow(GameControl control, String score) {
		gameOverPanel = new GameOverPanel(control, IsItOnTheTop(Integer.valueOf(score)));
		cursor();
		gameOverPanel.setJlScore(score);
		init();
	}
	
	private void init() {
		setTitle("Game Over");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(270, 400);
		setLocationRelativeTo(null);
		add(gameOverPanel);
		setVisible(true);
	}
	private boolean IsItOnTheTop(int score) {
		boolean top = false;
		FileUpload fileUpload = new FileUpload();
		ArrayList<Player> arrayList = fileUpload.getPlayers();
		for (Player player : arrayList) {
			if (score >= player.getScore()) {
				top = true;
			}
		}
		return top;
 	}
	private void cursor(){
	    Cursor cursor;
	    ImageIcon images = new ImageIcon(getClass().getResource(Constants.IMG_CURSOR_PATH));
	    Toolkit t = Toolkit.getDefaultToolkit();
	    cursor = t.createCustomCursor(images.getImage(),new Point(0,0), "Cursor");
	    setCursor(cursor);
	}

	public GameOverPanel getGameOverPanel() {
		return gameOverPanel;
	}
}
