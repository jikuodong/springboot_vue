package com.jkd.springbootproject.annotation;

import java.lang.annotation.*;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.annotation
 * @className: AccessLimit
 * @author: JKD
 * @description: 访问限制注解类 Interceptor
 * @version: 1.0
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {
    // 请求次数的执行时间范围 秒数（Redis数据过期时间）
    int seconds();
    // 指定second时间内 API请求次数
    int maxCount();
    boolean needLogin() default true;
}
