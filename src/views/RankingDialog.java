package views;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import models.Constants;
import models.FileUpload;
import models.Player;

public class RankingDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private FileUpload fileUpload; 
	private JPanel jPanel;
	private String ranking;
	
	public RankingDialog() {
		fileUpload = new FileUpload();
		setTitle("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Constants.IMG_ALIEN_PATH)));
		setSize(250, 250);
		setLocationRelativeTo(null);
		cursor();
		text();
		initPanel();
		setVisible(true);
	}
	private void text() {
		ranking = "";
		ArrayList<Player> playes = fileUpload.getPlayers();
		for (Player player : playes) {
			ranking += player.getName()+ " ----- "+ String.valueOf(player.getScore())+ "\n";
		}
	}
	private void initPanel() {
		jPanel = new JPanel();
		jPanel.setBackground(Constants.BACKGROUND_COLOR);
		
		
		JTextArea txAbout = new JTextArea();
		txAbout.setText(ranking);
		txAbout.setEditable(false);
		txAbout.setFont(Constants.FONT_BUTTON);
		txAbout.setForeground(Constants.FOREGROUND_COLOR);
		txAbout.setBackground(Constants.BACKGROUND_COLOR);
		
		JLabel lblTitle = new JLabel(Constants.RANKING);
		lblTitle.setFont(Constants.FONT_UTIL);
		lblTitle.setForeground(Constants.FOREGROUND_LABEL_COLOR);
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
