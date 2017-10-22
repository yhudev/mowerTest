package com.yh.mower.inputs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yh.mower.enums.ErrorMsg;

/**
 * Read input file
 * 
 * @author huyue
 *
 */
public class FileInputReader {
	private String filename;
	private List<String> lines;

	public FileInputReader(String filename) {
		super();
		this.lines = new ArrayList<>();
		this.filename = filename;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @return the lines
	 */
	public List<String> getLines() {
		return lines;
	}

	/**
	 * Read file into lines
	 */
	public void parse() {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
		}
	}
}
