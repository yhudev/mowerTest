package com.yh.mower.models.utils;

import org.junit.Test;

public class LawnTest {

	@Test(expected = IllegalArgumentException.class)
	public void testLawnInvalidX() {
		new Lawn(-2, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLawnInvalidY() {
		new Lawn(3, -5);
	}

}
