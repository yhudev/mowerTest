package com.yh.mower.models.receiver;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yh.mower.enums.Orientation;

public class MowerPositionTest {
	private MowerPosition position_1;
	private MowerPosition position_2;
	private MowerPosition position_3;

	@Before
	public void setUp() {
		position_1 = new MowerPosition(3, 4, "N", 5, 5);
		position_2 = new MowerPosition(3, 3, "S", 5, 5);
		position_3 = new MowerPosition(3, 3, "E", 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidX() {
		new MowerPosition(-1, 1, "N", 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidY() {
		new MowerPosition(1, -1, "N", 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidXMax() {
		new MowerPosition(1, 1, "N", -5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidYMax() {
		new MowerPosition(1, 1, "N", 5, -5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidXInput() {
		new MowerPosition(7, 1, "N", 5, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMowerPositionInvalidYInput() {
		new MowerPosition(2, 9, "N", 5, 5);
	}

	@Test
	public void testMoveInOrientation() {
		// North
		position_1.moveInOrientation();
		assertEquals(3, position_1.getX());
		assertEquals(5, position_1.getY());
		position_1.moveInOrientation();
		assertEquals(3, position_1.getX());
		assertEquals(5, position_1.getY());
		// South
		position_1 = new MowerPosition(1, 1, "S", 5, 5);
		position_1.moveInOrientation();
		assertEquals(1, position_1.getX());
		assertEquals(0, position_1.getY());
		position_1.moveInOrientation();
		assertEquals(1, position_1.getX());
		assertEquals(0, position_1.getY());
		// East
		position_1 = new MowerPosition(4, 2, "E", 5, 5);
		position_1.moveInOrientation();
		assertEquals(5, position_1.getX());
		assertEquals(2, position_1.getY());
		position_1.moveInOrientation();
		assertEquals(5, position_1.getX());
		assertEquals(2, position_1.getY());
		// West
		position_1 = new MowerPosition(1, 4, "W", 5, 5);
		position_1.moveInOrientation();
		assertEquals(0, position_1.getX());
		assertEquals(4, position_1.getY());
		position_1.moveInOrientation();
		assertEquals(0, position_1.getX());
		assertEquals(4, position_1.getY());
	}

	@Test
	public void testRotate90deg() {
		position_2.rotate90deg(true);
		assertEquals(Orientation.WEST, position_2.getOrientation());
		position_2.rotate90deg(false);
		assertEquals(Orientation.SOUTH, position_2.getOrientation());
	}

	@Test
	public void testToString() {
		String toString = position_3.toString();
		assertEquals("3 3 E", toString);
	}

}
