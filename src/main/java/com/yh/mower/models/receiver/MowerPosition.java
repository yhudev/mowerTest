package com.yh.mower.models.receiver;

import com.yh.mower.enums.ErrorMsg;
import com.yh.mower.enums.Orientation;

/**
 * Position information for mower
 * 
 * @author huyue
 *
 */
public class MowerPosition {
	private int x;
	private int y;
	private Orientation orientation;
	private int xMax;
	private int yMax;

	/**
	 * Constructor {@link MowerPosition}
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 * @param xMax
	 * @param yMax
	 */
	public MowerPosition(int x, int y, Orientation orientation, int xMax, int yMax) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * Constructor {@link MowerPosition}
	 * 
	 * @param x
	 * @param y
	 * @param orientation
	 * @param xMax
	 * @param yMax
	 */
	public MowerPosition(int x, int y, String orientation, int xMax, int yMax) {
		super();
		if (xMax < 0 || yMax < 0 || x < 0 || y < 0 || x > xMax || y > yMax) {
			throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
		}
		this.x = x;
		this.y = y;
		this.orientation = Orientation.getOrientation(orientation);
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the xMax
	 */
	public int getxMax() {
		return xMax;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the yMax
	 */
	public int getyMax() {
		return yMax;
	}

	/**
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * Move the position towards its orientation
	 */
	public void moveInOrientation() {
		switch (orientation) {
		case NORTH:
			y = y + 1 <= yMax ? y + 1 : y;
			break;
		case SOUTH:
			y = y - 1 >= 0 ? y - 1 : y;
			break;
		case EAST:
			x = x + 1 <= xMax ? x + 1 : x;
			break;
		case WEST:
			x = x - 1 >= 0 ? x - 1 : x;
			break;
		default:
			break;
		}
	}

	/**
	 * Rotate the orientation clockwise or counterclockwise
	 * 
	 * @param isCW
	 */
	public void rotate90deg(boolean isCW) {
		if (isCW)
			rotateCW();
		else
			rotateCCW();
	}

	private void rotateCCW() {
		orientation = orientation.getPrev();
	}

	private void rotateCW() {
		orientation = orientation.getNext();
	}

	@Override
	public String toString() {
		return x + " " + y + " " + orientation.getValue();
	}

}
