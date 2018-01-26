package dp.command;

/**
 * @author ji.xie
 * @Filename SleepCommand.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 18:20</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class SleepCommand implements Command {
    @Override
    public void excute() {
        System.out.println("sleeping");
    }
}