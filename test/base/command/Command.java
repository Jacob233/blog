package command;

/**
 * @author ji.xie
 * @Filename command.Command.java
 * @description
 * @Version 1.0
 * @History <br/>
 * <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:13</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public interface Command {

    /**
     * @Description 执行指令
     * @Params void
     * @Return boolean
     * @Exceptions
     */
    boolean execute();
}