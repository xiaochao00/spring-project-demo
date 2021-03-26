package org.example.shch.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib proxy utils
 *
 * @author shichao
 * @since 1.0.0
 * 2021/3/27 0:10
 */
public class CglibProxyUtils {
    static class CGLibProxy implements MethodInterceptor {
        private static final Logger logger = LoggerFactory.getLogger(CGLibProxy.class);

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            logger.info("Before intercept method:{} for class:{}.", method.getName(), o.getClass());
            Object obj = methodProxy.invokeSuper(o, objects);
            logger.info("After intercept method:{} for class:{}.", method.getName(), o.getClass());
            return obj;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxyInstance(T t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(new CGLibProxy());
        return (T) enhancer.create();
    }
}
