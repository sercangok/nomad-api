package io.github.zanella.nomad.v1.evaluations;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import java.util.List;

public interface EvaluationsApi {
    String evaluationsUrl = "/v1/evaluations";

    @RequestLine("GET " + evaluationsUrl)
    List<JobEvaluation> getEvaluations();

    @RequestLine("GET " + evaluationsUrl + "?region={region}")
    List<JobEvaluation> getEvaluationsOfRegion(@Param("region") String region);
}
