package com.yh.mower.models.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.yh.mower.enums.CommandRef;
import com.yh.mower.models.command.impl.MoveCommand;
import com.yh.mower.models.command.impl.TurnLeftCommand;
import com.yh.mower.models.command.impl.TurnRightCommand;
import com.yh.mower.models.receiver.Mower;
import com.yh.mower.models.receiver.MowerPosition;

public class CommandFactoryTest {
	private CommandFactory factory;
	private Mower mower;

	@Before
	public void setUp() {
		factory = new CommandFactory();
		mower = new Mower(new MowerPosition(2, 3, "E", 5, 5));
	}

	@Test
	public void testGetCommand() {
		assertEquals(MoveCommand.class, factory.getCommand(CommandRef.STRAIGHT, mower).getClass());
		assertEquals(TurnLeftCommand.class, factory.getCommand(CommandRef.LEFT, mower).getClass());
		assertEquals(TurnRightCommand.class, factory.getCommand(CommandRef.RIGHT, mower).getClass());
	}

}
