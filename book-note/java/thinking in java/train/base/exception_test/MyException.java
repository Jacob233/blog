package base.exception_test;

/**
 * @author ji.xie
 * @Filename MyException.java
 * @description 自定义异常
 * @Version 1.0
 * @History <li>Author: ji.xie</li>
 * <li>Date: 2017/9/12 13:52</li>
 * <li>Version: 1.0</li>
 * <li>Content: create</li>
 */
public class MyException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

}