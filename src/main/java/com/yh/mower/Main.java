package com.yh.mower;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yh.mower.enums.ErrorMsg;
import com.yh.mower.inputs.FileInputReader;
import com.yh.mower.inputs.InputLoader;
import com.yh.mower.models.invoker.CommandControl;
import com.yh.mower.models.receiver.MowerPosition;
import com.yh.mower.models.utils.MowerExecuteInfo;

/**
 * Mower main entry
 * 
 * @author huyue
 *
 */
public class Main {
	private static Logger LOG = LoggerFactory.getLogger(Main.class);

	private static final String DEFAULT_FILE = "input.txt";

	/**
	 * Main entry, allow one parameter which is the input file path
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String file = Main.class.getResource(System.getProperty("file.separator") + DEFAULT_FILE).getFile();
		if (args.length == 1)
			file = args[0];
		FileInputReader reader = new FileInputReader(file);
		reader.parse();

		final Main app = new Main();
		app.excute(reader.getLines());
	}

	/**
	 * Execute entry
	 * 
	 * @param input
	 * @return {@link List}
	 */
	public List<MowerPosition> excute(List<String> input) {
		if (input.size() < 3 || input.size() % 2 != 1) {
			throw new IllegalArgumentException(ErrorMsg.INPUT_LINE_NUM_ERROR.getValue());
		}
		InputLoader loader = new InputLoader();
		List<MowerPosition> results = new ArrayList<>();
		loader.loadLawn(input.get(0));
		for (int i = 1; i < input.size(); i = i + 2) {
			loader.loadMowerAndCommand(input.get(i), input.get(i + 1));
		}
		CommandControl ctrl = new CommandControl();
		for (MowerExecuteInfo mower : loader.getMowerInput()) {
			ctrl.handle(mower.getCommands());
			results.add(mower.getMower().getPosition());
			// Output to console
			LOG.info(mower.getMower().getPosition().toString());
		}
		return results;
	}
}
