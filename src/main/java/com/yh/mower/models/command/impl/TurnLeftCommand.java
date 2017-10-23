package com.yh.mower.models.command.impl;

import com.yh.mower.models.command.Command;
import com.yh.mower.models.receiver.Mower;

/**
 * Command that contains turn left order
 * 
 * @author huyue
 *
 */
public class TurnLeftCommand implements Command {
    private Mower mower;

    /**
     * Constructor {@link TurnLeftCommand}
     * 
     * @param mower
     *            binded mower
     */
    public TurnLeftCommand(Mower mower) {
        super();
        this.mower = mower;
    }

    @Override
    public void execute() {
        this.mower.turnLeft();
    }

}
