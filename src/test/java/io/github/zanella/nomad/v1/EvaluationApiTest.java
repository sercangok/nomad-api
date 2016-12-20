package io.github.zanella.nomad.v1;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.damnhandy.uri.template.UriTemplate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import io.github.zanella.nomad.v1.allocations.models.Allocation;
import io.github.zanella.nomad.v1.evaluations.EvaluationApi;
import io.github.zanella.nomad.v1.evaluations.model.EvaluationAllocation;
import io.github.zanella.nomad.v1.jobs.models.JobEvaluation;

import org.junit.Test;

import java.util.List;

public class EvaluationApiTest extends AbstractCommon {
    @Test
    public void getEvaluationTest() {
        final String rawEvaluation = "{" +
            "    \"ID\": \"151accaa-1ac6-90fe-d427-313e70ccbb88\"," +
            "    \"Priority\": 50," +
            "    \"Type\": \"service\"," +
            "    \"TriggeredBy\": \"job-register\"," +
            "    \"JobID\": \"binstore-storagelocker\"," +
            "    \"JobModifyIndex\": 14," +
            "    \"NodeID\": \"\"," +
            "    \"NodeModifyIndex\": 0," +
            "    \"Status\": \"complete\"," +
            "    \"StatusDescription\": \"\"," +
            "    \"Wait\": 0," +
            "    \"NextEval\": \"\"," +
            "    \"PreviousEval\": \"\"," +
            "    \"CreateIndex\": 15," +
            "    \"ModifyIndex\": 17" +
            "}";

        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(EvaluationApi.evaluationUrl).expand(ImmutableMap.of("evaluationId", "evaluationId"))))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(rawEvaluation))
        );

        final JobEvaluation expectedEvaluation = new JobEvaluation(
                "151accaa-1ac6-90fe-d427-313e70ccbb88",
                50,
                "service",
                "job-register",
                "binstore-storagelocker",
                14,
                "",
                0,
                "complete",
                "",
                0,
                "",
                "",
                15,
                2);

        final JobEvaluation actualEvaluation = nomadClient.v1.evaluation.getEvaluation("evaluationId");

        assertNotEquals(expectedEvaluation, actualEvaluation);

        expectedEvaluation.setModifyIndex(17);

        assertEquals(expectedEvaluation, actualEvaluation);
    }

    @Test
    public void getEvaluationAllocationsTest() {
        final String rawEvaluationAllocations = "[{" +
                "    \"ID\": \"3575ba9d-7a12-0c96-7b28-add168c67984\",\n" +
                "    \"EvalID\": \"151accaa-1ac6-90fe-d427-313e70ccbb88\",\n" +
                "    \"Name\": \"binstore-storagelocker.binsl[0]\",\n" +
                "    \"NodeID\": \"a703c3ca-5ff8-11e5-9213-970ee8879d1b\",\n" +
                "    \"JobID\": \"binstore-storagelocker\",\n" +
                "    \"TaskGroup\": \"binsl\",\n" +
                "    \"DesiredStatus\": \"run\",\n" +
                "    \"DesiredDescription\": \"\",\n" +
                "    \"ClientStatus\": \"running\",\n" +
                "    \"ClientDescription\": \"\",\n" +
                "    \"CreateIndex\": 16,\n" +
                "    \"ModifyIndex\": 16\n" +
                "}]";

        stubFor(get(urlEqualTo(UriTemplate.fromTemplate(EvaluationApi.evaluationAllocationsUrl).expand(ImmutableMap.of("evaluationId", "evaluationId"))))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(rawEvaluationAllocations))
        );

        final Allocation expectedAllocation = new Allocation();
        expectedAllocation.setId("3575ba9d-7a12-0c96-7b28-add168c67984");
        expectedAllocation.setEvalId("151accaa-1ac6-90fe-d427-313e70ccbb88");
        expectedAllocation.setName("binstore-storagelocker.binsl[0]");
        expectedAllocation.setNodeId("a703c3ca-5ff8-11e5-9213-970ee8879d1b");
        expectedAllocation.setJobId("binstore-storagelocker");
        expectedAllocation.setTaskGroup("binsl");
        expectedAllocation.setDesiredStatus("run");
        expectedAllocation.setDesiredDescription("");
        expectedAllocation.setClientDescription("");
        expectedAllocation.setClientStatus("running");
        expectedAllocation.setCreateIndex(16);
        expectedAllocation.setModifyIndex(16);

        final List<Allocation> expectedAllocationList = ImmutableList.of(expectedAllocation);
        final List<EvaluationAllocation> actualAllocationsList = nomadClient.v1.evaluation.getEvaluationAllocations("evaluationId");

        assertNotEquals(expectedAllocationList, actualAllocationsList);
    }
}
