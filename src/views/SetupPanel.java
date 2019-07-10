package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import controls.GameControl;
import models.Constants;

public class SetupPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton btEasy;
	private JButton btMedium;
	private JButton btHard;
	private JButton btAccept;
	
	public SetupPanel(GameControl control) {

		setBackground(Constants.BACKGROUND_COLOR);
		btEasy = buttonSettings("Easy", control);
		btMedium = buttonSettings("Medium", control);
		btHard = buttonSettings("Hard", control);
		btAccept = buttonSettings("Accept", control);
		setupLayoutManager();
		setVisible(true);
	}
	
	private void setupLayoutManager() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(btEasy, constraints);
		constraints.gridx = 1;
		add(btMedium, constraints);
		constraints.gridx = 2;
		add(btHard, constraints);
		constraints.gridy = 1;
		constraints.gridx = 2;
		add(btAccept, constraints);
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
	public void selected(JButton button) {
		if (button == btEasy) {
			btEasy.setBackground(Constants.BACKGROUND_BUTTON__COLOR);
			
			btMedium.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
			btHard.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		} else if (button == btMedium) {
			btMedium.setBackground(Constants.BACKGROUND_BUTTON__COLOR);
			
			btEasy.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
			btHard.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		} else {
			btHard.setBackground(Constants.BACKGROUND_BUTTON__COLOR);
			
			btEasy.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
			btMedium.setBackground(Constants.BACKGROUND_BUTTON_COLOR);
		}
	}

	public JButton getBtEasy() {
		return btEasy;
	}

	public JButton getBtMedium() {
		return btMedium;
	}

	public JButton getBtHard() {
		return btHard;
	}

	public JButton getBtAccept() {
		return btAccept;
	}
}
