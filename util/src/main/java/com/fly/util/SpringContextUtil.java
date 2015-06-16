package com.fly.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        SpringUtil.getInstance().setApplicationContext(context);
    }
}
