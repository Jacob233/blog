package templet;

/**
 * @author ji.xie
 * @Filename templet.templet.java
 * @description 调用执行接口
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2018/8/14 15:46</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public interface Callback<T,R> {

    /**
     * @Description 准备
     * @Params
     * @Return
     * @Exceptions
     */
    T prepare();

    /**
     * @Description 执行
     * @Params
     * @Return
     * @Exceptions
     */
    void execute(T t);

    /**
     * @Description 返回结果
     * @Params
     * @Return
     * @Exceptions
     */
     R result(T t);
}