package com.fly.tms.job.dto;

/**
 * Created by lixfn on 15-3-10.
 */
public class JobParameterSaveDto {
    /**
     * 定时名称
     */
    private String jobName;
    /**
     * 是否启用
     */
    private boolean used;
    /**
     * corn表达式
     */
    private String cronExpression;
    /**
     * 定时名称
     */
    private String timerName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }
}
