package com.yh.mower.models.receiver;

/**
 * Mower, the receiver class in command pattern, includes its position
 * 
 * @author huyue
 *
 */
public class Mower {
	private MowerPosition position;

	/**
	 * Constructor {@link Mower}
	 * 
	 * @param position
	 */
	public Mower(MowerPosition position) {
		super();
		this.position = position;
	}

	/**
	 * Constructor {@link Mower}
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 * @param xMax
	 * @param yMax
	 */
	public Mower(int x, int y, String orientation, int xMax, int yMax) {
		super();
		this.position = new MowerPosition(x, y, orientation, xMax, yMax);
	}

	/**
	 * @return the position
	 */
	public MowerPosition getPosition() {
		return position;
	}

	/**
	 * Turn left
	 */
	public void turnLeft() {
		position.rotate90deg(false);
	}

	/**
	 * Turn right
	 */
	public void turnRight() {
		position.rotate90deg(true);
	}

	/**
	 * Move one step towards its orientation
	 */
	public void move() {
		position.moveInOrientation();
	}
}
