package com.feng.analysis.app.conf;

import com.feng.analysis.conf.LogProperty;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect
@Component
public class ControllerInvokeInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ControllerInvokeInterceptor.class);

    /**
     * 定义拦截规则：拦截com.dianrong.starrysept.app.controller包下面的所有类中，有@RequestMapping注解的方法。
     */
    @Pointcut("execution(* com.dianrong.starrysept.app.controller..*(..)) and @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @param pjp
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.dianrong.........)”写进这里
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        String opName;//操作名称
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法

        LogProperty logArg = null;//业务请求参数
        String businessId = null;//打印的业务ID

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            if (arg instanceof LogProperty) {
                logArg = ((LogProperty) arg);
                businessId = logArg.businessKey();
                break;
            }
        }
        if (businessId != null) {
            //覆盖
            MDC.put(LogProperty.BUSINESS_ID, businessId);
        }
        ApiOperation apiOperation = method.getAnnotation(ApiOperation.class);
        if (apiOperation != null) {
            opName = apiOperation.value();
            int index = opName.indexOf("，");
            if (index < 0) {
                index = opName.indexOf(",");
            }
            if (index > -1) {
                opName = opName.substring(0, index);
            }
        } else {
            opName = method.getName();
        }
        if (logArg == null) {
            logger.info("{}请求", opName);
        } else {
            logger.info("{}请求入参:{}", opName, logArg);
        }
        long beginTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        logger.info("{}请求出参:{},耗时:{}", opName, result, (System.currentTimeMillis() - beginTime));
        return result;
    }

}