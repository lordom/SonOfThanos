package views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controls.GameControl;
import models.Constants;

public class GameOpenWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private GameOpenPanel gameOpenPanel;
	
	public GameOpenWindow(GameControl control) {
		gameOpenPanel = new GameOpenPanel(control);
		cursor();
		init();
	}
	
	private void init() {
		setTitle("Game Over");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(450, 400);
		setLocationRelativeTo(null);
		add(gameOpenPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void cursor(){
	    Cursor cursor;
	    ImageIcon images = new ImageIcon(getClass().getResource(Constants.IMG_CURSOR_PATH));
	    Toolkit t = Toolkit.getDefaultToolkit();
	    cursor = t.createCustomCursor(images.getImage(),new Point(0,0), "Cursor");
	    setCursor(cursor);
	}
}
