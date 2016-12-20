package io.github.zanella.nomad.v1.evaluations;

import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface EvaluationsApi {
    String evaluationsUrl = "/v1/evaluations";

    @RequestLine("GET " + evaluationsUrl)
    List<JobEvaluation> getEvaluations();

    String evaluationsForRegionUrl = evaluationsUrl + "?region={region}";

    @RequestLine("GET " + evaluationsForRegionUrl)
    List<JobEvaluation> getEvaluationsForRegion(@Param("region") String region);
}
