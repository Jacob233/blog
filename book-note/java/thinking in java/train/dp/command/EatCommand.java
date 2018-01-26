package dp.command;

/**
 * @author ji.xie
 * @Filename EatCommand.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/1/25 18:18</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class EatCommand implements Command{
    @Override
    public void excute() {
        System.out.println("eating");
    }
}