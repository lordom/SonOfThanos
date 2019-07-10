package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.FileUpload;
import models.Player;
import views.GameOpenWindow;
import views.IntroDialog;
import views.RankingDialog;
import views.AboutDialog;
import views.SetupWindow;

public class GameControl implements ActionListener {
	private SetupWindow setupWindow;
	private GameInterfaceControl gameInterfaceControl;
	int numberPlanets, timeSleep;
	
	
	public GameControl() {
		numberPlanets = 13;
		timeSleep = 10;
		new GameOpenWindow(this);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (ActionCommand.valueOf(event.getActionCommand())) {
		case PLAY:
			new IntroDialog(this);
			break;
		case SETUP:
			setupWindow = new SetupWindow(this);
			break;
		case RANKING:
			new RankingDialog();
			break;
		case ABOUT:
			new AboutDialog();
			break;
		case EXIT:
			System.exit(0);
			break;
		case EASY:
			setupWindow.selected(setupWindow.getBtEasy());
			numberPlanets = 18;
			timeSleep = 15;
			break;
		case MEDIUM:
			setupWindow.selected(setupWindow.getBtMedium());
			numberPlanets = 13;
			timeSleep = 10;
			break;
		case HARD:
			setupWindow.selected(setupWindow.getBtHard());
			numberPlanets = 8;
			timeSleep = 5;
			break;
		case ACCEPT:
			setupWindow.dispose();
			break;
		case CONTINUE:
			saveFile();
			gameInterfaceControl.getGameOverWindow().dispose();
			break;
		case STAR:
			gameInterfaceControl = new GameInterfaceControl(this, numberPlanets , timeSleep);
			break;
		default:
			break;
		}
	}
	private void saveFile() {
		if (gameInterfaceControl.getGameOverWindow().getGameOverPanel().getTxName() != null) {
			int score = gameInterfaceControl.getGame().getScore();
			Player top = new Player(gameInterfaceControl.getGameOverWindow().getGameOverPanel().getTxName(), score);
			FileUpload fileUpload = new FileUpload();
			ArrayList<Player> players = new ArrayList<>();
			ArrayList<Player> tops = fileUpload.getPlayers();
			for (Player player : tops) {
				if (score >= player.getScore()) {
					players.add(top);
					score = 0;
				} else {
					players.add(player);
				}
			}
			fileUpload.writeFile(players);
		}
	}

}
