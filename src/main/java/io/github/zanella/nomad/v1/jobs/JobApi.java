package io.github.zanella.nomad.v1.jobs;

import io.github.zanella.nomad.v1.common.models.Job;
import io.github.zanella.nomad.v1.jobs.models.JobAllocation;
import io.github.zanella.nomad.v1.jobs.models.JobEvalResult;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface JobApi {
    String jobUrl = "/v1/job/{jobId}";

    @RequestLine("GET " + jobUrl)
    Job getJob(@Param("jobId") String jobId);

    String jobAllocationsUrl = jobUrl + "/allocations";

    @RequestLine("GET " + jobAllocationsUrl)
    List<JobAllocation> getJobAllocations(@Param("jobId") String jobId);

    String jobEvaluationsUrl = jobUrl + "/evaluations";

    @RequestLine("GET " + jobEvaluationsUrl)
    List<JobEvaluation> getJobEvaluations(@Param("jobId") String jobId);

    String jobEvaluateUrl = jobUrl + "/evaluate";

    @RequestLine("PUT " + jobEvaluateUrl)
    JobEvalResult putJobEvaluate(@Param("jobId") String jobId);

    @RequestLine("DELETE " + jobUrl)
    JobEvalResult deleteJob(@Param("jobId") String jobId);
}
