package views;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controls.GameControl;
import models.Constants;

public class SetupWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private SetupPanel setupPanel;
	
	public SetupWindow(GameControl control) {
		setupPanel = new SetupPanel(control);
		cursor();
		init();
	}
		
	private void init() {
		setTitle("Set Up");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(350, 200);
		setLocationRelativeTo(null);
		add(setupPanel);
		setVisible(true);
	}
	public void selected(JButton button) {
		setupPanel.selected(button);
	}

	public JButton getBtEasy() {
		return setupPanel.getBtEasy();
	}

	public JButton getBtMedium() {
		return setupPanel.getBtMedium();
	}

	public JButton getBtHard() {
		return setupPanel.getBtHard();
	}
	
	private void cursor(){
	    Cursor cursor;
	    ImageIcon images = new ImageIcon(getClass().getResource(Constants.IMG_CURSOR_PATH));
	    Toolkit t = Toolkit.getDefaultToolkit();
	    cursor = t.createCustomCursor(images.getImage(),new Point(0,0), "Cursor");
	    setCursor(cursor);
	}
}
