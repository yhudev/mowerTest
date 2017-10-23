package com.yh.mower.enums;

/**
 * Error message reference
 * 
 * @author huyue
 *
 */
public enum ErrorMsg {
    /**
     * Read file error
     */
    FILE_LOAD_ERROR("Read file error."),
    /**
     * Wrong format error
     */
    FORMAT_ERROR("Input format error."),
    /**
     * Input format error
     */
    INPUT_LINE_NUM_ERROR("Input total number is not valid."),
    /**
     * Wrong parameter error
     */
    INPUT_PARAM_ERROR("Input parameter error."),
    /**
     * Lawn info reload error
     */
    LAWN_ALREADY_SET_ERROR("Lawn info has already set, this info can be set only once."),
    /**
     * Lawn info not loaded error
     */
    LAWN_NOT_LOAD_ERROR("Lawn info should be loaded first.");

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
