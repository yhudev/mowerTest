package com.yh.mower.models.factory;

import com.yh.mower.enums.CommandRef;
import com.yh.mower.models.command.Command;
import com.yh.mower.models.command.impl.MoveCommand;
import com.yh.mower.models.command.impl.TurnLeftCommand;
import com.yh.mower.models.command.impl.TurnRightCommand;
import com.yh.mower.models.receiver.Mower;

/**
 * Command factory that generate different commands according to input
 * 
 * @author huyue
 *
 */
public class CommandFactory {

	/**
	 * Get command according to the {@link CommandRef} type
	 * 
	 * @param cmd
	 * @param mower
	 * @return {@link Command}
	 */
	public Command getCommand(CommandRef cmd, Mower mower) {
		switch (cmd) {
		case RIGHT:
			return new TurnRightCommand(mower);
		case LEFT:
			return new TurnLeftCommand(mower);
		case STRAIGHT:
			return new MoveCommand(mower);
		default:
			return null;
		}
	}

}
