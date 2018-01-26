package base.exception_test;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author ji.xie
 * @Filename TryCatchTest.java
 * @description
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/11/9 10:21</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class TryCatchTest {

    private Logger logger=Logger.getLogger("TryCatchTest");

    @Test
    public void test(){
        try {
            throw new RuntimeException("test");
        }catch (Exception e){
            logger.warning("try catch fetch the "+e);
        }
    }
}