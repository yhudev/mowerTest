package com.yh.mower.enums;

/**
 * Command reference
 * 
 * @author huyue
 *
 */
public enum CommandRef {
    /**
     * Turn left command reference
     */
    LEFT("G"),
    /**
     * Turn right command reference
     */
    RIGHT("D"),
    /**
     * Move one step command reference
     */
    STRAIGHT("A");

    private final String value;

    private CommandRef(String value) {
        this.value = value;
    }

    /**
     * Get value
     * 
     * @return command value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get {@link CommandRef} value according to String value, throws
     * {@link IllegalArgumentException} for invalid values
     * 
     * @param str
     *            value
     * @return {@link CommandRef}
     */
    public static CommandRef getCommandRef(String str) {
        switch (str) {
        case "D":
            return CommandRef.RIGHT;
        case "G":
            return CommandRef.LEFT;
        case "A":
            return CommandRef.STRAIGHT;
        default:
            throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
        }
    }
}
