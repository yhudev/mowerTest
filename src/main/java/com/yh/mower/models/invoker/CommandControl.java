package com.yh.mower.models.invoker;

import java.util.List;

import com.yh.mower.models.command.Command;

/**
 * Command controller, the invoker class in command pattern
 * 
 * @author huyue
 *
 */
public class CommandControl {

    /**
     * Handle one command
     * 
     * @param command
     *            command
     */
    public void handle(Command command) {
        command.execute();
    }

    /**
     * Handle a list of commands
     * 
     * @param commands
     *            command list
     */
    public void handle(List<Command> commands) {
        for (Command command : commands) {
            command.execute();
        }
    }
}
