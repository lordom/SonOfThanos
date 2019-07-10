package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controls.GameControl;
import models.Constants;

public class GameOverPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jlOverGame;
	private JLabel jlScore;
	private JLabel jlInfo;
	private JButton btContinue;
	private JTextField txName;

	
	public GameOverPanel(GameControl control, boolean indicator) {
		initcomponents(control);
		if (indicator) {
			txName = new JTextField("Name");
			txName.setHorizontalAlignment(JLabel.CENTER);
			txName.setFont(Constants.FONT_BUTTON);
			txName.setForeground(Constants.BACKGROUND_COLOR);
			txName.setBackground(Constants.BACKGROUND_BUTTON__COLOR);
			setupLayoutManagerTwo();
		} else {
			setupLayoutManager();
		}
		
		this.setBackground(Constants.BACKGROUND_COLOR);
		setVisible(true);
	}
	private void initcomponents(GameControl control) {
		jlOverGame = new JLabel("Your Score");
		jlOverGame.setFont(Constants.FONT_LABEL);
		jlOverGame.setForeground(Constants.FOREGROUND_LABEL_COLOR);
		jlOverGame.setHorizontalAlignment(JLabel.CENTER);
		jlOverGame.setVerticalAlignment(JLabel.EAST);
		
		jlScore = new JLabel();
		jlScore.setFont(Constants.FONT_SCORE);
		jlScore.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		jlScore.setHorizontalAlignment(JLabel.CENTER);
		jlScore.setVerticalAlignment(JLabel.NORTH);
		
		jlInfo = new JLabel("Game over");
		jlInfo.setFont(Constants.FONT_UTIL);
		jlInfo.setForeground(Constants.FOREGROUND_LABEL_COLOR);
		jlInfo.setHorizontalAlignment(JLabel.CENTER);
		jlInfo.setVerticalAlignment(JLabel.NORTH);
		
		btContinue = new JButton("Continue");
		btContinue.setActionCommand("CONTINUE");
		btContinue.addActionListener(control);
		btContinue.setFont(Constants.FONT_BUTTON);
		btContinue.setForeground(Constants.FOREGROUND_BUTTON_COLOR);
		btContinue.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		btContinue.setBorder(new CircularEdge(20));
	}
	
	private void setupLayoutManager() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 5, 0, 5);
		add(jlInfo, constraints);
		constraints.gridy = 1;
		constraints.insets = new Insets(15, 5, 0, 5);
		add(jlOverGame, constraints);
		constraints.gridy = 2;
		constraints.ipady = 1;
		constraints.ipadx = 1;
		constraints.weighty = 0.5;
		constraints.insets = new Insets(0, 5, 0, 5);
		add(jlScore, constraints);
		constraints.gridy = 3;
		constraints.insets = new Insets(15, 20, 20, 15);
		add(btContinue, constraints);
	}
	
	private void setupLayoutManagerTwo() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		constraints.fill = GridBagConstraints.BOTH;
		constraints.weighty = 1;
		constraints.weightx = 1;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 5, 0, 5);
		add(jlInfo, constraints);
		constraints.gridy = 1;
		constraints.insets = new Insets(0, 5, 0, 5);
		add(jlOverGame, constraints);
		constraints.gridy = 2;
		constraints.ipady = 1;
		constraints.ipadx = 1;
		constraints.weighty = 0.5;
		constraints.insets = new Insets(0, 5, 0, 5);
		add(jlScore, constraints);
		constraints.gridy = 3;
		constraints.insets = new Insets(0, 15, 0, 15);
		txName.setPreferredSize(new Dimension(140, 40));
		add(txName, constraints);
		constraints.gridy = 4;
		constraints.insets = new Insets(5, 15, 5, 15);
		add(btContinue, constraints);
	}

	public void setJlScore(String score) {
		this.jlScore.setText(score);
	}
	public String getTxName() {
		if (txName == null) {
			return null;
		}else {
			return txName.getText();
		}
	}
}
