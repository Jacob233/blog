package command;

/**
 * @author ji.xie
 * @Filename command.WashCommand.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:21</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class WashCommand implements Command {
    @Override
    public boolean execute() {
        System.out.println("wash face");
        return true;
    }
}