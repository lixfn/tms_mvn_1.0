package com.fly.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;


public class SpringUtil {
    private static Logger logger = LoggerFactory.getLogger(SpringUtil.class);

    private static SpringUtil instance = null;
    private ApplicationContext context = null;
    private BeanFactory factory = null;

    protected SpringUtil() {
        super();
    }

    public static SpringUtil getInstance() {
        if (instance == null) {
            instance = new SpringUtil();
        }
        return instance;
    }

    public BeanFactory getFactory() throws Exception {
        if (factory == null && context == null) {
            throw new Exception("Uninitialized spring factory.");
        }
        if (factory != null) {
            return factory;
        }

        return context;
    }

    public void setFactory(BeanFactory factory) {
        this.factory = factory;
    }


    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }

    public <T> T getBean(String beanName) {
        try {
            BeanFactory factory = this.getFactory();
            if (factory != null) {
                return (T) factory.getBean(beanName);
            }
        } catch (Exception e) {
            logger.error("SpringUtil.getBean(" + beanName + ")", e);
        }
        return null;
    }

    public <T> T getBean(Class<T> tClass, String beanName) {
        return (T) getBean(beanName);
    }
}
