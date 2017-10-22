package com.yh.mower.enums;

/**
 * Command reference enum
 * 
 * @author huyue
 *
 */
public enum CommandRef {
	RIGHT("D"), LEFT("G"), STRAIGHT("A");

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
	 * Get {@link CommandRef} value according to String value
	 * 
	 * @param str
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
