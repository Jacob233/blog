import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author ji.xie
 * @Filename JodaTimeParse.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/12/4 15:29</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class JodaTimeParseTest {
    @Test
    public void Test(){
        System.out.println(new DateTime("2017-11-28T00:00:00Z"));
    }
}