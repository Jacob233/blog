package dp.command;

/**
 * @author ji.xie
 * @Filename SimpleAction.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 18:34</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class SimpleCommandChain extends CommandChain {

    private EatCommand eatCommand=new EatCommand();
    private SleepCommand sleepCommand=new SleepCommand();

    public  SimpleCommandChain(){
        addCommand(eatCommand);
        addCommand(sleepCommand);
    }

    public  SimpleCommandChain(EatCommand eatCommand,SleepCommand sleepCommand){
        addCommand(eatCommand);
        addCommand(sleepCommand);
    }
}