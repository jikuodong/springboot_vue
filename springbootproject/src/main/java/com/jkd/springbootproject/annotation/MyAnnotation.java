package com.jkd.springbootproject.annotation;

import java.lang.annotation.*;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.annotation
 * @className: MyAnnotation
 * @author: JKD
 * @description: 自定义注解 （用于实现AOP添加日志）
 * @version: 1.0
 */
@Target(ElementType.METHOD) //  @Target中的ElementType用来指定Annotation类型可以用在哪些元素上
@Retention(RetentionPolicy.RUNTIME) // 在源码、编译好的.class文件中保留信息，在执行的时候会把这一些信息加载到JVM中去的
@Documented // 让这个Annotation类型的信息能够显示在API说明文档上；没有添加的话，使用javadoc生成的API文件找不到这个类型生成的信息
public @interface MyAnnotation {
    String userId() default "";
    String orderId() default "";
}
