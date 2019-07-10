package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controls.GameControl;
import models.Constants;

public class GameOpenPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jlOverGame;
	private JButton btPlayGame;
	private JButton btSetUp;
	private JButton btRanking;
	private JButton btAbout;
	private JButton btExit;

	
	public GameOpenPanel(GameControl control) {
		initcomponents(control);
		setupLayoutManager();
		setBackground(Constants.BACKGROUND_COLOR);
		setVisible(true);
	}
	private void initcomponents(GameControl control) {
		jlOverGame = new JLabel(Constants.TITLE);
		jlOverGame.setFont(Constants.FONT_UTIL);
		jlOverGame.setForeground(Constants.FOREGROUND_LABEL_COLOR);
		jlOverGame.setHorizontalAlignment(JLabel.CENTER);
		jlOverGame.setVerticalAlignment(JLabel.EAST);
		
		btPlayGame = buttonSettings("Play", control);
		btPlayGame.setPreferredSize(new Dimension(200, 100));
		btSetUp = buttonSettings("Set Up", control);
		btRanking = buttonSettings("Ranking", control);
		btAbout = buttonSettings("About", control);
		btExit = buttonSettings("Exit", control);
	}
	
	private void setupLayoutManager() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 20, 0);
		constraints.gridwidth = 4;
		add(jlOverGame, constraints);
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		constraints.insets = new Insets(5, 20, 5, 5);
		add(btPlayGame, constraints);
		constraints.insets = new Insets(5, 5, 5, 20);
		constraints.gridy = 1;
		constraints.gridx = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		add(btSetUp, constraints);
		constraints.gridy = 2;
		constraints.gridx = 3;
		add(btRanking, constraints);
		constraints.insets = new Insets(5, 5, 20, 20);
		constraints.gridy = 3;
		constraints.gridx = 3;
		add(btExit, constraints);
		constraints.insets = new Insets(5, 20, 20, 5);
		constraints.gridy = 3;
		constraints.gridx = 0;
		constraints.gridwidth = 3;
		add(btAbout, constraints);
	}
	
	private JButton buttonSettings(String nameButon, GameControl control) {
		JButton button = new JButton(nameButon);
		nameButon = nameButon.replaceAll(" ", "");
		button.setActionCommand(nameButon.toUpperCase());
		button.addActionListener(control);
		button.setFont(Constants.FONT_BUTTON);
		button.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		button.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		button.setBorder(new CircularEdge(10));
		return button;
	}
}
