import command.BreakfastCommand;
import command.Command;
import command.WashCommand;

/**
 * @author ji.xie
 * @Filename MorningComandChain.java
 * @description 清楚执行指令链
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:19</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class MorningComandChain extends CommandChain {

    public MorningComandChain() {
        WashCommand washCommand = new WashCommand();
        BreakfastCommand breakfastCommand = new BreakfastCommand();
        this.addCommandChain(washCommand, breakfastCommand);
    }

    private void addCommandChain(WashCommand washCommand, BreakfastCommand breakfastCommand) {
        addCommand(washCommand);
        addCommand(breakfastCommand);
    }
}