package com.yh.mower.inputs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yh.mower.models.command.impl.MoveCommand;
import com.yh.mower.models.command.impl.TurnLeftCommand;
import com.yh.mower.models.command.impl.TurnRightCommand;

public class InputLoaderTest {

	private InputLoader loader;

	@Test
	public void testLoadLawn() {
		loader = new InputLoader();
		loader.loadLawn("3 5  ");
		assertEquals(3, loader.getLawnInput().getxMax());
		assertEquals(5, loader.getLawnInput().getyMax());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoadLawnInputError() {
		loader = new InputLoader();
		loader.loadLawn("3 5 ..");
	}

	@Test(expected = IllegalStateException.class)
	public void testLoadLawnLoadError() {
		loader = new InputLoader();
		loader.loadLawn("3 5");
		loader.loadLawn("4 5");
	}

	@Test(expected = IllegalStateException.class)
	public void testLoadMowerAndCommandInitError() {
		loader = new InputLoader();
		loader.loadMowerAndCommand("2 2 N", "DGA");
	}

	@Test
	public void testLoadMowerAndCommand() {
		loader = new InputLoader();
		loader.loadLawn("5 5");
		loader.loadMowerAndCommand("2 4 N", "DGA");
		loader.loadMowerAndCommand("3 2 E", "AA");
		assertEquals(2, loader.getMowerInput().size());
		assertEquals(2, loader.getMowerInput().get(0).getMower().getPosition().getX());
		assertEquals(4, loader.getMowerInput().get(0).getMower().getPosition().getY());
		assertEquals("N", loader.getMowerInput().get(0).getMower().getPosition().getOrientation().getValue());
		assertEquals(3, loader.getMowerInput().get(0).getCommands().size());
		assertEquals(TurnRightCommand.class, loader.getMowerInput().get(0).getCommands().get(0).getClass());
		assertEquals(TurnLeftCommand.class, loader.getMowerInput().get(0).getCommands().get(1).getClass());
		assertEquals(MoveCommand.class, loader.getMowerInput().get(0).getCommands().get(2).getClass());
		assertEquals(3, loader.getMowerInput().get(1).getMower().getPosition().getX());
		assertEquals(2, loader.getMowerInput().get(1).getMower().getPosition().getY());
		assertEquals("E", loader.getMowerInput().get(1).getMower().getPosition().getOrientation().getValue());
		assertEquals(2, loader.getMowerInput().get(1).getCommands().size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoadMowerAndCommandMowerError() {
		loader = new InputLoader();
		loader.loadLawn("5 5");
		loader.loadMowerAndCommand("2 2 N>", "DGA");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoadMowerAndCommandCommandError() {
		loader = new InputLoader();
		loader.loadLawn("5 5");
		loader.loadMowerAndCommand("2 2 N", "DGAXX");
	}

}
