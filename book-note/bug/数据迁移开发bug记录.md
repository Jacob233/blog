`bug回顾：`

1.反射时获取其属性值也要考虑是否获取其父类的反射属性
2.在同个函数中，断点无法顺序执行：
- a.编译文件与源文件不同步  
- b.抛了异常，日志没打出

**解决方案：降低日志、用debug的evaluate查看报错情况**

3.hql日志打印的代码能执行，在实际代码中无法执行：
- a.编码格式问题   
- b.环境问题 * 
- c.事务管理（可能是出现了线程争渡的情况）

**解决方案：先检查代码，无误换纯净环境执行，再不行考虑a、c情况**

4.@transactional事务失效：
- a.函数需是publc  
- b.spring会对unchecked的事务发生回滚 
- c.抛了异常

5.spring data jpa中使用可变参数函数，最好自己使用entityManager实现，@方式不支持，需要指定
6.entityManager最好托管在ELB容器中，自动去执行开启关闭

`参考文章：`

[3的解决参考]:https://segmentfault.com/q/1010000008998030
[异常解决参考]:https://www.ibm.com/developerworks/cn/java/j-lo-exception-misdirection/
[4的解决参考a]:http://ask.csdn.net/questions/178819
[4的解决参考b]:http://www.cnblogs.com/wuxiaofeng/p/6819209.html
[TransactionRequiredException]:https://samebug.io/exceptions/99155/javax.persistence.TransactionRequiredException/executing-an-updatedelete-query?soft=false



