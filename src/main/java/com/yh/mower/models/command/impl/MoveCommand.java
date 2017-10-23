package com.yh.mower.models.command.impl;

import com.yh.mower.models.command.Command;
import com.yh.mower.models.receiver.Mower;

/**
 * Command that contains move on order
 * 
 * @author huyue
 *
 */
public class MoveCommand implements Command {
    private Mower mower;

    /**
     * Constructor {@link MoveCommand}
     * 
     * @param mower
     *            binded mower
     */
    public MoveCommand(Mower mower) {
        super();
        this.mower = mower;
    }

    @Override
    public void execute() {
        this.mower.move();
    }

}
