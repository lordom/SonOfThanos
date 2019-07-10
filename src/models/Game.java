package models;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

public class Game implements Runnable{

	private ArrayList<Planet> planets;
	private ArrayList<ImageIcon> images;
	private int numberPlanets;
	private Thread thread;
	private int score;
	private int time;
	private int timeSleep;
	private boolean alive;
	
	public Game(int numberPlanets, int timeSleep) {
		alive = true;
		this.timeSleep = timeSleep;
		this.numberPlanets = numberPlanets;
		planets = new ArrayList<>();
		uploadImages();
		createPlanets(planets, 0);
		thread = new Thread(this);
		thread.start();
		score = 0;
	}
	
	@Override
	public void run() {
		long currentTime = System.currentTimeMillis();
		int morePlanets = Constants.MORE_PLANETS;
		while(System.currentTimeMillis()-currentTime <= 60000) {
			time = (int) ((60000 - (System.currentTimeMillis()-currentTime))/1000);
			Iterator<Planet> planetsIterator = planets.iterator();
			while (planetsIterator.hasNext()) {
				Planet planet = planetsIterator.next();
				if (planet.isCollect()) {
					planetsIterator.remove();
					score ++;
				} else {
					move(planet);
				}
			}			
			if (System.currentTimeMillis()-currentTime >= morePlanets) {
				createPlanets(planets, score);
				morePlanets += Constants.MORE_PLANETS;
			}
			try {
				Thread.sleep(timeSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		alive = false;
	}
	public void collected(int x, int y){
		for (Planet palnet : planets) {
			if(32 >= distance(new Point(palnet.getX()+32, palnet.getY()+32),new Point(x,y))) {
				palnet.setCollect(true);
				playSound(Constants.AUDIO_PATH);
			}
		}
	}
	private int distance(Point poitPlanet, Point pointMouse) {
        return (int) (Math.sqrt(Math.pow(Math.abs(pointMouse.x - poitPlanet.x),2) + Math.pow(Math.abs(pointMouse.y - poitPlanet.y),2) ));
	}
	private void createPlanets(ArrayList<Planet> planets,int score) {
		Point point = new Point();
		int dx, dy;
		Planet planet;
		for (int i = 0; i < numberPlanets; i++) {
			point = generateRandomPoint();
			dx = directionMovement();
			dy = directionMovement();
			planet = new Planet((int)point.getX(), (int) point.getY(), dy, dx);
			planet.setImage(randomImage());
			planets.add(planet);
		}
	}
	private void uploadImages() {
		images = new ArrayList<>();
		ImageIcon image;
		String path;
		for (int i = 1; i <= 23; i++) {
			path = "/images/planeta"+ i +".png";
			image = new ImageIcon(getClass().getResource(path));
			images.add(image);
		}
	}
	private ImageIcon randomImage() {
		int index = (int) (Math.random() * 23);
		return images.get(index);
	}
	
	private void move(Planet planet) {
		int dx = planet.getDx();
		int dy = planet.getDy();
		int x = planet.getX();
		int y = planet.getY();
		if(x + dx > Constants.SIZE_MAX_WIDTH || x + dx < 0) {
			dx = -dx;
			planet.setDx(dx);
		}
		if(y + dy >  Constants.SIZE_MAX_HEIGHT || y + dy < 0) {
			dy = -dy;
			planet.setDy(dy);
		}
		planet.setX(x += dx);
		planet.setY(y += dy);
	}
	
	public void playSound(final String path){
		new Thread(new Runnable() { 
			@Override
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource(path));
					clip.open(inputStream);
					clip.start();
				} catch (LineUnavailableException |UnsupportedAudioFileException | IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	private int directionMovement() {
		int move;
		int direction;
		move = generateRandom();
		if (move == 0) {
			direction = -1;
		}else {
			direction = 1;
		}
		return direction;
	}
	
	private int generateRandom() {
		return (int) (Math.random()*2);
	}
	
	private Point generateRandomPoint() {
		int x = (int) (Math.random()*(Constants.SIZE_MAX_WIDTH));
		int y = (int) (Math.random()*(Constants.SIZE_MAX_HEIGHT));
		return new Point(x, y);
	}
	
	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public int getScore() {
		return score;
	}

	public int getTime() {
		return time;
	}

	public Thread getThread() {
		return thread;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
