package dp.command;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ji.xie
 * @Filename CommandFactory.java
 * @description
 * @Version 1.0
 * @History <br/>
 * <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 18:22</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public abstract class CommandChain {

    /**
     * 指令集合
     */
    private List<Command> commands = new ArrayList<>();

    /**
     * 添加指令
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * 遍历指令
     */
    public void execute() {
        commands.forEach(command -> {
            command.excute();
        });
    }

}