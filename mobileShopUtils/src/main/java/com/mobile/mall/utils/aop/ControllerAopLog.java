package com.mobile.mall.utils.aop;

import com.mobile.mall.utils.dto.request.BaseResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class ControllerAopLog {
    @Pointcut("execution(public * com.mobile.mall.*.controller..*.*(..))")
    public void controllerLog(){}

   /* @Around("controllerLog()")
    public void beforecontrollerLogDetail(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Signature signature = joinPoint.getSignature();
        StringBuffer logSub = new StringBuffer("");
        ApiOperation annotation = ((MethodSignature) signature).getMethod().getAnnotation(ApiOperation.class);
        logSub.append(annotation == null ? "":annotation.value()).append("\t")
                .append("请求信息：URL={").append(request.getRequestURI()).append("},\t")
                .append("请求方法：{").append(request.getMethod()).append("},\t")
                .append("请求ip：{").append(request.getRemoteAddr()).append("},\t")
                .append("调用方法：{").append(signature.getDeclaringTypeName()).append(".").append(signature.getName()).append("},\t");
        //方法参数
        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        Object[] args = joinPoint.getArgs();
        if(parameterNames == null || parameterNames.length == 0){
            logSub.append("请求参数 = {} ");
        }else{
            logSub.append("请求参数 = {");
            for(int i = 0; i < parameterNames.length - 1; i++){
                logSub.append(parameterNames[i]).append("=").append(args[i]).append(",");
            }
            logSub.append(parameterNames[parameterNames.length - 1]).append("=").append(args[args.length - 1]);
        }
        log.info(logSub.toString());
    }*/

    @Before("controllerLog()")
    public void beforeController(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Signature signature = joinPoint.getSignature();
        StringBuffer logSub = new StringBuffer("");
        ApiOperation annotation = ((MethodSignature) signature).getMethod().getAnnotation(ApiOperation.class);
        logSub.append(annotation == null ? "":annotation.value()).append("\t")
                .append("请求信息：URL={").append(request.getRequestURI()).append("},\t")
                .append("请求方法：{").append(request.getMethod()).append("},\t")
                .append("请求ip：{").append(request.getRemoteAddr()).append("},\t")
                .append("调用方法：{").append(signature.getDeclaringTypeName()).append(".").append(signature.getName()).append("},\t");
        //方法参数
        String[] parameterNames = ((MethodSignature) signature).getParameterNames();
        Object[] args = joinPoint.getArgs();
        if(parameterNames == null || parameterNames.length == 0){
            logSub.append("请求参数 = {} ");
        }else{
            logSub.append("请求参数 = {");
            for(int i = 0; i < parameterNames.length - 1; i++){
                logSub.append(parameterNames[i]).append("=").append(args[i]).append(",");
            }
            logSub.append(parameterNames[parameterNames.length - 1]).append("=").append(args[args.length - 1]);
        }
        log.info(logSub.toString());
    }

    @AfterReturning(returning = "baseResponse", pointcut = "controllerLog()")
    public void controllerAfterReturn(BaseResponse baseResponse){
        log.info("请求结果：" + baseResponse.getErrno() + "\t" + baseResponse.getErrmsg());
    }
}
