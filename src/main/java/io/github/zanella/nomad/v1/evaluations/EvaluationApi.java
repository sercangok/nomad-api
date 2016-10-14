package io.github.zanella.nomad.v1.evaluations;

import java.util.List;

import feign.Param;
import feign.RequestLine;
import io.github.zanella.nomad.v1.evaluations.model.EvaluationAllocation;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

public interface EvaluationApi {
    String evaluationUrl = "/v1/evaluation";

    @RequestLine("GET " + evaluationUrl + "/{evaluationId}")
    JobEvaluation getEvaluation(@Param("evaluationId") String evaluationId);

    @RequestLine("GET " + evaluationUrl + "/{evaluationId}" + "/allocations")
    List<EvaluationAllocation> getEvaluationAllocations(@Param("evaluationId") String evaluationId);
}
