package io.github.zanella.nomad.v1.jobs;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.common.models.Job;
import io.github.zanella.nomad.v1.jobs.models.JobAllocation;
import io.github.zanella.nomad.v1.jobs.models.JobEvalResult;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import java.util.List;

public interface JobApi {
    String jobUrl = "/v1/job";

    @RequestLine("GET " + jobUrl + "/{jobId}")
    Job getJob(@Param("jobId") String jobId);

    String allocationsUrl = "/allocations";

    @RequestLine("GET " + jobUrl + "/{jobId}" + allocationsUrl)
    List<JobAllocation> getJobAllocations(@Param("jobId") String jobId);

    String evaluationsUrl = "/evaluations";

    @RequestLine("GET " + jobUrl + "/{jobId}" + evaluationsUrl)
    List<JobEvaluation> getJobEvaluations(@Param("jobId") String jobId);

    String jobEvaluateUrl = "/evaluate";

    @RequestLine("PUT " + jobUrl + "/{jobId}" + jobEvaluateUrl)
    JobEvalResult putJobEvaluate(@Param("jobId") String jobId);

    @RequestLine("DELETE " + jobUrl + "/{jobId}")
    JobEvalResult deleteJob(@Param("jobId") String jobId);
}
