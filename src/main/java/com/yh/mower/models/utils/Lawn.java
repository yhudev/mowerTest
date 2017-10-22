package com.yh.mower.models.utils;

import com.yh.mower.enums.ErrorMsg;

/**
 * Lawn with width and height
 * 
 * @author huyue
 *
 */
public class Lawn {
	private final int xMax;
	private final int yMax;

	/**
	 * Constructor {@link Lawn}
	 * 
	 * @param xMax
	 * @param yMax
	 */
	public Lawn(int xMax, int yMax) {
		if (xMax < 0 || yMax < 0) {
			throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
		}
		this.xMax = xMax;
		this.yMax = yMax;
	}

	/**
	 * Get width
	 * 
	 * @return the xMax
	 */
	public int getxMax() {
		return xMax;
	}

	/**
	 * Get height
	 * 
	 * @return the yMax
	 */
	public int getyMax() {
		return yMax;
	}

}
