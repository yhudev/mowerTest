package com.yh.mower.enums;

/**
 * Orientation reference
 * 
 * @author huyue
 *
 */
public enum Orientation {
    /**
     * North
     */
    NORTH("N"),
    /**
     * South
     */
    SOUTH("S"),
    /**
     * East
     */
    EAST("E"),
    /**
     * West
     */
    WEST("W");

    private final String value;

    private Orientation(String value) {
        this.value = value;
    }

    /**
     * Get value
     * 
     * @return String value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get next orientation in clockwise order
     * 
     * @return {@link Orientation}
     */
    public Orientation getNext() {
        switch (value) {
        case "N":
            return Orientation.EAST;
        case "S":
            return Orientation.WEST;
        case "E":
            return Orientation.SOUTH;
        case "W":
            return Orientation.NORTH;
        default:
            return this;
        }
    }

    /**
     * Get previous orientation in clockwise order
     * 
     * @return {@link Orientation}
     */
    public Orientation getPrev() {
        switch (value) {
        case "N":
            return Orientation.WEST;
        case "S":
            return Orientation.EAST;
        case "E":
            return Orientation.NORTH;
        case "W":
            return Orientation.SOUTH;
        default:
            return this;
        }
    }

    /**
     * Get {@link Orientation} value according to String value, throws
     * {@link IllegalArgumentException} for invalid values
     * 
     * @param str
     *            orientation value
     * @return {@link Orientation}
     */
    public static Orientation getOrientation(String str) {
        switch (str) {
        case "N":
            return Orientation.NORTH;
        case "S":
            return Orientation.SOUTH;
        case "E":
            return Orientation.EAST;
        case "W":
            return Orientation.WEST;
        default:
            throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
        }
    }

}
