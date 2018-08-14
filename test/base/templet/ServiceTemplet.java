package templet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ji.xie
 * @Filename ServiceTemplet.java
 * @description 服务通用模板
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:52</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class ServiceTemplet {

    private Logger logger = Logger.getLogger("ServiceTemplet");

    public <T> String execute(Callback<T, String> action) {
        String result = null;
        T t = null;
        try {
            t = action.prepare();
            action.execute(t);
            result = action.result(t);
        } catch (Throwable throwable) {
            logger.log(Level.WARNING, throwable.getMessage());
        }
        return result;
    }

}