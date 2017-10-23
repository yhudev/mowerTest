package com.yh.mower.inputs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FileInputReaderTest {

    private FileInputReader reader;

    @Before
    public void setUp() {
        String path = FileInputReaderTest.class.getResource("/test.txt").getFile();
        reader = new FileInputReader(path);
    }

    @Test
    public void testParse() {
        reader.parse();
        assertEquals(5, reader.getLines().size());
        assertEquals("5 5", reader.getLines().get(0));
        assertEquals("1 2 N", reader.getLines().get(1));
        assertEquals("GAGAGAGAA", reader.getLines().get(2));
        assertEquals("3 3 E", reader.getLines().get(3));
        assertEquals("AADAADADDA", reader.getLines().get(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseError() {
        FileInputReader r = new FileInputReader("test_error.txt");
        r.parse();
    }

}
