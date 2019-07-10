package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import models.Constants;
import models.Planet;

public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Planet> planets;
	private int score;
	private int time; 
	public GamePanel() {
		planets = new ArrayList<>();
		setBackground(Constants.BACKGROUND_COLOR);
	}
	
	public void refresh(ArrayList<Planet> planets, int score, int time) {
		this.planets = planets;
		this.score = score;
		this.time = time;
		repaint();
	}
	
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		Image image = new ImageIcon(getClass().getResource(Constants.IMG_BACKGROUND)).getImage();
		graphics.drawImage(image, 0, 0, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), 
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight() , this);
		if (planets.size() > 0) {
			Planet planet;
			Iterator<Planet> planetsIterator = planets.iterator();
			while (planetsIterator.hasNext()) {
				planet = planetsIterator.next();
				graphics.drawImage(planet.getImage().getImage(), planet.getX(), planet.getY(), this);
				graphics.setFont(Constants.FONT_UTIL);
				graphics.setColor(Constants.BACKGROUND_BUTTON__COLOR);
				graphics.drawString("Score "+String.valueOf(score), Constants.SIZE_MAX_WIDTH-95, Constants.SIZE_MAX_HEIGHT+40);
				graphics.drawString("Time "+String.valueOf(time), Constants.SIZE_MAX_WIDTH-90, 40);
			}
		}
	}
	@Override
	protected void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);
	}
	public int getScore() {
		return score;
	}
}
