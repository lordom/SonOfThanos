package models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constants {
	
	public final static int SIZE_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final static int SIZE_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public final static int SIZE_PLANET = 64;
	public final static int SIZE_MAX_WIDTH = SIZE_WIDTH-SIZE_PLANET;
	public final static int SIZE_MAX_HEIGHT = SIZE_HEIGHT-(SIZE_PLANET+64);
	public final static int SIZE_MIN_WIDTH = 0;
	public final static int SIZE_MIN_HEIGHT = 0;
	public final static int MORE_PLANETS = 8000;
	
	public final static String TITLE = "Son of Thanos";
	public final static String RANKING = "Top Five";
	public final static Font FONT_UTIL = new Font("Ebrima", Font.BOLD, 35);
	public final static Font FONT_SCORE = new Font("Ebrima", Font.BOLD, 120);
	public final static Font FONT_LABEL = new Font("Ebrima", Font.BOLD, 30);
	public final static Font FONT_BUTTON = new Font("Ebrima", Font.BOLD, 20);
	public final static Font FONT_TEXT_ABOUT = new Font("Ebrima", 1, 13);
	
	public static final Color BACKGROUND_COLOR = new Color(11,11,13);
	public static final Color BACKGROUND_BUTTON_COLOR = new Color(21,21,23);
	public static final Color FOREGROUND_BUTTON_COLOR = new Color(185,56,215); 
	public static final Color FOREGROUND_LABEL_COLOR = new Color(148,148,166); 
	public static final Color FOREGROUND_COLOR = new Color(185,56,215);
	public static final Color BACKGROUND_BUTTON__COLOR = new Color(148,148,166);
	
	public static final String IMG_ALIEN_PATH = "/images/alien.png";
	public static final String AUDIO_PATH = "/audio/collect.wav";
	public static final String IMG_CURSOR_PATH = "/images/puntero.png";
	public static final String IMG_BACKGROUND = "/images/background.jpg";
	public static final String FILE_PATH = "/records/rankings.txt";
	
	public static final String INTRO = "You belong to the offspring of Thanos\n"
			+ "and you must continue with his legacy. \n\n"
			+ "You have the power to destroy a planet\n"
			+ "with just touching it, you have one minute \n"
			+ "to destroy the greatest amount of planets.\n";
	
	public static final String ABOUT = "\nSon of Thanos 1.0\n" + "\n"
			+ "Copyright © 2019 lordom Company Systems Incorporated and its licensors. All Rights Reserved.\n"
			+ "Desarrollado por Jose Rojas Programacion III UPTC\n" + "TUNJA 06/2019\n" + "\n"
			+ "TENGA EN CUENTA:  el uso que haga de este software está sujeto a los terminos\n"
			+ "y condiciones del contrato de licencia con el que adquirió el software.\n"
			+ "La reproduccion o distribucion no autorizada de este programa o de cualquier parte de el\n"
			+ "puede dar lugar a severas sanciones civiles y penales.\n" + "\n"
			+ "¿Tiene algun comentario? ¿Ha encontrado un error?\n" + "Haganoslo saber:\n"
			+ "jose.rojas08@Uptc.edu.co";
}
