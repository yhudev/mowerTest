package com.yh.mower;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yh.mower.inputs.FileInputReaderTest;
import com.yh.mower.models.receiver.MowerPosition;

public class MainTest {
    private Main main;
    private List<String> input;
    private List<String> input_wrong;

    private static Logger LOG = Logger.getLogger(Main.class);
    private WriterAppender consoleResult;
    private Writer writer;

    @Before
    public void setUp() {
        main = new Main();
        input = new ArrayList<>();
        input.add("5 5");
        input.add("1 2 N");
        input.add("GAGAGAGAA");
        input.add("3 3 E");
        input.add("AADAADADDA");

        writer = new StringWriter();
        consoleResult = new WriterAppender(new PatternLayout("%m%n"), writer);
        consoleResult.setEncoding("UTF-8");
        consoleResult.setThreshold(Level.ALL);
        consoleResult.activateOptions();
        LOG.addAppender(consoleResult);
    }

    @After
    public void clean() {
        LOG.removeAppender(consoleResult);
        consoleResult.close();
    }

    @SuppressWarnings("static-access")
    @Test
    public void testMainDefault() {
        String[] args = new String[] {};
        main.main(args);
        assertEquals("1 3 N" + System.getProperty("line.separator") + "5 1 E" + System.getProperty("line.separator"),
                writer.toString());
    }

    @SuppressWarnings("static-access")
    @Test
    public void testMainInput() {
        String path = FileInputReaderTest.class.getResource("/test_main.txt").getFile();
        String[] args = new String[] { path };
        main.main(args);
        assertEquals("1 3 N" + System.getProperty("line.separator") + "5 1 E" + System.getProperty("line.separator")
                + "5 1 E" + System.getProperty("line.separator"), writer.toString());
    }

    @SuppressWarnings("static-access")
    @Test(expected = IllegalArgumentException.class)
    public void testMainInputError() {
        String[] args = new String[] { "/test_error1.txt", "/test_error2.txt" };
        main.main(args);
    }

    @Test
    public void testExcute() {
        List<MowerPosition> results = main.excute(input);
        assertEquals(2, results.size());
        assertEquals(1, results.get(0).getX());
        assertEquals(3, results.get(0).getY());
        assertEquals("N", results.get(0).getOrientation().getValue());
        assertEquals(5, results.get(1).getX());
        assertEquals(1, results.get(1).getY());
        assertEquals("E", results.get(1).getOrientation().getValue());
        assertEquals("1 3 N" + System.getProperty("line.separator") + "5 1 E" + System.getProperty("line.separator"),
                writer.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcuteNoLines() {
        input_wrong = new ArrayList<>();
        main.excute(input_wrong);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcuteWrongLines() {
        input_wrong = new ArrayList<>();
        input.add("5 5");
        input.add("1 2 N");
        input.add("AAA");
        input.add("1 2 N");
        main.excute(input_wrong);
    }

}
