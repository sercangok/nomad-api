package io.github.zanella.nomad.v1.evaluations;

import io.github.zanella.nomad.v1.evaluations.model.EvaluationAllocation;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import java.util.List;

import feign.Param;
import feign.RequestLine;

public interface EvaluationApi {
    String evaluationUrl = "/v1/evaluation/{evaluationId}";

    @RequestLine("GET " + evaluationUrl)
    JobEvaluation getEvaluation(@Param("evaluationId") String evaluationId);

    String evaluationAllocationsUrl = evaluationUrl + "/allocations";

    @RequestLine("GET " + evaluationAllocationsUrl)
    List<EvaluationAllocation> getEvaluationAllocations(@Param("evaluationId") String evaluationId);
}
