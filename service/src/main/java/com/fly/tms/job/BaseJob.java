package com.fly.tms.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

/**
 * Created by lixfn on 15-3-10.
 */
public abstract class BaseJob implements Job {

    protected ApplicationContext getApplicationContext(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
        ApplicationContext appCtx = null;
        try {
            appCtx = (ApplicationContext) jobexecutioncontext.getScheduler().getContext().get("applicationContextKey");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        if (appCtx == null) {
            throw new JobExecutionException("No application context available in scheduler context for key applicationContext ");
        }
        return appCtx;
    }


    @SuppressWarnings("unchecked")
    protected <T> T getBean(JobExecutionContext jobexecutioncontext, Class<T> t, String beanName) throws Exception {
        ApplicationContext applicationContext = getApplicationContext(jobexecutioncontext);
        return (T) applicationContext.getBean(beanName);
    }

    protected <T> T getBean(JobExecutionContext jobexecutioncontext, Class<T> t) throws Exception {
        ApplicationContext applicationContext = getApplicationContext(jobexecutioncontext);
        return applicationContext.getBean(t);
    }
}
