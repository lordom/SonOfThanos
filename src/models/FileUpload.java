package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileUpload {
	private ArrayList<Player> players;
	File file;
	
	public FileUpload() {
		players = new ArrayList<>();
		readFile();
	}

	private void readFile() {
		String line;
		String [] player;
		InputStream inputStream = null;
		try {
			
			inputStream = getClass().getResourceAsStream(Constants.FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			while ((line = bufferedReader.readLine()) != null) {
				player = line.split(",");
				players.add(new Player(player[0], Integer.parseInt(player[1])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void writeFile() {
		FileWriter fileWriter = null; 
		try {
			fileWriter = new FileWriter("./src/records/rankings.txt");
			@SuppressWarnings("resource")
			PrintWriter printWriter = new PrintWriter(fileWriter);
			
			for (Player player : players) {
				printWriter.println(player.getName()+ "," + String.valueOf(player.getScore()));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void writeFile(ArrayList<Player> players) {
		this.players = new ArrayList<>();
		this.players = players;
		writeFile();
		
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
}
