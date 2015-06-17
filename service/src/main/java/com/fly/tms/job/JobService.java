package com.fly.tms.job;

import com.fly.tms.service.common.dto.PageListJson;
import com.fly.tms.job.dto.JobDto;
import com.fly.tms.job.dto.JobParameterSaveDto;
import org.quartz.SchedulerException;

import java.util.List;
import java.util.Map;

/**
 * Created by lixfn on 15-3-10.
 */
public interface JobService {
    PageListJson<JobDto> findJobs(Map<String, Object> searchParams) throws SchedulerException;

    void save(List<JobParameterSaveDto> jobList) throws Exception;

    void run() throws Exception;

    void stop() throws Exception;

    void run(JobParameterSaveDto jobDto) throws Exception;

    void stop(JobParameterSaveDto jobDto) throws Exception;

}
