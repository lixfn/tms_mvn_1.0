package com.fly.tms.job.dto;

import com.fly.util.StringUtil;

/**
 * Created by lixfn on 15-3-10.
 */
public class JobDto {

    private String jobName;// 名称
    private String jobDesc;//job描述
    private String groupName;

    private String calendarName;
    private String description;
    private String endTime;
    private String finalFireTime;
    private String misfireInstruction;
    private String nextFireTime;
    private String previousFireTime;
    private String priority;
    private String startTime;
    private String cronExpression;
    private String triggerState;

    private boolean isRuning;
    private boolean used;
    private String timerName;
    private String className;

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getFinalFireTime() {
        return finalFireTime;
    }

    public void setFinalFireTime(String finalFireTime) {
        this.finalFireTime = finalFireTime;
    }

    public String getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(String misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    public String getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(String nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public String getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(String previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return job描述
     */
    public String getJobDesc() {
        return jobDesc;
    }

    /**
     * @param jobDesc job描述
     */
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    /**
     * @return 正在运行
     */
    public boolean isRuning() {
        return isRuning;
    }

    /**
     * @param isRuning 正在运行
     */
    public void setRuning(boolean isRuning) {
        this.isRuning = isRuning;
    }


    /**
     * @return 类名
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className 类名
     */
    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }

    public String getJobFullName() {
        return getJobName() + "_" + StringUtil.getNotNullString(getTimerName());
    }
}
