package com.yh.mower.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandRefTest {

	@Test
	public void testGetValue() {
		assertEquals("G", CommandRef.LEFT.getValue());
		assertEquals("D", CommandRef.RIGHT.getValue());
		assertEquals("A", CommandRef.STRAIGHT.getValue());
	}

	@Test
	public void testGetCommandRef() {
		assertEquals(CommandRef.LEFT, CommandRef.getCommandRef("G"));
		assertEquals(CommandRef.RIGHT, CommandRef.getCommandRef("D"));
		assertEquals(CommandRef.STRAIGHT, CommandRef.getCommandRef("A"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCommandRefError() {
		CommandRef.getCommandRef("X");
	}

}
