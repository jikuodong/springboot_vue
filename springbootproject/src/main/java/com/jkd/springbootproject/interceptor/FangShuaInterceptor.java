package com.jkd.springbootproject.interceptor;

import com.jkd.springbootproject.annotation.AccessLimit;
import com.jkd.springbootproject.utils.IpUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.interceptor
 * @className: FangShuaInterceptor
 * @author: JKD
 * @description: 防刷拦截器，API请求限流拦截器
 * @version: 1.0
 */
@Component
public class FangShuaInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            // 获取方法中的注解，看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean login = accessLimit.needLogin();
            // 根据 IP  + API限流
            String key = IpUtils.getIpAddr(request) + request.getRequestURI();
            // 根据key获取已请求次数
            Integer count = redisTemplate.opsForValue().get(key);
            // 如果需要登陆
            if (login) {
                // 获取登陆的session进行判断
                // .....
                // 这里假设用户是1，项目中是动态获取的Userid
            }
            if (count == null) {
                // 第一次访问
                redisTemplate.opsForValue().set(key, 1, seconds, TimeUnit.SECONDS);
            } else if (count < maxCount) {
                redisTemplate.opsForValue().set(key, maxCount+1, seconds, TimeUnit.SECONDS);
            } else {
                //超出访问次数
                //这里的CodeMsg是一个返回参数
                render(response,"超出访问次数");
                return false;
            }
        }

        return true;
    }
    private void render(HttpServletResponse response, String str) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        try {
            out.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.flush();
        out.close();

    }
}
