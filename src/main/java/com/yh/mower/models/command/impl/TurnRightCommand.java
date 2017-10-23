package com.yh.mower.models.command.impl;

import com.yh.mower.models.command.Command;
import com.yh.mower.models.receiver.Mower;

/**
 * Command that contains turn right order
 * 
 * @author huyue
 *
 */
public class TurnRightCommand implements Command {

    private Mower mower;

    /**
     * Constructor {@link TurnRightCommand}
     * 
     * @param mower
     *            binded mower
     */
    public TurnRightCommand(Mower mower) {
        super();
        this.mower = mower;
    }

    @Override
    public void execute() {
        this.mower.turnRight();
    }

}
