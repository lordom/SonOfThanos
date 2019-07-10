package views;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.Constants;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel;
	
	public AboutDialog() {
		setTitle("Ranking");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(650, 390);
		setLocationRelativeTo(null);
		cursor();
		initPanel();
		setVisible(true);
	}
	private void initPanel() {
		jPanel = new JPanel();
		jPanel.setBackground(Constants.BACKGROUND_COLOR);
		
		JTextArea txAbout = new JTextArea();
		txAbout.setText(Constants.ABOUT);
		txAbout.setEditable(false);
		txAbout.setFont(Constants.FONT_TEXT_ABOUT);
		txAbout.setForeground(Constants.FOREGROUND_LABEL_COLOR);
		txAbout.setBackground(Constants.BACKGROUND_COLOR);
		
		JLabel lblTitle = new JLabel(Constants.TITLE);
		lblTitle.setFont(Constants.FONT_UTIL);
		lblTitle.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setVerticalAlignment(JLabel.EAST);
		
		jPanel.add(lblTitle);
		jPanel.add(txAbout);
		this.add(jPanel);
	}
	
	private void cursor(){
	    Cursor cursor;
	    ImageIcon images = new ImageIcon(getClass().getResource(Constants.IMG_CURSOR_PATH));
	    Toolkit t = Toolkit.getDefaultToolkit();
	    cursor = t.createCustomCursor(images.getImage(),new Point(0,0), "Cursor");
	    setCursor(cursor);
	}
}
