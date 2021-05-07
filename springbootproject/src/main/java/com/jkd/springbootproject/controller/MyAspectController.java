package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.annotation.MyAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.controller
 * @className: MyAspectController
 * @author: JKD
 * @description: 测试AOP
 * @version: 1.0
 */
@RestController
@RequestMapping("/aspect")
public class MyAspectController {

    @MyAnnotation(userId = "123456", orderId = "654321")
    @RequestMapping("myAspectTest")
    public String myAspectTest(String userId,String orderId) {
        return "成功";
    }
}
