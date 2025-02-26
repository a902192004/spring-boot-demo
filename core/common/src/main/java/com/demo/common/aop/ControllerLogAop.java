package com.demo.common.aop;

import com.demo.common.utils.CommonUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class ControllerLogAop {

    private static final String NO_PARAM = "none";
    private static final String FILE = "FILE";
    private static final String NO_SUPPORT = "no support method!!!";

    private static final String ALL_CONTROLLER_PATH = "execution (public * com.demo.*.controller..*.*(..))";

//        private static final String ALL_CONTROLLER_PATH = "execution (public * com.demo.auth.controller..*(..))";

    @Pointcut(ALL_CONTROLLER_PATH)
    public void allControllerLayer() {
    }

    @Around(value = "allControllerLayer()")
    public Object doAroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("234s");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        HttpServletRequest request = getHttpServletRequest();
        if (request == null) {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw throwable;
            }
        }

        String method = request.getMethod();
        String uri = request.getRequestURI();

        Object result = null;
        Instant startime = Instant.now();
        String paramStr = getParams(joinPoint, method);
        log.info("{}-請求-uri：{}，類別名：{}，方法名：{}，參數：{}", method, uri, className, methodName, paramStr);

        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("請求失敗-uri：{}，類別名：{}，方法名：{}，錯誤：{}", uri, className, methodName, throwable.getMessage());
            throw throwable;
        }

        long costTime = Duration.between(startime, Instant.now()).toMillis();
        if (costTime < 1000) {
            log.info("請求成功-uri：{}，類別名：{}，方法名：{}，耗時：{}，result:{}", uri, className, methodName, costTime, result);
        } else {
            log.warn("請求成功-uri：{}，類別名：{}，方法名：{}，耗時：{}，result:{}", uri, className, methodName, costTime, result);
        }

        return result;
    }

    private HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }
        return attributes.getRequest();
    }

    private String getParams(ProceedingJoinPoint joinPoint, String method) {
        if ("get".equalsIgnoreCase(method)) {
            return getParamsByGet(joinPoint);
        } else if ("post".equalsIgnoreCase(method)) {
            return getParamsByPost(joinPoint);
        } else {
            return NO_SUPPORT;
        }
    }

    private String getParamsByGet(ProceedingJoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String[] names = ms.getParameterNames();

        Object[] values = joinPoint.getArgs();
        if (names == null || names.length == 0) {
            return NO_PARAM;
        }

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String key = names[i];
            if (values[i] instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) values[i];
                map.putAll(CommonUtil.paramsMap(request));
            } else if (values[i] != null) {
                map.put(key, values[i].toString());
            }
        }
        return paramFormat(map);
    }

    private String getParamsByPost(ProceedingJoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String[] names = ms.getParameterNames();

        Object[] values = joinPoint.getArgs();
        if (values == null || values.length == 0) {
            return NO_PARAM;
        }

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof MultipartFile) {
                map.put(FILE, ((MultipartFile) values[i]).getOriginalFilename());
            } else if (values[i] instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) values[i];
                map.putAll(CommonUtil.paramsMap(request));
            } else if (values[i] != null) {
                map.put(names[i], values[i].toString());
            }
        }
        return paramFormat(map);
    }

    private String paramFormat(Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        map.forEach((key, value) -> {
            if (StringUtils.hasLength(key)) {
                sb.append("[").append(key).append(" = ").append(value).append("]");
            }
        });
        return map.isEmpty() ? NO_PARAM : sb.toString();
    }
}
