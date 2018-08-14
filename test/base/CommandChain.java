import command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename CommandChain.java
 * @description 自定义指令链练习
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:07</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class CommandChain {

    /**
     * 指令集
     */
    private List<Command> commandChain = new ArrayList<Command>();

    /**
     * 添加指令
     */
    public void addCommand(Command command) {
        commandChain.add(command);
    }

    /**
     * 执行指令集
     */
    public void execute() {
        for (Command command : commandChain) {
            //break due to any one return false
            if (!command.execute()) {
                break;
            }
        }
    }
}