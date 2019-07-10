package views;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controls.GameControl;
import models.Constants;

public class IntroDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel;
	
	public IntroDialog(GameControl control) {
		setTitle("Ranking");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(450, 250);
		setLocationRelativeTo(null);
		cursor();
		initPanel(control);
		setVisible(true);
	}
	private void initPanel(GameControl control) {
		jPanel = new JPanel();
		jPanel.setBackground(Constants.BACKGROUND_COLOR);
		
		JTextArea txAbout = new JTextArea();
		txAbout.setText(Constants.INTRO);
		txAbout.setEditable(false);
		txAbout.setFont(Constants.FONT_TEXT_ABOUT);
		txAbout.setForeground(Constants.FOREGROUND_LABEL_COLOR);
		txAbout.setBackground(Constants.BACKGROUND_COLOR);
		
		JLabel lblTitle = new JLabel(Constants.TITLE);
		lblTitle.setFont(Constants.FONT_UTIL);
		lblTitle.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setVerticalAlignment(JLabel.EAST);
		
		JButton btStar = new JButton("Star");
		btStar.setActionCommand("STAR");
		btStar.addActionListener(control);
		btStar.setFont(Constants.FONT_BUTTON);
		btStar.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		btStar.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		btStar.setBorder(new CircularEdge(20));
		btStar.setPreferredSize(new Dimension(120, 70));
		
		jPanel.add(lblTitle);
		jPanel.add(txAbout);
		jPanel.add(btStar);
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
