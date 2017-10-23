package com.yh.mower.models.utils;

import java.util.List;

import com.yh.mower.models.command.Command;
import com.yh.mower.models.receiver.Mower;

/**
 * Mower information needed during execution
 * 
 * @author huyue
 *
 */
public class MowerExecuteInfo {
    private Mower mower;
    private List<Command> commands;

    /**
     * Constructor {@link MowerExecuteInfo}
     * 
     * @param mower
     *            binded mower
     * @param commands
     *            list of commands to be executed
     */
    public MowerExecuteInfo(Mower mower, List<Command> commands) {
        super();
        this.mower = mower;
        this.commands = commands;
    }

    /**
     * @return the mower
     */
    public Mower getMower() {
        return mower;
    }

    /**
     * @param mower
     *            the mower to set
     */
    public void setMower(Mower mower) {
        this.mower = mower;
    }

    /**
     * @return the commands
     */
    public List<Command> getCommands() {
        return commands;
    }

    /**
     * @param commands
     *            the commands to set
     */
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

}
