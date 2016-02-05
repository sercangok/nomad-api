package net.allenaz.nomad.v1.jobs;

import feign.Param;
import feign.RequestLine;
import net.allenaz.nomad.v1.jobs.models.Job;

import java.util.List;

public interface JobsApi {
    @RequestLine("GET /v1/jobs") List<Job> getJobs();

    @RequestLine("GET /v1/jobs?region={region}") List<Job> getJobsForRegion(@Param("region") String region);
}
