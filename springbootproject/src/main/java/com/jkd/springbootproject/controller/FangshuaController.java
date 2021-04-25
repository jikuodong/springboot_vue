package com.jkd.springbootproject.controller;

import com.jkd.springbootproject.annotation.AccessLimit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.controller
 * @className: FangshuaController
 * @author: JKD
 * @description:
 * @version: 1.0
 */

@Controller
public class FangshuaController {


    @AccessLimit(seconds=5, maxCount=5, needLogin=true)
    @RequestMapping("/fangshua")
    @ResponseBody
    public String fangshua() {
        return "请求成功";
    }
}
