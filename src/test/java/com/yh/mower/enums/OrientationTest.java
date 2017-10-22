package com.yh.mower.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrientationTest {

	@Test
	public void testGetValue() {
		assertEquals("N", Orientation.NORTH.getValue());
		assertEquals("S", Orientation.SOUTH.getValue());
		assertEquals("E", Orientation.EAST.getValue());
		assertEquals("W", Orientation.WEST.getValue());
	}

	@Test
	public void testGetNext() {
		assertEquals(Orientation.EAST, Orientation.NORTH.getNext());
		assertEquals(Orientation.WEST, Orientation.SOUTH.getNext());
		assertEquals(Orientation.SOUTH, Orientation.EAST.getNext());
		assertEquals(Orientation.NORTH, Orientation.WEST.getNext());
	}

	@Test
	public void testGetPrev() {
		assertEquals(Orientation.WEST, Orientation.NORTH.getPrev());
		assertEquals(Orientation.EAST, Orientation.SOUTH.getPrev());
		assertEquals(Orientation.NORTH, Orientation.EAST.getPrev());
		assertEquals(Orientation.SOUTH, Orientation.WEST.getPrev());
	}

	@Test
	public void testGetOrientation() {
		assertEquals(Orientation.NORTH, Orientation.getOrientation("N"));
		assertEquals(Orientation.SOUTH, Orientation.getOrientation("S"));
		assertEquals(Orientation.EAST, Orientation.getOrientation("E"));
		assertEquals(Orientation.WEST, Orientation.getOrientation("W"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetOrientationError() {
		Orientation.getOrientation("X");
	}

}
