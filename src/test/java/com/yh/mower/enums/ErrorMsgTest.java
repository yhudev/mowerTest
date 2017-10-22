package com.yh.mower.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ErrorMsgTest {

	@Test
	public void testGetValue() {
		assertEquals("Input format error.", ErrorMsg.FORMAT_ERROR.getValue());
		assertEquals("Read file error.", ErrorMsg.FILE_LOAD_ERROR.getValue());
		assertEquals("Input total number is not valid.", ErrorMsg.INPUT_LINE_NUM_ERROR.getValue());
		assertEquals("Lawn info should be loaded first.", ErrorMsg.LAWN_NOT_LOAD_ERROR.getValue());
		assertEquals("Lawn info has already set, this info can be set only once.",
				ErrorMsg.LAWN_ALREADY_SET_ERROR.getValue());
	}

}
