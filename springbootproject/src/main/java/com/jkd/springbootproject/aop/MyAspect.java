package com.jkd.springbootproject.aop;

import com.jkd.springbootproject.annotation.MyAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @projectName: springbootproject
 * @package: com.jkd.springbootproject.aop
 * @className: MyAspect
 * @author: JKD
 * @description: 以 MyAspect为切入点，记录用户的订单信息
 * @version: 1.0
 */

@Aspect // 把当前类标识为一个切面
@Component
public class MyAspect {

    /**
     *
     *  @Around(value = "@annotation(snLog) && args(object,..)", argNames = "pjp,snLog,object")
     *
     *  @annotation():表示标注了指定注解的目标类方法
     *  例如 @annotation(org.springframework.transaction.annotation.Transactional) 表示标注了@Transactional的方法
     * args(): 通过目标类方法的参数类型指定切点
     * 例如 args(String) 表示有且仅有一个String型参数的方法
     *
     * @args()
     * 通过目标类参数的对象类型是否标注了指定注解指定切点
     * 如 @args(org.springframework.stereotype.Service) 表示有且仅有一个标注了@Service的类参数的方法
     *
     */
    @Around(value = "@annotation(myAnnotation)")
    public Object around(ProceedingJoinPoint pjp, MyAnnotation myAnnotation) throws Throwable {
        System.out.println("进入日志切面类");
        Object result = pjp.proceed();
        System.out.println(result);
        // 获取形参数组
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        // 目标方法的参数名称
        String[] parameterNames = discoverer.getParameterNames(method);
        // 目标方法的参数值
        Object[] args = pjp.getArgs();
        System.out.println(args);
        return  result;
    }
}
