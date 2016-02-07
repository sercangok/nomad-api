package io.github.zanella.nomad.v1.jobs;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.common.models.Job;

public interface JobApi {
    String jobUrl = "/v1/job";

    @RequestLine("GET " + jobUrl + "/{jobId}") Job getJob(@Param("jobId") String jobId);
}
