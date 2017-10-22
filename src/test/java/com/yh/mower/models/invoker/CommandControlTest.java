package com.yh.mower.models.invoker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yh.mower.models.command.Command;
import com.yh.mower.models.command.impl.MoveCommand;
import com.yh.mower.models.command.impl.TurnLeftCommand;
import com.yh.mower.models.command.impl.TurnRightCommand;
import com.yh.mower.models.receiver.Mower;
import com.yh.mower.models.receiver.MowerPosition;

public class CommandControlTest {
	private CommandControl ctrl;
	private Mower mower_1;
	private Mower mower_2;
	private Command command;
	private List<Command> commands;

	@Before
	public void setUp() {
		ctrl = new CommandControl();
		commands = new ArrayList<>();
		mower_1 = new Mower(new MowerPosition(2, 2, "W", 5, 5));
		command = new MoveCommand(mower_1);
		mower_2 = new Mower(new MowerPosition(2, 3, "W", 5, 5));
		commands.add(new TurnLeftCommand(mower_2));
		commands.add(new MoveCommand(mower_2));
		commands.add(new TurnRightCommand(mower_2));
	}

	@Test
	public void testHandleCommand() {
		ctrl.handle(command);
		assertEquals(1, mower_1.getPosition().getX());
		assertEquals(2, mower_1.getPosition().getY());
		assertEquals("W", mower_1.getPosition().getOrientation().getValue());
	}

	@Test
	public void testHandleListOfCommand() {
		ctrl.handle(commands);
		assertEquals(2, mower_2.getPosition().getX());
		assertEquals(2, mower_2.getPosition().getY());
		assertEquals("W", mower_2.getPosition().getOrientation().getValue());
	}

}
