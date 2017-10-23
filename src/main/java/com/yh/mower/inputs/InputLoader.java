package com.yh.mower.inputs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yh.mower.enums.CommandRef;
import com.yh.mower.enums.ErrorMsg;
import com.yh.mower.models.command.Command;
import com.yh.mower.models.factory.CommandFactory;
import com.yh.mower.models.receiver.Mower;
import com.yh.mower.models.utils.Lawn;
import com.yh.mower.models.utils.MowerExecuteInfo;

/**
 * Load inputs for lawn and mower initial status
 * 
 * @author huyue
 *
 */
public class InputLoader {
    private static final String REGEX_COMMAND = "^\\s*[DGA]+\\s*$";
    private static final String REGEX_LAWN = "^\\s*(\\d+)\\s+(\\d+)\\s*$";
    private static final String REGEX_MOWER = "^\\s*(\\d+)\\s+(\\d+)\\s+([NSEW])\\s*$";

    private CommandFactory commandFactory;
    private Lawn lawnInput;
    private List<MowerExecuteInfo> mowerInput;

    /**
     * Constructor {@link InputLoader}
     */
    public InputLoader() {
        mowerInput = new ArrayList<>();
        commandFactory = new CommandFactory();
    }

    /**
     * @return the lawnInput
     */
    public Lawn getLawnInput() {
        return lawnInput;
    }

    /**
     * @return the mowerInput
     */
    public List<MowerExecuteInfo> getMowerInput() {
        return mowerInput;
    }

    /**
     * Load lawn information
     * 
     * @param str
     *            lawn information
     */
    public void loadLawn(String str) {
        Pattern pattern = Pattern.compile(REGEX_LAWN);
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            if (lawnInput == null)
                lawnInput = new Lawn(x, y);
            else {
                throw new IllegalStateException(ErrorMsg.LAWN_ALREADY_SET_ERROR.getValue());
            }
        } else {
            throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
        }
    }

    /**
     * Load mower and commands information, lawn information should be loaded
     * before this call
     * 
     * @param str1
     *            mower information
     * @param str2
     *            commands information
     */
    public void loadMowerAndCommand(String str1, String str2) {
        if (lawnInput == null)
            throw new IllegalStateException(ErrorMsg.LAWN_NOT_LOAD_ERROR.getValue());

        Pattern patternMower = Pattern.compile(REGEX_MOWER);
        Matcher matcherMower = patternMower.matcher(str1);
        Pattern patternCommand = Pattern.compile(REGEX_COMMAND);
        Matcher matcherCommand = patternCommand.matcher(str2);

        if (matcherMower.find() && matcherCommand.find()) {
            int x = Integer.parseInt(matcherMower.group(1));
            int y = Integer.parseInt(matcherMower.group(2));
            String o = matcherMower.group(3);
            Mower mower = new Mower(x, y, o, lawnInput.getxMax(), lawnInput.getyMax());
            List<Command> commands = new ArrayList<>();

            for (String s : str2.split("")) {
                commands.add(commandFactory.getCommand(CommandRef.getCommandRef(s), mower));
            }
            mowerInput.add(new MowerExecuteInfo(mower, commands));
        } else {
            throw new IllegalArgumentException(ErrorMsg.FORMAT_ERROR.getValue());
        }
    }

}
