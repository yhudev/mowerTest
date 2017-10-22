package com.yh.mower.models.command;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yh.mower.models.command.impl.TurnLeftCommand;
import com.yh.mower.models.receiver.Mower;
import com.yh.mower.models.receiver.MowerPosition;

public class TurnLeftCommandTest {
	private TurnLeftCommand command;
	private Mower mower;

	@Before
	public void setUp() {
		mower = new Mower(new MowerPosition(2, 3, "S", 5, 5));
		command = new TurnLeftCommand(mower);
	}

	@Test
	public void testExecute() {
		command.execute();
		assertEquals(2, mower.getPosition().getX());
		assertEquals(3, mower.getPosition().getY());
		assertEquals("E", mower.getPosition().getOrientation().getValue());
	}

}
