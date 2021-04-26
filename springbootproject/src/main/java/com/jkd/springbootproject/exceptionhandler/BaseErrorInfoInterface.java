package com.jkd.springbootproject.exceptionhandler;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.exceptionhandler
 * @className: BaseErrorInfoInterface
 * @author: JKD
 * @description: 基础接口类，自定义的错误描述枚举类需要实现该接口
 * @version: 1.0
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     */
    String getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
