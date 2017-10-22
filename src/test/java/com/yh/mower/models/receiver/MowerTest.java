package com.yh.mower.models.receiver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MowerTest {
	private Mower mower_1;
	private Mower mower_2;
	private Mower mower_3;

	@Before
	public void setUp() {
		mower_1 = new Mower(new MowerPosition(3, 4, "N", 5, 5));
		mower_2 = new Mower(new MowerPosition(3, 4, "W", 5, 5));
		mower_3 = new Mower(new MowerPosition(3, 4, "S", 5, 5));
	}

	@Test
	public void testTurnLeft() {
		mower_1.turnLeft();
		assertEquals("W", mower_1.getPosition().getOrientation().getValue());
	}

	@Test
	public void testTurnRight() {
		mower_2.turnRight();
		assertEquals("N", mower_2.getPosition().getOrientation().getValue());
	}

	@Test
	public void testMove() {
		mower_3.move();
		assertEquals(3, mower_3.getPosition().getX());
		assertEquals(3, mower_3.getPosition().getY());
		assertEquals("S", mower_3.getPosition().getOrientation().getValue());
	}

}
