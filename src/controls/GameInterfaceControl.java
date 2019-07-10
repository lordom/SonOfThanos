package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Timer;

import models.Game;
import views.GameOverWindow;
import views.GameWindow;

public class GameInterfaceControl implements MouseListener{
	
	private Game game;
	private GameWindow gameWindow;
	private Timer gameThread;
	private GameOverWindow gameOverWindow;
	
	public GameInterfaceControl(GameControl control,int numberPlanets, int timeSleep){
		game = new Game(numberPlanets, timeSleep);
		gameWindow = new GameWindow(this);
		gameThread =  new Timer(4, new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				gameWindow.refresh(game.getPlanets(), game.getScore(), game.getTime());
				if (!game.isAlive()){
					stop(control);
				}
			};
		});
		gameThread.start();
		gameWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				gameThread.stop();
			}
		});
	}
	private void stop(GameControl control) {
		gameWindow.removeMouseListener(this);
		gameOverWindow = new GameOverWindow(control, String.valueOf(gameWindow.getScore()));
		gameThread.stop();
		gameThread = null;
		gameWindow.setVisible(false);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		game.collected(e.getX(), e.getY());
//		gameWindow.refresh(game.getEmojis());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	public GameWindow getGameWindow() {
		return gameWindow;
	}
	public GameOverWindow getGameOverWindow() {
		return gameOverWindow;
	}
	public Game getGame() {
		return game;
	}
}
