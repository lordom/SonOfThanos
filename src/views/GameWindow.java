package views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controls.GameInterfaceControl;
import models.Constants;
import models.Planet;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private GamePanel gamePanel;
	
	public GameWindow(GameInterfaceControl control) {
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setTitle(Constants.TITLE);
		cursor();
		gamePanel = new GamePanel();
		gamePanel.addMouseListener(control);
		add(gamePanel, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	public void refresh(ArrayList<Planet> planets, int score, int time) {
		gamePanel.refresh(planets, score, time);
	}
	private void cursor(){
	    Cursor cursor;
	    ImageIcon images = new ImageIcon(getClass().getResource(Constants.IMG_CURSOR_PATH));
	    Toolkit t = Toolkit.getDefaultToolkit();
	    cursor = t.createCustomCursor(images.getImage(),new Point(0,0), "Cursor");
	    setCursor(cursor);
	}
	public int getScore() {
		return gamePanel.getScore();
	}
}
