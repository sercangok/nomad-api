package io.github.zanella.nomad.v1.jobs;

import io.github.zanella.nomad.v1.jobs.models.JobEvalResult;
import io.github.zanella.nomad.v1.jobs.models.JobSpec;
import io.github.zanella.nomad.v1.jobs.models.JobSummary;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface JobsApi {
    String jobsUrl = "/v1/jobs";

    @RequestLine("GET " + jobsUrl)
    List<JobSummary> getJobs();

    String jobsForRegionUrl = jobsUrl + "?region={region}";

    @RequestLine("GET " + jobsForRegionUrl)
    List<JobSummary> getJobsForRegion(@Param("region") String region);

    @RequestLine("POST " + jobsUrl)
    JobEvalResult postJob(JobSpec jobSpec);
}
