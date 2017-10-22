package com.yh.mower.enums;

/**
 * Error message
 * 
 * @author huyue
 *
 */
public enum ErrorMsg {
	FORMAT_ERROR("Input format error."), FILE_LOAD_ERROR("Read file error."), INPUT_LINE_NUM_ERROR(
			"Input total number is not valid."), LAWN_NOT_LOAD_ERROR(
					"Lawn info should be loaded first."), LAWN_ALREADY_SET_ERROR(
							"Lawn info has already set, this info can be set only once.");

	private final String value;

	private ErrorMsg(String value) {
		this.value = value;
	}

	/**
	 * Get error message
	 * 
	 * @return String value
	 */
	public String getValue() {
		return value;
	}
}
