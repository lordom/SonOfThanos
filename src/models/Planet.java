package models;

import javax.swing.ImageIcon;

public class Planet {
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private ImageIcon image;
	private boolean collect;
	
	public Planet(int x, int y, int dx, int dy) {
		image = null;
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		collect = false;
	}

	public int getX() {
		return x;
	}
	
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isCollect() {
		return collect;
	}

	public void setCollect(boolean collect) {
		this.collect = collect;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
}
