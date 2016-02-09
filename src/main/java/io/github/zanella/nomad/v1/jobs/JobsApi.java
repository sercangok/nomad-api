package io.github.zanella.nomad.v1.jobs;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.jobs.models.JobEvalResult;
import io.github.zanella.nomad.v1.jobs.models.JobSpec;
import io.github.zanella.nomad.v1.jobs.models.JobSummary;

import java.util.List;

public interface JobsApi {
    String jobsUrl = "/v1/jobs";

    @RequestLine("GET " + jobsUrl)
    List<JobSummary> getJobs();

    @RequestLine("GET " + jobsUrl + "?region={region}")
    List<JobSummary> getJobsForRegion(@Param("region") String region);

    @RequestLine("POST " + jobsUrl)
    JobEvalResult postJob(JobSpec jobSpec);
}
